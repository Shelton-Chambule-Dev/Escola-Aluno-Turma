package escola.models;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Aluno")
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_aluno;

    @Column(name = "nome")
    private String nome;

    @Column(name = "curso")
    private String curso ;

    @Column(name = "Ano_curso")
    private Integer anoCurso;

    @Column(name = "Media_atual")
    private double mediaAtual;

    @OneToMany
    @JoinColumn(name = "Disicplinas")
    private List<DisciplinasModel> disciplinasModels;

    public AlunoModel(Integer codigoAluno,double mediaAtual){
        this.mediaAtual = mediaAtual;
    }

    public AlunoModel(Integer id_aluno, String nome, String curso, Integer anoCurso, double mediaAtual, List<DisciplinasModel> disciplinasModels) {
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.curso = curso;
        this.anoCurso = anoCurso;
        this.mediaAtual = mediaAtual;
        this.disciplinasModels = disciplinasModels;
    }

    public Integer getId_aluno() {
        return id_aluno;
    }
    public void setId_aluno(Integer id) {
        this.id_aluno = id;
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
        return Objects.equals(id_aluno, that.id_aluno);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id_aluno);
    }
}
