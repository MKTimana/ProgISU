import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaGestaoDespesas extends JFrame implements ActionListener{

	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JPanel panelBotoes;
	private JButton btAdicionarDespesa,btVisualizarDespesas,btFiltrarDespesas;
	public static Vector despesas = TelaAdicionarDespesa.getVectorPreenchido();
	public static Vector filtrado = TelaFiltrarCategoria.getVectorFiltrado();
	
	
	public TelaGestaoDespesas() {
		this.setTitle("Tela de Gestao de Despesas");
		this.setSize(650,500);
		this.setLocation(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		
		panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btAdicionarDespesa = new JButton("Adicionar despesa");
		btAdicionarDespesa.addActionListener(this);
		
		btVisualizarDespesas = new JButton("Visulaizar despesas");
		btVisualizarDespesas.addActionListener(this);
		
		btFiltrarDespesas = new JButton("Filtrar por Categoria");
		btFiltrarDespesas.addActionListener(this);
		
		panelBotoes.add(btAdicionarDespesa);
		panelBotoes.add(btVisualizarDespesas);
		panelBotoes.add(btFiltrarDespesas);
		
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Descrição");
		tableModel.addColumn("Categoria");
		tableModel.addColumn("Valor");
		tableModel.addColumn("Data");
		
		table = new JTable(tableModel);
		
		scrollPane = new JScrollPane(table);
		
		
		this.add(scrollPane,"North");
		this.add(panelBotoes,"South");
		this.setVisible(true);
	}
	
	public void visualizarDespesas() {
	    tableModel.setRowCount(0);
		for(int i=0;i<despesas.size();i++) {
			Despesa despesa = (Despesa)despesas.get(i);
			String descricao = despesa.getDescricao();
			String categoria = despesa.getCategoria();
			double valor = despesa.getValor();
			String data = despesa.getData();
			
			tableModel.addRow(new Object[] {descricao,categoria,valor,data});	
		}
	}
	
	public void filtrarDespesas() {
	    tableModel.setRowCount(0);
		for(int i=0;i<filtrado.size();i++) {
			Despesa despesa = (Despesa)filtrado.get(i);
			String descricao = despesa.getDescricao();
			String categoria = despesa.getCategoria();
			double valor = despesa.getValor();
			String data = despesa.getData();
			
			tableModel.addRow(new Object[] {descricao,categoria,valor,data});	
		}
	}
	
	public static void main(String[] args) {
		new TelaGestaoDespesas();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btAdicionarDespesa) {
			TelaAdicionarDespesa telaAdicionar = new TelaAdicionarDespesa();
			telaAdicionar.setVisible(true);
			this.dispose();
		}
		if(e.getSource() == btVisualizarDespesas) {
			visualizarDespesas();
		}
		if(e.getSource() == btFiltrarDespesas) {
			TelaFiltrarCategoria telaFiltro = new TelaFiltrarCategoria();
			telaFiltro.setVisible(true);
			this.dispose();
		}
	}
	
}
