package escola.DataBase;
import escola.exceptions.TurmaException;
import java.sql.*;
import java.util.Objects;
public class DataBaseConnetion {

    private String url = "jdbc:mysql://localhost:3306/escola";
    private String user = "root";
    private String password = "1234";

    private Connection connection;
    private static DataBaseConnetion instance;

    private DataBaseConnetion() throws  SQLException{
              connection = DriverManager.getConnection(url,user,password);
    }

    public static DataBaseConnetion getInstance() throws SQLException {
        if(Objects.isNull(instance)){
            instance = new DataBaseConnetion();
        }
        return  instance;
    }

    public Connection connection(){
        return connection;
    }

    public static  void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new TurmaException(e.getMessage());
            }
        }
    }

    public static  void closeResulSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new TurmaException(e.getMessage());
            }
        }
    }
}
