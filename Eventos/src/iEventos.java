import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class iEventos  implements ActionListener {

    private JFrame jf;
    private JLabel lblName;
    private JTextField txtName;
    private JButton btnSubmit;

    public iEventos(){
        jf = new JFrame("Eventos");
        jf.setLocationRelativeTo(null);
//        jf.setLocation();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());
        jf.setSize(350,90);

        lblName = new JLabel("Nome");
        txtName = new JTextField(10);
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);

        jf.add(lblName);
        jf.add(txtName);
        jf.add(btnSubmit);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSubmit){
//            System.out.println(txtName.getText());
            JOptionPane.showMessageDialog(jf,txtName.getText(),"Nome do User",JOptionPane.ERROR_MESSAGE);
        }
    }
}
