package escola.services;
import escola.DataBase.DataBaseConnetion;
import escola.exceptions.TurmaException;
import escola.models.DisciplinasModel;
import escola.repository.DisciplinaRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DisciplinaServices  implements DisciplinaRepository {


    @Override
    public Boolean save(DisciplinasModel disciplinasModel) {
        PreparedStatement prst = null;
        try(Connection connection = DataBaseConnetion.getInstance().connection()){
            prst = connection.prepareStatement("INSERT INTO disciplina  (nome_disciplina ) VALUES (?)");
            prst.setString(1,disciplinasModel.getNomeDisciplina());
            prst.executeUpdate();
        } catch (SQLException e) {
            throw new TurmaException("Erro: "+e.getMessage());
        }finally {
            DataBaseConnetion.closeStatement(prst);
        }
        return true;
    }
    @Override
    public void deleteById(Integer codigo) {
        PreparedStatement prst = null;
            try(Connection connection = DataBaseConnetion.getInstance().connection()){
                 prst = connection.prepareStatement("DELETE FROM disciplina WHERE id = ?");
                prst.setInt(1,codigo);
                prst.executeUpdate();
            } catch (SQLException e) {
                throw new TurmaException("Erro verifique o codigo"+e);
            }finally {
                DataBaseConnetion.closeStatement(prst);
            }
    }

    @Override
    public Boolean update(DisciplinasModel disciplinasModel) {
        PreparedStatement prst = null;
        try(Connection connection = DataBaseConnetion.getInstance().connection()) {
           prst = connection.prepareStatement( "UPDATE disciplina SET nome_disciplina = ? WHERE id = ?");
            prst.setString(1, disciplinasModel.getNomeDisciplina());
            prst.setInt(2,disciplinasModel.getId_disciplina());
            prst.executeUpdate();
        }catch (SQLException ex){
            throw  new TurmaException("Falha ao atualizar!"+ex.getMessage());
        }finally {
            DataBaseConnetion.closeStatement(prst);
        }
        return  true;
    }

    @Override
    public List<DisciplinasModel> findAll() {
        ResultSet rs = null;
        PreparedStatement prst =  null;
        List<DisciplinasModel> disciplinasModelList = new ArrayList<>();
        try(Connection connection = DataBaseConnetion.getInstance().connection()){
            prst = connection.prepareStatement("SELECT  id_disciplina , nome_disciplina  FROM disciplina");

            rs =  prst.executeQuery();

            while(rs.next()){
                 Integer id = rs.getInt("id_disciplina");
                 String nome_disciplina = rs.getString("nome_disciplina");
                 DisciplinasModel disciplinasModel = new DisciplinasModel(id,nome_disciplina);
                 disciplinasModelList.add(disciplinasModel);
         }
        } catch (SQLException ex) {
         throw new TurmaException("Falha ao buscar todas as disciplinas!"+ex.getMessage());
     }finally {
            DataBaseConnetion.closeResulSet(rs);
            DataBaseConnetion.closeStatement(prst);
        }
     return  disciplinasModelList;
    }
}