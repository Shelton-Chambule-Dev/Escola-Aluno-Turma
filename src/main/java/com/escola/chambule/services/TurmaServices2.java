package com.escola.chambule.services;
import com.escola.chambule.DataBase.DataBaseConnetiom;
import com.escola.chambule.exceptions.TurmaException;
import com.escola.chambule.models.AlunoModel;
import com.escola.chambule.repository.TurmaRepository;
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
     String sql = "INSERT INTO turma(codigo_aluno , nome , nome_curso , ano_curso , media_atual ) VALUES(?,?,?,?,?)";
            try(Connection connection = DataBaseConnetiom.getInstance().connection()){
                PreparedStatement prst = connection.prepareStatement(sql);
                prst.setInt(1,alunoModel.getCodigoAluno());
                prst.setString(2,alunoModel.getNome());
                prst.setString(3,alunoModel.getCurso());
                prst.setInt(4,alunoModel.getAnoCurso());
                prst.setDouble(5,alunoModel.getMediaAtual());
                prst.executeUpdate();
            }catch (SQLException ex){
                throw  new TurmaException("Erro: Cadastro cliente");
            }
        return true;
    }

    @Override
    public Optional<AlunoModel> findById(Integer codigo) {
        String sql = "SELECT  id, codigo_aluno , nome , nome_curso , ano_curso , media_atual FROM turma WHERE id = ?";
        try(Connection connection = DataBaseConnetiom.getInstance().connection()){
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1,codigo);

            ResultSet rs = prst.executeQuery();

            if (rs.next()){
                Integer id = rs.getInt("id");
                Integer codigo_aluno = rs.getInt("codigo_aluno");
                String nome = rs.getString("nome");
                String nome_curso = rs.getString("nome_curso");
                Integer ano_curso = rs.getInt("ano_curso");
                double media_atual = rs.getInt("media_atual");

                AlunoModel alunoModel = new AlunoModel( id,codigo_aluno,nome,nome_curso,ano_curso,media_atual);
                return Optional.of(alunoModel);
            }
        }catch (SQLException ex){
            throw new TurmaException("Erro: codigo nao encontrado!");
        }
        return Optional.empty();
    }

    //Atualizar dados do aluno/estudante
    @Override
    public AlunoModel update (AlunoModel alunoModel) {
                     String sql = "UPDATE  turma SET  codigo_aluno = ?, nome = ?, nome_curso = ?, ano_curso = ?, media_atual = ? WHERE id = ?";
                try(Connection connection = DataBaseConnetiom.getInstance().connection()){
                    PreparedStatement prst = connection.prepareStatement(sql);

                    prst.setInt(1,alunoModel.getCodigoAluno());
                    prst.setString(2,alunoModel.getNome());
                    prst.setString(3,alunoModel.getCurso());
                    prst.setInt(4,alunoModel.getAnoCurso());
                    prst.setDouble(5,alunoModel.getMediaAtual());
                    prst.setInt(6,alunoModel.getId());
                    prst.executeUpdate();

                }catch (SQLException ex){
                    throw new RuntimeException(ex);
                }
              return alunoModel;
    }

    @Override
    public Optional<AlunoModel> remove(Integer codigoAluno) {
            String sql = "DELETE FROM turma WHERE id = ?";
            try(Connection connection = DataBaseConnetiom.getInstance().connection()) {
                PreparedStatement prst = connection.prepareStatement(sql);
                prst.setInt(1,codigoAluno);
                prst.executeUpdate();
            }catch (SQLException ex){
                throw  new TurmaException("Erro codigo nao encontrado!");
            }
            return Optional.empty();
    }

    @Override
    public int numeroTotalAluno() {
            String sql = "SELECT COUNT (*) AS total FROM turma ";
                int total = 0;
            try(Connection connection =  DataBaseConnetiom.getInstance().connection()){
                PreparedStatement prst = connection.prepareStatement(sql);

                ResultSet rs = prst.executeQuery();
                if(rs.next()){
                  total = rs.getInt("total");
                }

            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        return total;
    }

    @Override
    public Set<AlunoModel> findAll() {
        Set<AlunoModel> alunoModels = new HashSet<>();

       String sql = "SELECT id, codigo_aluno , nome , nome_curso , ano_curso , media_atual FROM turma";
       try(Connection connection = DataBaseConnetiom.getInstance().connection()){
           PreparedStatement prst = connection.prepareStatement(sql);

           ResultSet rs = prst.executeQuery();
           while(rs.next()){
               Integer id = rs.getInt("id");
               Integer codigo_aluno = rs.getInt("codigo_aluno");
               String nome = rs.getString("nome");
               String nome_curso = rs.getString("nome_curso");
               Integer ano_curso = rs.getInt("ano_curso");
               double media_atual = rs.getInt("media_atual");
               AlunoModel alunoModel = new AlunoModel(id,codigo_aluno,nome,nome_curso,ano_curso,media_atual);
               alunoModels.add(alunoModel);
           }
       }catch (SQLException ex) {
                throw  new TurmaException("Erro ao fazer buscas");
        }
        return alunoModels;
    }

    @Override
    public Set<AlunoModel> mediaSuperior(double media) {
        String sql = "SELECT codigo_aluno, media_atual ,COUNT(*) FROM turma WHERE media_atual = ? GROUP BY codigo_aluno , media_atual";
                        Set<AlunoModel> aluno = new HashSet<>();
                    try(Connection connection = DataBaseConnetiom.getInstance().connection()){
                        PreparedStatement prst = connection.prepareStatement(sql);
                        prst.setDouble(1,media);

                        ResultSet rs = prst.executeQuery();

                        while(rs.next()){
                            Integer codigo_aluno = rs.getInt("codigo_aluno");
                            double media_atual = rs.getDouble("media_atual");
                            AlunoModel turma = new AlunoModel(codigo_aluno,media_atual);
                            aluno.add(turma);
                        }
                    }catch (SQLException ex){
                        throw new TurmaException("Media Invalida");
                    }
        return aluno;
    }

    @Override
    public void alterarNomeAluno(AlunoModel alunoModel) {
        String sql = "UPDATE  turma SET  nome = ? WHERE id = ?";
        try(Connection connection = DataBaseConnetiom.getInstance().connection()){
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setString(1,alunoModel.getNome());
            prst.setInt(2,alunoModel.getId());
            prst.executeUpdate();
        }catch (SQLException ex){
            throw  new TurmaException("Falha ao aualizar o nome"+ ex);
        }
    }

    @Override
    public Boolean alterarMedia(AlunoModel alunoModel) {
        String sql = "UPDATE turma SET media_atual = ? WHERE id = ?";
        try(Connection connection = DataBaseConnetiom.getInstance().connection()){
            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setDouble(1,alunoModel.getMediaAtual());
            prst.setInt(2,alunoModel.getId());
            prst.executeUpdate();
        } catch (SQLException e) {
            throw new TurmaException("Falha ao atualizar a media"+e);
        }
        return true;
    }
}
