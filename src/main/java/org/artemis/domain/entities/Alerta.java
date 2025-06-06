package org.artemis.domain.entities;

public class Alerta {
    private String idAlerta;
    private String leituraId;
    private String nivelRisco;
    private String mensagem;
    private String timestamp;
    private boolean resolvido;

    public Alerta() {}

    public Alerta(String idAlerta, String leituraId, String nivelRisco, String mensagem, String timestamp) {
        this.idAlerta = idAlerta;
        this.leituraId = leituraId;
        this.nivelRisco = nivelRisco;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
        this.resolvido = false;
    }

    // Getters e Setters
    public String getIdAlerta() { return idAlerta; }
    public void setIdAlerta(String idAlerta) { this.idAlerta = idAlerta; }

    public String getLeituraId() { return leituraId; }
    public void setLeituraId(String leituraId) { this.leituraId = leituraId; }

    public String getNivelRisco() { return nivelRisco; }
    public void setNivelRisco(String nivelRisco) { this.nivelRisco = nivelRisco; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public boolean isResolvido() { return resolvido; }
    public void setResolvido(boolean resolvido) { this.resolvido = resolvido; }

    @Override
    public String toString() {
        return "Alerta{idAlerta='" + idAlerta + "', nivelRisco='" + nivelRisco +
                "', mensagem='" + mensagem + "', timestamp='" + timestamp +
                "', resolvido=" + resolvido + "}";
    }
}