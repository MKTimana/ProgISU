

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaAutenticacao extends JFrame implements ActionListener{

	private JLabel lblUsername,lblPassword;
	private JButton btLogin;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPanel panel,panel1,panelBotao,panelPrincipal;
	
	public TelaAutenticacao() {
		this.setTitle("Tela de Autenticação");
		this.setSize(350,150);
		this.setLocation(500,500);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblUsername = new JLabel("Username");
		txtUsername = new JTextField(10);
		panel.add(lblUsername);
		panel.add(txtUsername);
		
		panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lblPassword = new JLabel("Password");
		passwordField = new JPasswordField(10);
		passwordField.setEchoChar('*');
		panel1.add(lblPassword);
		panel1.add(passwordField);
		
		panelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btLogin = new JButton("Login");
		btLogin.addActionListener(this);
		panelBotao.add(btLogin);
		
		panelPrincipal = new JPanel();
		panelPrincipal.add(panel);
		panelPrincipal.add(panel1);
		panelPrincipal.add(panelBotao);
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));
		
		this.add(panelPrincipal);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaAutenticacao();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btLogin) {
			String username = txtUsername.getText();
			String password = String.valueOf(passwordField.getPassword());
			
			if(username.equals("admin") && password.equals("1234")) {
				JOptionPane.showMessageDialog(this,"Bem-Vindo!");
				TelaGestaoDeDespesas telaDespesas = new TelaGestaoDeDespesas(null);
				telaDespesas.setVisible(true);
				this.dispose();
				
			}else {
				JOptionPane.showMessageDialog(this,"Credenciais Inválidas!","erro",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
