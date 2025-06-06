package org.artemis.infrastructure.repositories;

import org.artemis.domain.entities.Alerta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlertaRepository {
    private List<Alerta> alertas = new ArrayList<>();

    public void salvar(Alerta alerta) {
        alertas.add(alerta);
    }

    public Alerta buscarPorId(String id) {
        return alertas.stream()
                .filter(a -> a.getIdAlerta().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Alerta> buscarTodos() {
        return new ArrayList<>(alertas);
    }

    public List<Alerta> buscarAtivos() {
        return alertas.stream()
                .filter(a -> !a.isResolvido())
                .collect(Collectors.toList());
    }
}