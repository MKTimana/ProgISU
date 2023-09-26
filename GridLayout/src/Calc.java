import java.awt.GridLayout;

import javax.swing.*;

public class Calc {
    // Componentes
    private JFrame jf;
    private JButton bt1;
    private JButton bt2;
    private JButton bt3;
    private JButton bt4;
    private JButton bt5;
    private JButton bt6;
    private JButton bt7;
    private JButton bt8;
    private JButton bt9;
    private JButton bt10;
    private JButton bt11;
    private JButton bt12;

    public Calc() {
        // Inicializacao dos componentes
        jf = new JFrame();
        jf.setTitle("Meus botoes");
        jf.setSize(400, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(3, 4, 10, 10));
        jf.setResizable(false);

        // Adicionando ao FRAME
        for (int i = 0; i < 12; i++) {
            bt1 = new JButton("#"+i);
            jf.add(bt1);
        }

        jf.setVisible(true);
    }
}
