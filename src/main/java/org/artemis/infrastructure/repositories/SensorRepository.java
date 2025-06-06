package org.artemis.infrastructure.repositories;

import org.artemis.domain.entities.Sensor;

import java.util.ArrayList;
import java.util.List;

public class SensorRepository {
    private List<Sensor> sensores = new ArrayList<>();

    public void salvar(Sensor sensor) {
        sensores.add(sensor);
    }

    public Sensor buscarPorId(String id) {
        return sensores.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Sensor> buscarTodos() {
        return new ArrayList<>(sensores);
    }
}