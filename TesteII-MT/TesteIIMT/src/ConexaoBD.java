import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {

    Connection con;
    final String url = "jdbc:mysql://localhost:3306/escola";
    final String user = "root";
    final String pass = "";
    PreparedStatement ps;
    ResultSet rs;

    public Connection conectarBD() {

        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Erro de conexao a base de dados " + e);
        }
        return con;
    }



}
