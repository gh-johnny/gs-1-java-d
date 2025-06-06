package org.artemis.application;

import org.artemis.domain.entities.EquipeResgate;
import org.artemis.infrastructure.repositories.EquipeResgateRepository;
import org.artemis.domain.entities.Incidente;
import org.artemis.infrastructure.repositories.IncidenteRepository;

import java.util.List;

public class IncidenteService {
    private IncidenteRepository incidenteRepository = new IncidenteRepository();
    private EquipeResgateRepository equipeRepository = new EquipeResgateRepository();

    public boolean atribuirEquipeAIncidente(String idAlerta, String idEquipe) {
        // Busca incidente ativo relacionado ao alerta (simplificação)
        List<Incidente> incidentes = incidenteRepository.buscarTodos();
        Incidente incidente = incidentes.stream()
                .filter(i -> i.getStatus().equals("ATIVO") && i.getEquipeAtribuidaId() == null)
                .findFirst()
                .orElse(null);

        if (incidente == null) {
            return false;
        }

        EquipeResgate equipe = equipeRepository.buscarPorId(idEquipe);
        if (equipe == null || !equipe.isDisponivel()) {
            return false;
        }

        // Atribui equipe ao incidente
        incidente.setEquipeAtribuidaId(idEquipe);
        incidenteRepository.atualizar(incidente);

        // Marca equipe como indisponível
        equipe.setDisponivel(false);
        equipeRepository.atualizar(equipe);

        return true;
    }

    public List<Incidente> listarTodosIncidentes() {
        return incidenteRepository.buscarTodos();
    }
}