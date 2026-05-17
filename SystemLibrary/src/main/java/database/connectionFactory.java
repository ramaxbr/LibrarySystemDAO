package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {

    private static final String url = "jdbc:mysql://localhost:3306/Biblioteca";
    private static final String user = "root";
    private static final String pws = "root";

    public static Connection getConnection() throws SQLException{
                return DriverManager.getConnection(url, user, pws);
    }

    public static void testConnection (){
        try (Connection testConn = getConnection()){
            System.out.println("Conexão estabelecida! \n");
        }catch (SQLException errorSQL){
            System.out.println("Erro de conexão \n" + errorSQL.getMessage() );
        }

    }
}
