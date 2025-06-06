package org.artemis.infrastructure.repositories;

import org.artemis.domain.entities.Incidente;

import java.util.ArrayList;
import java.util.List;

public class IncidenteRepository {
    private List<Incidente> incidentes = new ArrayList<>();

    public void salvar(Incidente incidente) {
        incidentes.add(incidente);
    }

    public Incidente buscarPorId(String id) {
        return incidentes.stream()
                .filter(i -> i.getIdIncidente().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Incidente> buscarTodos() {
        return new ArrayList<>(incidentes);
    }

    public void atualizar(Incidente incidente) {
        for (int i = 0; i < incidentes.size(); i++) {
            if (incidentes.get(i).getIdIncidente().equals(incidente.getIdIncidente())) {
                incidentes.set(i, incidente);
                break;
            }
        }
    }
}