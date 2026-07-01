package escola.models;
public class DisciplinasModel {

    private Integer id_disciplina;
    private String nomeDisciplina;

    public DisciplinasModel(){}

    public DisciplinasModel(Integer id_disciplina,String nomeDisciplina) {
        this.id_disciplina = id_disciplina;
        this.nomeDisciplina = nomeDisciplina;
    }


    public Integer getId_disciplina() {
        return id_disciplina;
    }
    public void setId_disciplina(Integer id_disciplina) {
        this.id_disciplina = id_disciplina;
    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}
