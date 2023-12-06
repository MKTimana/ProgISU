import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Autenticacao extends JFrame implements ActionListener {

    private JLabel lblSessao, lblUser, lblSenha, lbl;
    private JTextField txtUser;
    private JPasswordField txtSenha;
    private JButton btnSubmit, btnSair;

    public Autenticacao() {
        this.setTitle("Tela Principal");
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 2));

        lbl = new JLabel();
        lblSessao = new JLabel("Inicie sua Sessao");
        lblUser = new JLabel("Utilizador");
        lblSenha = new JLabel("Senha");

        txtUser = new JTextField(10);
        txtSenha = new JPasswordField(10);
        txtSenha.setEchoChar('@');

        btnSair = new JButton("Sair");
        btnSair.addActionListener(this);
        btnSubmit = new JButton("Submeter");
        btnSubmit.addActionListener(this);

        this.add(lblSessao);
        this.add(lbl);
        this.add(lblUser);
        this.add(txtUser);
        this.add(lblSenha);
        this.add(txtSenha);
        this.add(btnSubmit);
        this.add(btnSair);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            if (txtUser.getText().equals("isutc") && txtSenha.getText().equals("2023")) {
                JOptionPane.showMessageDialog(null, "Bem vindo");
                new Estudante().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Utilizador ou Senha incorrecta", "ERRO DE CREDENCIAIS",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource()==btnSair){
            JOptionPane.showMessageDialog(null,"Obrigado, até a proxima!");
            this.dispose();
        }

    }

    public static void main(String[] args) {
        new Autenticacao().setVisible(true);
        // new Estudante().setVisible(true);
    }

}