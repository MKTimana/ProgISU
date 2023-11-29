

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoGUI extends JFrame implements ActionListener {
	private JTextField tf_nome;
	private JTextField tf_idade;
	private JTextArea tf_resultado;
	private JLabel lb_nome, lb_idade;
	private JButton bt_consultar;
	private JButton bt_inserir;
	private JButton bt_apagar;
	private JTable tb_listagem;
	private DefaultTableModel tm_listagemModel;

	public AlunoGUI() {

		this.setTitle("Aplicativo JDBC com Swing");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		lb_nome = new JLabel("Nome:");
		lb_idade = new JLabel("Idade:");
		tf_nome = new JTextField();
		tf_idade = new JTextField();
		tf_resultado = new JTextArea();
		bt_consultar = new JButton("Consultar");
		bt_inserir = new JButton("Inserir");
		bt_apagar = new JButton("Apagar");

		tm_listagemModel = new DefaultTableModel();
		tm_listagemModel.addColumn("ID");
		tm_listagemModel.addColumn("Nome");
		tm_listagemModel.addColumn("Idade");
		tb_listagem = new JTable(tm_listagemModel);
		// Componentes da interface
		JPanel panel = new JPanel(new GridLayout(4, 2));

		panel.add(lb_nome);
		panel.add(tf_nome);
		panel.add(lb_idade);
		panel.add(tf_idade);
		panel.add(bt_consultar);
		panel.add(bt_inserir);
		panel.add(bt_apagar);

		tf_resultado.setEditable(false);

		bt_consultar.addActionListener(this);
		bt_inserir.addActionListener(this);
		bt_apagar.addActionListener(this);

		add(panel, BorderLayout.NORTH);
		add(new JScrollPane(tb_listagem), BorderLayout.CENTER);
		add(new JScrollPane(tf_resultado), BorderLayout.SOUTH);

	}

	private void consultarDados(AlunoOperacoes al) {
		tm_listagemModel.setRowCount(0); // Limpa a tabela antes de consultar
		try {
			// Conectar ao banco de dados
			Connection connection = DriverManager.getConnection(al.jdbcURL, al.username, al.password);

			// Preparar consulta SELECT
			String selectQuery = "SELECT * FROM alunos";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			// Exibir resultados na �rea de texto
			tf_resultado.setText("");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				int idade = resultSet.getInt("idade");
				tf_resultado.append("Nome: " + nome + ", Idade: " + idade + "\n");
				tm_listagemModel.addRow(new Object[] { id, nome, idade });
			}

			// Fechar a conex�o
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			tf_resultado.setText("Erro: " + e.getMessage());
		}
	}

	private void inserirDados(AlunoOperacoes al) {
		String nome = tf_nome.getText();
		String idadeStr = tf_idade.getText();

		try {
			int idade = Integer.parseInt(idadeStr);

			Connection connection = DriverManager.getConnection(al.jdbcURL, al.username, al.password);

			final String query = "INSERT INTO alunos(nome, idade) VALUES (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, idadeStr);

			preparedStatement.executeUpdate();
			System.out.println("Inserido com sucesso");
			connection.close();
			preparedStatement.close();

			// Atualizar a tabela ap�s a inser��o
			consultarDados(al);

		} catch (SQLException | NumberFormatException e) {
			tf_resultado.setText("Erro: " + e.getMessage());
		}
	}

	private void apagarDados(AlunoOperacoes al) {
		String nome = tf_nome.getText();

		try {

			Connection connection = DriverManager.getConnection(al.jdbcURL, al.username, al.password);

			final String query = "DELETE FROM alunos WHERE nome = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nome);

			preparedStatement.executeUpdate();
			System.out.println("Removido com sucesso");
			connection.close();
			preparedStatement.close();

			// Atualizar a tabela ap�s a inser��o
			consultarDados(al);

		} catch (SQLException | NumberFormatException e) {
			tf_resultado.setText("Erro: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		AlunoGUI app = new AlunoGUI();
		app.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AlunoOperacoes al = new AlunoOperacoes();
		if (e.getSource() == bt_consultar) {
			consultarDados(al);
		}
		if (e.getSource() == bt_inserir) {
			inserirDados(al);
		}
		if (e.getSource() == bt_apagar) {
			apagarDados(al);
		}

	}
}
