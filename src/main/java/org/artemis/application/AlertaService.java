package org.artemis.application;


import org.artemis.domain.entities.Alerta;
import org.artemis.domain.entities.Incidente;
import org.artemis.domain.entities.LeituraSensor;
import org.artemis.domain.entities.Sensor;
import org.artemis.infrastructure.repositories.AlertaRepository;
import org.artemis.infrastructure.repositories.IncidenteRepository;
import org.artemis.infrastructure.repositories.LeituraSensorRepository;
import org.artemis.infrastructure.repositories.SensorRepository;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AlertaService {
    private AlertaRepository alertaRepository = new AlertaRepository();
    private LeituraSensorRepository leituraRepository = new LeituraSensorRepository();
    private SensorRepository sensorRepository = new SensorRepository();
    private IncidenteRepository incidenteRepository = new IncidenteRepository();
    private int contadorAlerta = 1;
    private int contadorIncidente = 1;

    public void processarLeituraSensor(String idLeitura, String sensorId, double valor, String unidade) {
        // Salvar leitura
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LeituraSensor leitura = new LeituraSensor(idLeitura, sensorId, valor, unidade, timestamp);
        leituraRepository.salvar(leitura);

        // Avaliar risco e criar alerta se necessário
        String nivelRisco = avaliarRisco(valor, unidade);
        if (!nivelRisco.equals("BAIXO")) {
            criarAlerta(leitura, nivelRisco);
        }
    }

    private String avaliarRisco(double valor, String unidade) {
        // Lógica simplificada de avaliação de risco
        if (unidade.equals("°C") && valor > 35) {
            return "CRITICO";
        } else if (unidade.equals("°C") && valor > 30) {
            return "ALTO";
        } else if (unidade.equals("%") && valor < 15) {
            return "CRITICO";
        } else if (unidade.equals("%") && valor < 20) {
            return "ALTO";
        } else if ((unidade.equals("°C") && valor > 25) || (unidade.equals("%") && valor < 30)) {
            return "MEDIO";
        }
        return "BAIXO";
    }

    public void criarAlerta(LeituraSensor leitura, String nivelRisco) {
        String idAlerta = "A" + String.format("%03d", contadorAlerta++);
        Sensor sensor = sensorRepository.buscarPorId(leitura.getSensorId());

        String mensagem = String.format("Risco %s de incêndio na %s devido a %s com valor %.2f %s",
                nivelRisco,
                sensor != null ? sensor.getLocalizacao() : "localização desconhecida",
                sensor != null ? sensor.getTipo() : "sensor desconhecido",
                leitura.getValor(),
                leitura.getUnidade());

        Alerta alerta = new Alerta(idAlerta, leitura.getIdLeitura(), nivelRisco, mensagem, leitura.getTimestamp());
        alertaRepository.salvar(alerta);

        // Criar incidente correspondente
        if (nivelRisco.equals("ALTO") || nivelRisco.equals("CRITICO")) {
            criarIncidente(alerta, sensor);
        }
    }

    private void criarIncidente(Alerta alerta, Sensor sensor) {
        String idIncidente = "I" + String.format("%03d", contadorIncidente++);
        String localizacao = sensor != null ? sensor.getLocalizacao() : "Localização desconhecida";

        Incidente incidente = new Incidente(idIncidente, localizacao, alerta.getNivelRisco(), "ATIVO", null);
        incidenteRepository.salvar(incidente);
    }

    public List<Alerta> listarAlertasAtivos() {
        return alertaRepository.buscarAtivos();
    }

    public List<Alerta> listarTodosAlertas() {
        return alertaRepository.buscarTodos();
    }

    public Alerta buscarAlertaPorId(String id) {
        return alertaRepository.buscarPorId(id);
    }
}