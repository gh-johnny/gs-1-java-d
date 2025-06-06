package org.artemis.application;

import org.artemis.domain.entities.EquipeResgate;
import org.artemis.infrastructure.repositories.EquipeResgateRepository;

import java.util.List;

public class EquipeResgateService {
    private EquipeResgateRepository equipeRepository = new EquipeResgateRepository();

    public void criarEquipe(String id, String nome, String localizacao) {
        EquipeResgate equipe = new EquipeResgate(id, nome, localizacao, true);
        equipeRepository.salvar(equipe);
    }

    public EquipeResgate buscarEquipePorId(String id) {
        return equipeRepository.buscarPorId(id);
    }

    public List<EquipeResgate> listarTodasEquipes() {
        return equipeRepository.buscarTodos();
    }

    public void atualizarDisponibilidade(String idEquipe, boolean disponivel) {
        EquipeResgate equipe = equipeRepository.buscarPorId(idEquipe);
        if (equipe != null) {
            equipe.setDisponivel(disponivel);
            equipeRepository.atualizar(equipe);
        }
    }

    public void atualizarLocalizacao(String idEquipe, String localizacao, boolean disponivel) {
        EquipeResgate equipe = equipeRepository.buscarPorId(idEquipe);
        if (equipe != null) {
            equipe.atualizarLocalizacao(localizacao, disponivel);
        }
    }
}