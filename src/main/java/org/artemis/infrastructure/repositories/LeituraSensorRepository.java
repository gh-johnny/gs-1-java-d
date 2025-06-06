package org.artemis.infrastructure.repositories;

import org.artemis.domain.entities.LeituraSensor;

import java.util.ArrayList;
import java.util.List;

public class LeituraSensorRepository {
    private List<LeituraSensor> leituras = new ArrayList<>();

    public void salvar(LeituraSensor leitura) {
        leituras.add(leitura);
    }

    public LeituraSensor buscarPorId(String id) {
        return leituras.stream()
                .filter(l -> l.getIdLeitura().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<LeituraSensor> buscarTodos() {
        return new ArrayList<>(leituras);
    }
}