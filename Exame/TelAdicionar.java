

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class TelAdicionar extends JFrame implements ActionListener{

	private Vector<Object> despesas;
	private JButton btAdicionar,btVoltar;
	private JPanel panel,panel1,panel2,panel3,panelBotao,panelPrincipal;
	private JLabel lblDescricao,lblCategoria,lblValor,lblData;
	private JTextField txtDescricao,txtCategoria,txtValor,txtData;
	private JComboBox comboBox;

	public TelAdicionar() {
		this.setTitle("Tela Adcionar despesa");
		this.setSize(350,200);
		this.setLocation(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		despesas = new Vector<Object>();
		
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblDescricao = new JLabel("Descricao");
		txtDescricao = new JTextField(10);
		panel.add(lblDescricao);
		panel.add(txtDescricao);

		panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblCategoria = new JLabel("Categoria");
		

		String[] categorias = {"Alimentacao","Transporte","Lazer","Outros"};
		comboBox = new JComboBox(categorias);
		panel1.add(lblCategoria);
		panel1.add(comboBox);

		panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblValor = new JLabel("Valor");
		txtValor = new JTextField(10);
		panel2.add(lblValor);
		panel2.add(txtValor);

		panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblData = new JLabel("Data DD-MM-YYYY");
		txtData = new JTextField(10);
		panel3.add(lblData);
		panel3.add(txtData);
		
		panelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btVoltar = new JButton("Voltar");
		btAdicionar = new JButton("Adicionar");
		btVoltar.addActionListener(this);
		btAdicionar.addActionListener(this);
		panelBotao.add(btVoltar);
		panelBotao.add(btAdicionar);
		
		panelPrincipal = new JPanel();
		panelPrincipal.add(panel);
		panelPrincipal.add(panel1);
		panelPrincipal.add(panel2);
		panelPrincipal.add(panel3);
		panelPrincipal.add(panelBotao);
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));

		this.add(panelPrincipal);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TelAdicionar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btAdicionar) {
			String descricao = txtDescricao.getText();
			String categoria = comboBox.getSelectedItem().toString();
			double valor = Double.valueOf(txtValor.getText());
			String data = txtData.getText();
			
			Despesa despesa = new Despesa(descricao,categoria,valor,data);
			despesas.add(despesa);
			System.out.println(despesas.toString());
			JOptionPane.showMessageDialog(this, "Despesa adicionada com sucesso!");
			TelaGestaoDeDespesas telaDespesas = new TelaGestaoDeDespesas(despesas);

		}
		if(e.getSource() == btVoltar) {
			TelaGestaoDeDespesas telaDespesas = new TelaGestaoDeDespesas(this.despesas);
			telaDespesas.setVisible(true);
			this.dispose();
		}
	}
}
