/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversaomoedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mkt
 */
public class ControladorMoeda implements ActionListener{
    MoedasView mv = new MoedasView();
    Moeda m = new Moeda();
    DefaultTableModel dtm = new DefaultTableModel();
    
    public ControladorMoeda(MoedasView mv){
        this.mv = mv;
        mv.setVisible(true);
    }
    
//    Accoes dos botoes
    public void botoes(){
    mv.getBtnConverter().addActionListener(this);
    }
    
    private void registrar(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}
