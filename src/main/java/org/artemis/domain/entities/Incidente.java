package org.artemis.domain.entities;

public class Incidente {
    private String idIncidente;
    private String localizacao;
    private String nivelRisco;
    private String status;
    private String equipeAtribuidaId;

    public Incidente() {}

    public Incidente(String idIncidente, String localizacao, String nivelRisco, String status, String equipeAtribuidaId) {
        this.idIncidente = idIncidente;
        this.localizacao = localizacao;
        this.nivelRisco = nivelRisco;
        this.status = status;
        this.equipeAtribuidaId = equipeAtribuidaId;
    }

    // Getters e Setters
    public String getIdIncidente() { return idIncidente; }
    public void setIdIncidente(String idIncidente) { this.idIncidente = idIncidente; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getNivelRisco() { return nivelRisco; }
    public void setNivelRisco(String nivelRisco) { this.nivelRisco = nivelRisco; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getEquipeAtribuidaId() { return equipeAtribuidaId; }
    public void setEquipeAtribuidaId(String equipeAtribuidaId) { this.equipeAtribuidaId = equipeAtribuidaId; }

    /**
     * Representa o incidente em formato de texto.
     *
     * @return uma string formatada com os principais dados do incidente.
     */
    @Override
    public String toString() {
        var riscoAlto = this.isCritico(nivelRisco);
        var isRiscoAlto = "Sim";
        if(!riscoAlto)
             isRiscoAlto = "Não";

        return "Incidente -> idIncidente='" + idIncidente + "', localizacao='" + localizacao + "', alto nível de risco='" + isRiscoAlto +
                "', nivelRisco='" + nivelRisco + "', status='" + status +
                "', equipeAtribuidaId='" + equipeAtribuidaId + "'";
    }

    /**
     * Verifica se o nível de risco é crítico.
     *
     * @return true se o nível de risco for "Alto", false caso contrário.
     */
    public boolean isCritico() {
        return "Alto".equalsIgnoreCase(this.nivelRisco);
    }

    /**
     * Verifica se o nível de risco informado é crítico.
     *
     * @param nivelRisco o nível de risco a ser avaliado.
     * @return true se o nível de risco for "Alto", false caso contrário.
     */
    public boolean isCritico(String nivelRisco) {
        return "Alto".equalsIgnoreCase(nivelRisco);
    }
}