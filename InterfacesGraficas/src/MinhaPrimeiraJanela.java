
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MinhaPrimeiraJanela implements ActionListener {
    // Criacao de componentes

    private JFrame jf;
    private JButton btnSubmit;
    private JButton btnClear;
    private JLabel lblName;
    private JTextField txtName;
    private JPasswordField txtPwd;
    private JLabel lblPwd;

    public MinhaPrimeiraJanela() {
        // Inicializacao dos componentes
        jf = new JFrame();
        jf.setTitle("MKT.dmg");
        jf.setSize(300, 150);
        // jf.setLocation(550,275);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // jf.setLayout(null);
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));

        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Limpar");

        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);
        // btnSubmit.setBounds(50, 50, 150, 50);

        lblName = new JLabel("Name Label");
        lblPwd = new JLabel("Password label");
        lblName.setText("Your Name:");
        // lblName.setBounds(10, 2, 300, 20);
        // lblPwd.setBounds(10, 25, 300, 20);
        lblPwd.setText("Your Password:");

        txtName = new JTextField(10);
        txtPwd = new JPasswordField(10);
        // txtPwd.setBounds(110, 25, 100, 20);
        // txtName.setBounds(110, 2, 100, 20);

        // Adicionando ao Frame
        jf.add(lblName);
        jf.add(txtName);
        jf.add(lblPwd);
        jf.add(txtPwd);
        jf.add(btnSubmit);
        jf.add(btnClear);
        jf.setVisible(true);
        // jf.add(btnSubmit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btnSubmit){
//            System.out.println(txtName.getText());
                JOptionPane.showMessageDialog(jf,txtName.getText() +" "+txtPwd.getText(),"Nome do User",JOptionPane.ERROR_MESSAGE);
                txtName.setText("");
                txtPwd.setText("");
            }
            if(e.getSource() == btnClear){
                txtName.setText("");
                txtPwd.setText("");
            }
    }
}
