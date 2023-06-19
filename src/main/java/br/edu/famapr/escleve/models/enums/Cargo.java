package br.edu.famapr.escleve.models.enums;

public enum Cargo {

    DIRETOR("Diretor"),
    PEDAGOGO("Pedagogo"),
    SECRETARIO("Secretario"),
    PROFESSOR("Professor"),
    SERVICOS_GERAIS("Servicos Gerais");

    private String cargo;

    Cargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}
