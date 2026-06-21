package com.escola.chambule.DataBase;
import com.escola.chambule.exceptions.TurmaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
public class DataBaseConnetiom {

    private String url = "jdbc:postgresql://localhost:5432/escola";
    private String user = "postgres";
    private String password = "1234";

    private Connection connection;
    private static DataBaseConnetiom instance;

    private  DataBaseConnetiom(){
        try{
              connection = DriverManager.getConnection(url,user,password);
        }catch (SQLException ex){
            throw new TurmaException("Erro, falha na  conexao com banco de dados");
        }
    }

    public static DataBaseConnetiom getInstance(){
        if(Objects.isNull(instance)){
            instance = new DataBaseConnetiom();
        }
        return  instance;
    }

    public Connection connection(){
        return connection;
    }

}
