package org.artemis.domain.entities;

public class LeituraSensor {
    private String idLeitura;
    private String sensorId;
    private double valor;
    private String unidade;
    private String timestamp;

    public LeituraSensor() {}

    public LeituraSensor(String idLeitura, String sensorId, double valor, String unidade, String timestamp) {
        this.idLeitura = idLeitura;
        this.sensorId = sensorId;
        this.valor = valor;
        this.unidade = unidade;
        this.timestamp = timestamp;
    }

    // Getters e Setters
    public String getIdLeitura() { return idLeitura; }
    public void setIdLeitura(String idLeitura) { this.idLeitura = idLeitura; }

    public String getSensorId() { return sensorId; }
    public void setSensorId(String sensorId) { this.sensorId = sensorId; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "LeituraSensor{idLeitura='" + idLeitura + "', sensorId='" + sensorId +
                "', valor=" + valor + ", unidade='" + unidade + "', timestamp='" + timestamp + "'}";
    }
}