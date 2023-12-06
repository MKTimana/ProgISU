import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TelaFiltrarCategoria extends JFrame implements ActionListener{
	
	private JLabel lblSelecao;
	private JButton btFiltrar;
	private JComboBox comboBox;
	private JPanel panel,panelBotao,panelPrincipal;
	private Vector despesas = TelaAdicionarDespesa.getVectorPreenchido();
	public static  Vector filtrado = new Vector();
	
	public TelaFiltrarCategoria() {
		this.setTitle("Tela de Filtragem de Categoria");
		this.setSize(350,250);
		this.setLocation(500,500);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblSelecao = new JLabel("Selecione a categoria");
		String[] categorias = {"Alimentação","Transporte","Lazer","Outros"};
		comboBox = new JComboBox(categorias);
		panel.add(lblSelecao);
		panel.add(comboBox);
		
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
	
	public static Vector getVectorFiltrado() {
		return filtrado;
	}
	
	public static void main(String[] args) {
		new TelaFiltrarCategoria();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btFiltrar) {
			
			String filtro = comboBox.getSelectedItem().toString();
			
			for(Object despesa : despesas) {
				if(((Despesa)despesa).getCategoria().equals(filtro)) {
					filtrado.add(despesa);
				}
			}
			
			TelaGestaoDespesas telaGestao = new TelaGestaoDespesas();
			telaGestao.setVisible(true);
			telaGestao.filtrarDespesas();
			this.dispose();
		}
	}
}
