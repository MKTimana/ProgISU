import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoForm extends JFrame implements ActionListener {

    private JLabel lblId;
    private JLabel lblNome;
    private JLabel lblPreco;
    private JLabel lblQuant;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtQuant;

    private JTextArea tf_resultado;

    private JButton btnCadastrar;
    private JButton btnExcluir;
    private JButton btnListar;

    private JPanel panButtons;
    private JPanel panFields;

    private DefaultTableModel tm_listagemModel;
    private JTable tb_listagem;

    ConexaoBD conexao = new ConexaoBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ProdutoForm() {
        this.setTitle("Cadastro de Produtos");
        this.setSize(550, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        panButtons = new JPanel();
        panButtons.setLayout(new GridLayout(2, 1));

        panFields = new JPanel();

        lblId = new JLabel("ID do produto");
        lblNome = new JLabel("Nome do produto");
        lblPreco = new JLabel("Preco");
        lblQuant = new JLabel("Quantidade");

        txtId = new JTextField(5);
        txtId.setEnabled(false);
        txtNome = new JTextField(10);
        txtPreco = new JTextField(10);
        txtQuant = new JTextField(10);
        tf_resultado = new JTextArea(5,20);

        tm_listagemModel = new DefaultTableModel();
        tm_listagemModel.addColumn("ID");
        tm_listagemModel.addColumn("Nome do produto");
        tm_listagemModel.addColumn("Preco");
        tm_listagemModel.addColumn("Quantidade");
        tb_listagem = new JTable(tm_listagemModel);

        btnCadastrar = new JButton("Cadastrar");
        btnExcluir = new JButton("Excluir");
        btnListar = new JButton("Listar produtos");

        btnCadastrar.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnListar.addActionListener(this);

        this.add(lblId);
        this.add(txtId);
        this.add(lblNome);
        this.add(txtNome);
        this.add(lblPreco);
        this.add(txtPreco);
        this.add(lblQuant);
        this.add(txtQuant);

        panButtons.add(btnCadastrar);
        panButtons.add(btnExcluir);
        panButtons.add(btnListar);
        add(new JScrollPane(tb_listagem), BorderLayout.CENTER);
		// add(new JScrollPane(tf_resultado), BorderLayout.SOUTH);

        this.add(panFields);
        this.add(panButtons);

    }

    public void consultarProdutos() {
        tm_listagemModel.setRowCount(0);
        try {
            con = conexao.conectarBD();
            // Preparar consulta SELECT
            String selectQuery = "SELECT * FROM produto";
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();

            // Exibir resultados na area de texto
            tf_resultado.setText("");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");

                tf_resultado.append("Nome: " + nome + ", Preco: " + preco + ", Quantidade: " + quantidade + "\n");
                tm_listagemModel.addRow(new Object[] { id, nome, preco, quantidade });
            }

            // Fechar a con
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            tf_resultado.setText("Erro: " + e.getMessage());
        }
    }

    public void cadastrarProduto() {
        String nome = txtNome.getText();
        double preco = Double.parseDouble(txtPreco.getText());
        int quant = Integer.parseInt(txtQuant.getText());

        try {

            con = conexao.conectarBD();

            final String query = "INSERT INTO produto(nome, preco,quantidade) VALUES (?, ?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nome);
            ps.setDouble(2, preco);
            ps.setInt(3, quant);

            ps.executeUpdate();
            System.out.println("Inserido com sucesso");
            con.close();
            ps.close();

            // Atualizar a tabela ap�s a inser��o
            consultarProdutos();

        } catch (SQLException | NumberFormatException e) {
            tf_resultado.setText("Erro: " + e.getMessage());
        }
    }

    public void removerProduto(){
        String nome = txtNome.getText();

		try {

			con = conexao.conectarBD();

			final String query = "DELETE FROM produto WHERE nome = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, nome);

			ps.executeUpdate();
			System.out.println("Removido com sucesso");
			con.close();
			ps.close();

			// Atualizar a tabela ap�s a inser��o
			consultarProdutos();

		} catch (SQLException | NumberFormatException e) {
			tf_resultado.setText("Erro: " + e.getMessage());
		}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnListar) {
            consultarProdutos();
        } else if (e.getSource() == btnCadastrar) {
            cadastrarProduto();
        }else if( e.getSource() == btnExcluir){

        }

    }

}
