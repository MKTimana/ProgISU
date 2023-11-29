
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hometech;

import model.Armazem;
import model.ArmazemDAO;
import view.ArmazemView;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JTable;

/**
 *
 * @author mkt
 */
public class ControllerArmazem implements ActionListener{
    
    Armazem armazem = new Armazem();
    ArmazemDAO arm = new ArmazemDAO();
    ArmazemView view = new ArmazemView();
    DefaultTableModel dtm = new DefaultTableModel();

    public ControllerArmazem(ArmazemView view) {
        this.view = view;
        view.setVisible(true);
        accoes();
        listarTabela();
        
    }
    
    public void accoes(){
        view.getBtnCriar().addActionListener(this);
        view.getBtnActualizar().addActionListener(this);
        view.getBtnApagar().addActionListener(this);
        view.getBtnLimpar().addActionListener(this);
        view.getTblArmazem().addMouseListener(new MouseAdapter(){
             
          public void mouseClicked(MouseEvent e){
                    preencherCampos(e);
                }
        });
    }
    
    private void listarTabela(){
        String [] titulos = new String[]{"ID","Nome","Endereço","Contacto"};
        dtm = new DefaultTableModel(titulos,0);
        List<Armazem> listaArmazem = arm.listarArmazem();
        
        for (Armazem arma : listaArmazem) {
            dtm.addRow(new Object[]{arma.getId(),arma.getNome(),arma.getEndereco(),arma.getContacto()});
        }
        view.getTblArmazem().setModel(dtm);
        view.getTblArmazem().setPreferredSize(new Dimension(350,dtm.getRowCount() * 16));
    }
    
    private void preencherCampos(MouseEvent e){
        JTable target = (JTable) e.getSource();
        
        view.getTxtId().setText(view.getTblArmazem().getModel().getValueAt(target.getSelectedRow(), 0).toString());
        view.getTxtNome().setText(view.getTblArmazem().getModel().getValueAt(target.getSelectedRow(), 1).toString());
        view.getTxtEndereco().setText(view.getTblArmazem().getModel().getValueAt(target.getSelectedRow(), 2).toString());
        view.getTxtContacto().setText(view.getTblArmazem().getModel().getValueAt(target.getSelectedRow(), 3).toString());
    }
    
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == view.getBtnCriar()) {
        // Lógica para a ação do botão de criação
    } else if (e.getSource() == view.getBtnActualizar()) {
        // Lógica para a ação do botão de atualização
    } else if (e.getSource() == view.getBtnApagar()) {
        // Lógica para a ação do botão de exclusão
    } else if (e.getSource() == view.getBtnLimpar()) {
        // Lógica para a ação do botão de limpar
    }
    // ...outros botões e ações
}

    
}
