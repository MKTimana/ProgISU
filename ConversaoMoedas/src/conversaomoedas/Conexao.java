/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversaomoedas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mkt
 */
public class Conexao {
    Connection con;
    final String url = "jdbc:mysql://localhost:3306/moeda";
    final String user ="root";
    final String pass = "";
    
    public Connection conectarBD(){
        
        try {
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Erro de conexao a base de dados "+e);
        }
        return con;
    }
    
}
