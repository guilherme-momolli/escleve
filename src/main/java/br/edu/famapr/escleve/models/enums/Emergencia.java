package br.edu.famapr.escleve.models.enums;

public enum Emergencia {
    SAUDE("Saúde"),
    POLICIAL("Polícial"),
    BOMBEIROS("Bombeiros");
    private String emergencia;

    Emergencia(String emergencia) {
        this.emergencia = emergencia;
    }

    public String getEmergencia() {
        return emergencia;
    }
}
