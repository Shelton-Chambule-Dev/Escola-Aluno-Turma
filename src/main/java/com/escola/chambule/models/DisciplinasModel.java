package com.escola.chambule.models;
public class DisciplinasModel {

    private String nomeDisciplina;
    private Integer codigoDisciplina;

    public DisciplinasModel(){}

    public DisciplinasModel(String nomeDisciplina, Integer codigoDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.codigoDisciplina = codigoDisciplina;
    }


    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    public Integer getCodigoDisciplina() {
        return codigoDisciplina;
    }
    public void setCodigoDisciplina(Integer codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }
}
