

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TelaFiltrar extends JFrame implements ActionListener{

	private Vector<Object> despesas;
	private JLabel lblSelecao;
	private JComboBox escolhaBox;
	private JPanel panel,panelBotao,panelPrincipal;
	private JButton btFiltrar;
	
	public TelaFiltrar(Vector<Object> despesas) {
		this.setTitle("Tela Adcionar despesa");
		this.setSize(350,150);
		this.setLocation(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		despesas = new Vector<Object>();
		this.despesas = despesas;
		 
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblSelecao = new JLabel("Selecione uma categoria:");
		
		String[] categorias = {"Alimentacao","Transportes","Lazer","Outros"};
		escolhaBox = new JComboBox(categorias);
		panel.add(lblSelecao);
		panel.add(escolhaBox);
		
		panelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btFiltrar = new JButton("Filtrar");
		btFiltrar.addActionListener(this);
		panelBotao.add(btFiltrar);
		
		panelPrincipal = new JPanel();
		panelPrincipal.add(panel);
		panelPrincipal.add(panelBotao);
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));
		
		this.add(panelPrincipal);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaFiltrar(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btFiltrar) {
			String filtro = escolhaBox.getSelectedItem().toString();
			
			TelaGestaoDeDespesas telaDespesas = new TelaGestaoDeDespesas(null);
			telaDespesas.filtrarDespesas(despesas,filtro);
			telaDespesas.setVisible(true);
			this.dispose();
		}
	}
}
