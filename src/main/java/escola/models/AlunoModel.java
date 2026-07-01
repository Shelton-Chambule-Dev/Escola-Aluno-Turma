package escola.models;
import java.util.Objects;
public class AlunoModel extends  DisciplinasModel {

    private Integer id_aluno;
    private String nome;
    private String curso ;
    private Integer anoCurso;
    private double mediaAtual;

    public AlunoModel(){}

    public AlunoModel(Integer codigoAluno,double mediaAtual){
        this.mediaAtual = mediaAtual;
    }

    public AlunoModel(Integer id_aluno,String nome, String curso, Integer anoCurso, double mediaAtual, Integer id_disciplina, String nomeDisciplina) {
        super(id_disciplina, nomeDisciplina);
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.curso = curso;
        this.anoCurso = anoCurso;
        this.mediaAtual = mediaAtual;
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
