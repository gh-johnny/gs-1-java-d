package org.artemis.application;

import org.artemis.domain.entities.Sensor;
import org.artemis.infrastructure.repositories.SensorRepository;

import java.util.List;

public class SensorService {
    private SensorRepository sensorRepository = new SensorRepository();

    public void criarSensor(String id, String localizacao, String tipo) {
        Sensor sensor = new Sensor(id, localizacao, tipo);
        sensorRepository.salvar(sensor);
    }

    public Sensor buscarSensorPorId(String id) {
        return sensorRepository.buscarPorId(id);
    }

    public List<Sensor> listarTodosSensores() {
        return sensorRepository.buscarTodos();
    }
}