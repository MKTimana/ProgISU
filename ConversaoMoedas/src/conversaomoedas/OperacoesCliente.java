/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversaomoedas;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author mkt
 */
public class OperacoesCliente {
    
    Conexao conexao = new Conexao();
    MoedasView view = new MoedasView();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
//    Metodo para registrar conversao
    private void registroConversao(Moeda moeda){
        String u_moeda = view.getTxtMzn() +"";
        String r_moeda = view.getTxtConversao()+"";
        try{
            
            double uMoeda = Double.parseDouble(u_moeda);
            double rMoeda = Double.parseDouble(r_moeda);
            
            con = conexao.conectarBD();
            String sql = "INSERT into conversoes(u_moeda,r_moeda,moeda) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setDouble(1,uMoeda);
            ps.setDouble(2, rMoeda);
            ps.executeUpdate();
            System.out.println("Insercao feita com sucesso por operacoes");
//            JOptionPane.showMessageDialog(null, "A conversao foi realizada com sucesso", "Registro de moeda", 0);
            con.close();
            ps.close();
            
            
        }catch(Exception e){
            System.out.println("Erro de insercao partindo de operacoes"+e);
//            JOptionPane.showMessageDialog(null, "A conversao foi realizada sem sucesso", "Registro de moeda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
