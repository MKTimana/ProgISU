

import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaGestaoDeDespesas extends JFrame implements ActionListener{

	private Vector<Object> despesas;
	private JTable table;
	private DefaultTableModel tableModel;
	private JPanel panelBotoes;
	private JButton btAdicionarDespesa,btVisualizarDespesa,btFiltrarCategoria;
	private JScrollPane scrollPane;

	public TelaGestaoDeDespesas(Vector<Object> despesas) {
		this.setTitle("Tela de Gestão de Despesas");
		this.setSize(650,535);
		this.setLocation(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.despesas=despesas;
		
		btAdicionarDespesa = new JButton("Adicionar despesa");
		btAdicionarDespesa.addActionListener(this);

		btVisualizarDespesa = new JButton("Visualizar despesas");
		btVisualizarDespesa.addActionListener(this);

		btFiltrarCategoria = new JButton("Filtrar Por Categoria");
		btFiltrarCategoria.addActionListener(this);

		panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBotoes.add(btAdicionarDespesa);
		panelBotoes.add(btVisualizarDespesa);
		panelBotoes.add(btFiltrarCategoria);

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

	public void visualizarDespesas(Vector<Object> despesas) {
		for(int i=0;i<despesas.size();i++) {
			String descricao = ((Despesa) despesas.get(i)).getDescricao();
			String categoria = ((Despesa) despesas.get(i)).getCategoria();
			double valor = ((Despesa) despesas.get(i)).getValor();
			String data = ((Despesa) despesas.get(i)).getData();
			
			tableModel.addRow(new Object[] {descricao,categoria,valor,data});
		}
	}
	
	public void filtrarDespesas(Vector<Object> despesas,String filtro) {
		for(int i=0;i<despesas.size();i++) {
			if(((Despesa)despesas.get(i)).getCategoria() == filtro){
				Object despesa = (Despesa)despesas.get(i);
				String descricao = ((Despesa) despesa).getDescricao();
				String categoria = ((Despesa) despesa).getCategoria();
				double valor = ((Despesa) despesa).getValor();
				String data = ((Despesa) despesa).getData();
				
				tableModel.addRow(new Object[] {descricao,categoria,valor,data});
			}
		}
	}
	
	public static void main(String[] args) {
		new TelaGestaoDeDespesas(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btAdicionarDespesa) {
			TelAdicionar telaAdd = new TelAdicionar();
			telaAdd.setVisible(true);
			this.dispose();
		}
		if(e.getSource() == btVisualizarDespesa) {
			visualizarDespesas(despesas);
		}
		if(e.getSource() == btFiltrarCategoria) {
			TelaFiltrar telaF = new TelaFiltrar(despesas);
			telaF.setVisible(true);
			this.dispose();
		}
		
	}
}
