package com.escola.chambule.models;
import java.util.Objects;
public class AlunoModel extends DisciplinasModel {

    private Integer id;
    private Integer codigoAluno;
    private String nome;
    private String curso ;
    private Integer anoCurso;
    private double mediaAtual;

    public AlunoModel(){}

    public AlunoModel(Integer codigoAluno,double mediaAtual){
        this.codigoAluno = codigoAluno;
        this.mediaAtual = mediaAtual;
    }

    public AlunoModel(Integer id, Integer codigoAluno, String nome, String curso, Integer anoCurso, double mediaAtual) {
        this.id = id;
        this.codigoAluno = codigoAluno;
        this.nome = nome;
        this.curso = curso;
        this.anoCurso = anoCurso;
        this.mediaAtual = mediaAtual;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCodigoAluno() {
        return codigoAluno;
    }
    public void setCodigoAluno(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public Integer getAnoCurso() {
        return anoCurso;
    }
    public void setAnoCurso(Integer anoCurso) {
        this.anoCurso = anoCurso;
    }
    public double getMediaAtual() {
        return mediaAtual;
    }
    public void setMediaAtual(double mediaAtual) {
        this.mediaAtual = mediaAtual;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlunoModel that = (AlunoModel) o;
        return Objects.equals(codigoAluno, that.codigoAluno);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(codigoAluno);
    }

    @Override
    public String toString() {
        return "Codigo: "+getCodigoAluno()+"\n"+"Nome do Aluno: "+getNome()+"\n"+"Curso: "+getCurso()+"\n"+"Ano curso: "+getAnoCurso()+"\n"+"Media Atual: "+getMediaAtual();
    }
}
