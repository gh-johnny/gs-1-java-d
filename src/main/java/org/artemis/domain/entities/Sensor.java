package org.artemis.domain.entities;

public class Sensor {
    private String id;
    private String localizacao;
    private String tipo;

    public Sensor() {}

    public Sensor(String id, String localizacao, String tipo) {
        this.id = id;
        this.localizacao = localizacao;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Sensor{id='" + id + "', localizacao='" + localizacao + "', tipo='" + tipo + "'}";
    }
}