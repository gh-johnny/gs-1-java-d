package org.artemis.domain.entities;

public class EquipeResgate {
    private String idEquipe;
    private String nome;
    private String localizacaoAtual;
    private boolean disponivel;

    public EquipeResgate() {}

    public EquipeResgate(String idEquipe, String nome, String localizacaoAtual, boolean disponivel) {
        this.idEquipe = idEquipe;
        this.nome = nome;
        this.localizacaoAtual = localizacaoAtual;
        this.disponivel = disponivel;
    }

    // Getters e Setters
    public String getIdEquipe() { return idEquipe; }
    public void setIdEquipe(String idEquipe) { this.idEquipe = idEquipe; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLocalizacaoAtual() { return localizacaoAtual; }
    public void setLocalizacaoAtual(String localizacaoAtual) { this.localizacaoAtual = localizacaoAtual; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    @Override
    public String toString() {
        return "EquipeResgate{idEquipe='" + idEquipe + "', nome='" + nome +
                "', localizacaoAtual='" + localizacaoAtual + "', disponivel=" + disponivel + "}";
    }

    /**
     * Atualiza a localização atual da equipe e define sua disponibilidade.
     *
     * @param novaLocalizacao a nova localização da equipe.
     * @param estaDisponivel status de disponibilidade da equipe após atualização.
     * @return mensagem de confirmação da atualização.
     */
    public String atualizarLocalizacao(String novaLocalizacao, boolean estaDisponivel) {
        this.localizacaoAtual = novaLocalizacao;
        this.disponivel = estaDisponivel;
        return "Equipe atualizada para " + novaLocalizacao + " | Disponível: " + estaDisponivel;
    }

}