import java.awt.*;

import javax.swing.*;

public class GridLay {
    // Criacao de componentes
    private JFrame jf;
    private JLabel lblUser;
    private JLabel lblPwd;
    private JTextField txtUser;
    private JPasswordField txtPwd;
    private JButton btnClear;
    private JButton btnSubmit;
    private JLabel lblSp1;
    private JLabel lblSp2;

    public GridLay() {

        // inicializacao dos componentes

        // FRAME
        jf = new JFrame();
        jf.setTitle("Login");
        jf.setSize(350, 150);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(4, 2));

        // LABEL
        lblUser = new JLabel();
        lblPwd = new JLabel();
        lblSp1 = new JLabel();
        lblSp2 = new JLabel();
        lblUser.setText("Utilizador:");
        lblPwd.setText("Password:");
        lblSp1.setText(null);
        lblSp2.setText(null);
    

        // TEXTFIELD
        txtUser = new JTextField(10);
        txtPwd = new JPasswordField(10);
        txtPwd.setEchoChar('#');

        // BOTOES
        btnClear = new JButton("Limpar");
        btnSubmit = new JButton("Submeter");

        // Adicionando ao Frame
        jf.add(lblUser);
        jf.add(txtUser);
        jf.add(lblPwd);
        jf.add(txtPwd);
        jf.add(lblSp1);
        jf.add(lblSp2);
        jf.add(btnClear);
        jf.add(btnSubmit);
        jf.setVisible(true);
    }
}
