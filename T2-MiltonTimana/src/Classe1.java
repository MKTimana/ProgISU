import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Classe1 extends JFrame implements ActionListener{
    
    private JLabel lblUser;
    private JLabel lblPass;
    private JTextField txtUser;
    private JTextField txtPass;
    private JButton btnSubmit;
    private JButton btnClear;

    

    Classe1(){
        this.setTitle("Login");
        this.setSize(220,150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        lblUser = new JLabel("Utilizador");
        txtUser = new JTextField(10);
        lblPass = new JLabel("Senha");
        txtPass = new JTextField(10);

        btnSubmit = new JButton("Entrar");
        btnSubmit.addActionListener(this);
        btnClear = new JButton("Limpar");
        btnClear.addActionListener(this);

        this.add(lblUser);
        this.add(txtUser);
        this.add(lblPass);
        this.add(txtPass);
        this.add(btnSubmit);
        this.add(btnClear);

        
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSubmit){
            if(txtUser.getText().equals("admin") && txtPass.getText().equals("0000")){
                this.setVisible(false);
                
            
                new Classe2().setVisible(true);
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Utilizador ou Senha errada","ERRO",JOptionPane.ERROR_MESSAGE );
            }
        }
    }

}
