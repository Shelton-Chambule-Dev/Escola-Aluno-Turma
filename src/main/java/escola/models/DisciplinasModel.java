package escola.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "disciplina")
public class DisciplinasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_disciplina")
    private Integer id_disciplina;

    @Column(name = "Nome_disciplina")
    private String nomeDisciplina;

    @OneToMany
    @JoinColumn(name = "codigo_Aluno")
    private List<AlunoModel> alunoModels;

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
