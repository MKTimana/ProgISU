import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calc implements ActionListener {
    private JFrame jf;
    private JLabel lblNum1;
    private JLabel lblNum2;
    private JLabel lblRes;
    private JTextField txtNum1;
    private JTextField txtNum2;
    private JTextField txtRes;
    private JButton btnSum;
    private JButton btnClear;

    public Calc() {
        jf = new JFrame("Calculadora");
        jf.setSize(200, 190);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());
        jf.setBackground(Color.white);

        lblNum1 = new JLabel("Numero 1");
        lblNum2 = new JLabel("Numero 2");
        lblRes = new JLabel("Resultado");

        txtNum1 = new JTextField(7);
        txtNum2 = new JTextField(7);
        txtRes = new JTextField(7);
        // txtRes.setEnabled(false);
        txtRes.setEditable(false);
        txtRes.setBackground(Color.WHITE);

        btnSum = new JButton("Somar");
        btnSum.addActionListener(this);

        btnClear = new JButton("Limpar");
        btnClear.addActionListener(this);

        jf.add(lblNum1);
        jf.add(txtNum1);
        jf.add(lblNum2);
        jf.add(txtNum2);
        jf.add(lblRes);
        jf.add(txtRes);
        jf.add(btnSum);
        jf.add(btnClear);

        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSum) {
            sum();
        }

        if(e.getSource() == btnClear){
            clear();
        }

    }

    public void sum() {
        int num1 = Integer.parseInt(txtNum1.getText());
        int num2 = Integer.parseInt(txtNum2.getText());
        int res = num1 + num2;
        txtRes.setText(res + "");
    }

    public void clear(){
        txtNum1.setText(null);
        txtNum2.setText(null);
        txtRes.setText(null);
    }

}
