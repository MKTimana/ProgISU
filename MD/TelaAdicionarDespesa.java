
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class TelaAdicionarDespesa extends JFrame implements ActionListener{

	private JPanel panel,panel1,panel3,panel2,panelPrincipal,panelBotao;
	private JButton btAdicionar,btVoltar;
	private JLabel lblDescricao,lblCategoria,lblValor,lblData;
	private JTextField txtDescricao,txtCategoria,txtValor,txtData;
	private JComboBox comboBox;
	private static Vector despesas = new Vector();
	
	public TelaAdicionarDespesa() {
		this.setTitle("Tela Adcionar despesa");
		this.setSize(350,250);
		this.setLocation(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		 
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblDescricao = new JLabel("Descrição");
		txtDescricao = new JTextField(10);
		panel.add(lblDescricao);
		panel.add(txtDescricao);
		
		panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		String[] categorias = {"Alimentação","Transporte","Lazer","Outros"};
		comboBox = new JComboBox(categorias);
		
		lblCategoria = new JLabel("Categoria");
		panel1.add(lblCategoria);
		panel1.add(comboBox);
		
		panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblValor = new JLabel("Valor");
		txtValor = new JTextField(10);
		panel2.add(lblValor);
		panel2.add(txtValor);
		
		panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblData = new JLabel("Data");
		txtData = new JTextField(10);
		panel3.add(lblData);
		panel3.add(txtData);
		
		
		panelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(this);
		btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(this);
		panelBotao.add(btAdicionar);
		panelBotao.add(btVoltar);
		
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
		new TelaAdicionarDespesa();
	}
	
	public static Vector getVectorPreenchido() {
		return despesas;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btAdicionar) {
			String descricao = txtDescricao.getText();
			String categoria = comboBox.getSelectedItem().toString();
			double valor = Double.valueOf(txtValor.getText());
			String data = txtData.getText();
			
			Despesa despesa = new Despesa(descricao,categoria,valor,data);
			System.out.println(despesas.toString());	
			despesas.add(despesa);
			txtDescricao.setText("");
			txtValor.setText("");
			txtData.setText("");
			JOptionPane.showMessageDialog(this, "Despesa adicionada com sucesso!");
		}
		if(e.getSource() == btVoltar) {
			TelaGestaoDespesas telaDespesas = new TelaGestaoDespesas();
			telaDespesas.setVisible(true);
			this.dispose();
		}
	}
}
