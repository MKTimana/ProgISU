import java.awt.GridLayout;

import javax.swing.*;

public class Calculadora {
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

    public Calculadora(){
        // Inicializacao dos componentes
        jf = new JFrame();
        jf.setTitle("Meus botoes");
        jf.setSize(400,200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(3,4,10,10));

        bt1 = new JButton("#1");
        bt2 = new JButton("#2");
        bt3 = new JButton("#3");
        bt4 = new JButton("#4");
        bt5 = new JButton("#5");
        bt6 = new JButton("#6");
        bt7 = new JButton("#7");
        bt8 = new JButton("#8");
        bt9 = new JButton("#9");
        bt10 = new JButton("#10");
        bt11 = new JButton("#11");
        bt12 = new JButton("#12");

        //Adicionando ao FRAME
        jf.add(bt1);
        jf.add(bt2);
        jf.add(bt3);
        jf.add(bt4);
        jf.add(bt5);
        jf.add(bt6);
        jf.add(bt7);
        jf.add(bt8);
        jf.add(bt9);
        jf.add(bt10);
        jf.add(bt11);
        jf.add(bt12);

        jf.setVisible(true);
    }
}
