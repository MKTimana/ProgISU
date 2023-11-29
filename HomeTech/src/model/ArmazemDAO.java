/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.*;
import hometech.Con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mkt
 */
public class ArmazemDAO {
    Con conexao = new Con(); //Instancia de conexao da BD
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarArmazem(){
        String sql = "SELECT * from armazem";
        List<Armazem> lista = new ArrayList<>();
        
        try{
        con = conexao.conexaoBD();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
            
        Armazem armazem = new Armazem();
        armazem.setId(rs.getInt(1));
        armazem.setNome(rs.getString(2));
        armazem.setEndereco(rs.getString(3));
        armazem.setContacto(rs.getString(4));
        
        lista.add(armazem);
        }
        }catch(SQLException e){
            System.out.println("Erro de listagem "+e);
        }
        return lista;
    }
    
}
