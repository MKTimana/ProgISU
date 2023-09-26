import javax.swing.*;
import java.awt.*;

public class TelaFrutas {
//    Componentes
    private JFrame jf;

    private JPanel panTitle;
    private JPanel panFrutas;
    private JPanel panTxtA;

    private JLabel lblTitle;
    private JLabel lblChoice;
    private JComboBox cbFrutas;
    private JList lFrutas;
    private JTextArea txtA;
    private JScrollPane scrP;
    private ButtonGroup bg;
    private JRadioButton radM;
    private JRadioButton radF;


//  Itens
    private String [] frutas;
    private String [] frutas1;


    public TelaFrutas(){
        jf = new JFrame();
        panFrutas = new JPanel();
        panTitle = new JPanel();
        panTxtA = new JPanel();

        lblTitle = new JLabel("Tela de Registro de Frutas");
        lblChoice = new JLabel("Escolha a fruta favorita");
        frutas = new String[]{"Marracuja","Banana","Uva","Maça"};
        frutas1 = new String[]{"Marracuja","Banana","Uva","Maça"};

        cbFrutas = new JComboBox(frutas);
        lFrutas = new JList(frutas1);


        bg = new ButtonGroup();
        radM =new JRadioButton("Masculino");
        radF =new JRadioButton("Feminino");

        jf.setTitle("Tela de Registro de Frutas");
        jf.setSize(450,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(3,1));

        txtA = new JTextArea(5,20);
        scrP = new JScrollPane(txtA);

        lblTitle.setFont(new Font("CENTURY",Font.ITALIC,30));
        lblTitle.setForeground(Color.BLUE);

        panTitle.setLayout(new GridLayout(1,4));
        panFrutas.setLayout(new GridLayout(2,2));

        panTxtA.setLayout(new FlowLayout());
        panTxtA.setBackground(Color.DARK_GRAY);
        panFrutas.setBackground(Color.CYAN);

        panTitle.add(lblTitle);

        panFrutas.add(lblChoice);
        panFrutas.add(cbFrutas);
        panFrutas.add(radM);
        panFrutas.add(radF);

        bg.add(radF);
        bg.add(radM);

        panTxtA.add(lFrutas);
        panTxtA.add(scrP);


        jf.add(panTitle);
        jf.add(panFrutas);
        jf.add(panTxtA);
        jf.setVisible(true);
    }
}
