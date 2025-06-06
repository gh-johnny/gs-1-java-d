package org.artemis.infrastructure.repositories;

import org.artemis.domain.entities.EquipeResgate;

import java.util.ArrayList;
import java.util.List;

public class EquipeResgateRepository {
    private List<EquipeResgate> equipes = new ArrayList<>();

    public void salvar(EquipeResgate equipe) {
        equipes.add(equipe);
    }

    public EquipeResgate buscarPorId(String id) {
        return equipes.stream()
                .filter(e -> e.getIdEquipe().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<EquipeResgate> buscarTodos() {
        return new ArrayList<>(equipes);
    }

    public void atualizar(EquipeResgate equipe) {
        for (int i = 0; i < equipes.size(); i++) {
            if (equipes.get(i).getIdEquipe().equals(equipe.getIdEquipe())) {
                equipes.set(i, equipe);
                break;
            }
        }
    }
}