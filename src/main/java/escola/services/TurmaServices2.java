package escola.services;
import escola.DataBase.DataBaseConnetion;
import escola.exceptions.TurmaException;
import escola.models.AlunoModel;
import escola.repository.TurmaRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
public class TurmaServices2 implements TurmaRepository {

    @Override
    public Boolean save(AlunoModel alunoModel) {
                 PreparedStatement prst = null;
            try(Connection connection = DataBaseConnetion.getInstance().connection()){
                prst = connection.prepareStatement( "INSERT INTO turma(nome_aluno , nome_curso , ano_curso , media_atual, disciplina_Id , nome_disciplna) VALUES (?,?,?,?,?,?)" );
                prst.setString(1,alunoModel.getNome());
                prst.setString(2,alunoModel.getCurso());
                prst.setInt(3,alunoModel.getAnoCurso());
                prst.setDouble(4,alunoModel.getMediaAtual());
                prst.setInt(5,alunoModel.getId_disciplina());
                prst.setString(6,alunoModel.getNomeDisciplina());
                prst.executeUpdate();
            }catch (SQLException ex){
                throw  new TurmaException(ex.getMessage());
            }finally {
                DataBaseConnetion.closeStatement(prst);
            }
        return true;
    }

    @Override
    public Optional<AlunoModel> findById(Integer codigo) {
                    ResultSet rs = null;
                    PreparedStatement prst = null;
        try(Connection connection = DataBaseConnetion.getInstance().connection()){
             prst = connection.prepareStatement("SELECT  id_aluno , nome_aluno , nome_curso , ano_curso , media_atual, disciplina_Id, nome_disciplna FROM turma WHERE id_aluno = ?");
            prst.setInt(1,codigo);

             rs = prst.executeQuery();

            if (rs.next()){
                Integer id = rs.getInt("Id_aluno");
                String nome = rs.getString("nome_aluno");
                String nome_curso = rs.getString("nome_curso");
                Integer ano_curso = rs.getInt("ano_curso");
                double media_atual = rs.getDouble("media_atual");
                Integer id_disciplina = rs.getInt("disciplina_Id");
                String nome_disciplina = rs.getString("nome_disciplna");

                AlunoModel alunoModel = new AlunoModel( id,nome , nome_curso , ano_curso , media_atual ,  id_disciplina , nome_disciplina);
                return Optional.of(alunoModel);
            }
        }catch (SQLException ex){
            throw new TurmaException("Erro: codigo nao encontrado!" + ex.getMessage());
        }finally {
            DataBaseConnetion.closeStatement(prst);
            DataBaseConnetion.closeResulSet(rs);
        }
        return Optional.empty();
    }

    @Override
    public AlunoModel update (AlunoModel alunoModel) {
                     PreparedStatement prst = null;
                try(Connection connection = DataBaseConnetion.getInstance().connection()){
                   prst = connection.prepareStatement( "UPDATE  turma SET   nome_aluno = ? , nome_curso = ? , ano_curso = ? , media_atual = ? , disciplina_Id = ? , nome_disciplna = ? WHERE id_aluno = ?");
                   prst.setString(1,alunoModel.getNome());
                   prst.setString(2,alunoModel.getCurso());
                   prst.setInt(3,alunoModel.getAnoCurso());
                   prst.setDouble(4,alunoModel.getMediaAtual());
                   prst.setInt(5,alunoModel.getId_disciplina());
                   prst.setString(6,alunoModel.getNomeDisciplina());
                   prst.setInt(7,alunoModel.getId_aluno());
                    prst.executeUpdate();
                }catch (SQLException ex){
                    throw new TurmaException(ex.getMessage());
                }finally {
                    DataBaseConnetion.closeStatement(prst);
                }
              return alunoModel;
    }

    @Override
    public Optional<AlunoModel> remove(Integer codigoAluno) {
                 PreparedStatement prst = null;
            try(Connection connection = DataBaseConnetion.getInstance().connection()) {
                 prst = connection.prepareStatement("DELETE FROM turma WHERE id_aluno = ?");
                prst.setInt(1,codigoAluno);
                prst.executeUpdate();
            }catch (SQLException ex){
                throw  new TurmaException("Erro codigo nao encontrado!: "+ex.getMessage());
            }finally {
                DataBaseConnetion.closeStatement(prst);
            }
            return Optional.empty();
    }

    @Override
    public int numeroTotalAluno() {
                 PreparedStatement prst = null;
                 ResultSet rs = null;
                int total = 0;
            try(Connection connection =  DataBaseConnetion.getInstance().connection()){
                 prst = connection.prepareStatement("SELECT COUNT(*) FROM turma");

                 rs = prst.executeQuery();
                if(rs.next()){
                  total = rs.getInt(1);
                }
            }catch (SQLException ex){
                throw new TurmaException(ex.getMessage());
            }finally {
                DataBaseConnetion.closeStatement(prst);
                DataBaseConnetion.closeResulSet(rs);
            }
        return total;
    }

    @Override
    public Set<AlunoModel> findAll() {
        ResultSet rs = null;
        PreparedStatement prst = null;

        Set<AlunoModel> alunoModels = new HashSet<>();

       try(Connection connection = DataBaseConnetion.getInstance().connection()){
           prst = connection.prepareStatement("SELECT id_aluno, nome_aluno , nome_curso , ano_curso , media_atual, disciplina_Id, nome_disciplna FROM turma");

            rs = prst.executeQuery();
           while(rs.next()){
               Integer id = rs.getInt("id_aluno");
               String nome = rs.getString("nome_aluno");
               String nome_curso = rs.getString("nome_curso");
               Integer ano_curso = rs.getInt("ano_curso");
               double media_atual = rs.getDouble("media_atual");
               Integer id_disciplina = rs.getInt("disciplina_Id");
               String nome_disciplina = rs.getString("nome_disciplna");
               AlunoModel alunoModel = new AlunoModel (id,nome,nome_curso,ano_curso,media_atual ,id_disciplina , nome_disciplina);
               alunoModels.add(alunoModel);
           }
       }catch (SQLException ex) {
                throw  new TurmaException("Erro ao fazer buscas : " +ex.getMessage());
        }finally {
           DataBaseConnetion.closeStatement(prst);
           DataBaseConnetion.closeResulSet(rs);
       }
        return alunoModels;
    }

    @Override
    public Set<AlunoModel> mediaSuperior(double media) {
                        ResultSet rs =  null;
                        PreparedStatement prst = null;
                        Set<AlunoModel> aluno = new HashSet<>();
                    try(Connection connection = DataBaseConnetion.getInstance().connection()){
                         prst = connection.prepareStatement(        "SELECT codigo_aluno, media_atual ,COUNT(*) FROM turma WHERE media_atual = ? GROUP BY codigo_aluno , media_atual");
                        prst.setDouble(1,media);

                         rs = prst.executeQuery();

                        while(rs.next()){
                            Integer codigo_aluno = rs.getInt("codigo_aluno");
                            double media_atual = rs.getDouble("media_atual");
                            AlunoModel turma = new AlunoModel(codigo_aluno,media_atual);
                            aluno.add(turma);
                        }
                    }catch (SQLException ex){
                        throw new TurmaException("Media Invalida: " +ex.getMessage());
                    }finally {
                        DataBaseConnetion.closeStatement(prst);
                        DataBaseConnetion.closeResulSet(rs);
                    }
        return aluno;
    }

    @Override
    public void alterarNomeAluno(AlunoModel alunoModel) {
        PreparedStatement prst = null;
        try(Connection connection = DataBaseConnetion.getInstance().connection()){
            prst = connection.prepareStatement( "UPDATE  turma SET  nome = ? WHERE id_aluno = ?");
            prst.setString(1,alunoModel.getNome());
            prst.setInt(2,alunoModel.getId_aluno());
            prst.executeUpdate();
        }catch (SQLException ex){
            throw  new TurmaException("Falha ao aualizar o nome: " + ex.getMessage());
        }finally {
            DataBaseConnetion.closeStatement(prst);
        }
    }

    @Override
    public Boolean alterarMedia(AlunoModel alunoModel) {
        PreparedStatement prst = null;
        try(Connection connection = DataBaseConnetion.getInstance().connection()){
            prst = connection.prepareStatement("UPDATE turma SET media_atual = ? WHERE id_aluno = ?");
            prst.setDouble(1,alunoModel.getMediaAtual());
            prst.setInt(2,alunoModel.getId_aluno());
            prst.executeUpdate();
        } catch (SQLException e) {
            throw new TurmaException("Falha ao atualizar a media: " +e.getMessage());
        }finally {
            DataBaseConnetion.closeStatement(prst);
        }
        return true;
    }
}
