import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Componentes {
//    Componentes
    private JFrame jf;
    private ImageIcon img;
    private JLabel lblTitle;
    private JLabel lblImg;
    private JLabel lblVermelho;
    private JLabel lblAzul;
    private JLabel lblAmarelo;
    private JLabel lblVerde;
    private JPanel pLabels;
    private JPanel pButtons;
    private JButton btnCancel;
    private JButton btnSubmit;
    private JButton btnClear;
    private JComboBox cbFrutas;
    private JScrollPane scrP;
    

//    Itens
    private String [] frutas;

    public Componentes() {
        jf = new JFrame();
        pLabels = new JPanel();
        pButtons = new JPanel();

        lblTitle = new JLabel("TELA DE REGISTROS");

        frutas = new String[]{"Marracuja","Banana","Uva","Maça"};
        cbFrutas = new JComboBox(frutas);

        jf.setSize(270, 450);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());
        jf.setTitle("Componentes");
        pLabels.setLayout(new GridLayout(4,1));
        pButtons.setLayout(new GridLayout(3,1));

        img = new ImageIcon("src/images/download.png");
        lblImg = new JLabel(img);
        lblAmarelo = new JLabel("Cor Amarelo");
        lblAzul = new JLabel("Cor Azul");
        lblVermelho = new JLabel("Cor Vermelho");
        lblVerde = new JLabel("Cor Verde");

        lblVermelho.setForeground(Color.red);
        lblAmarelo.setForeground(Color.yellow);
        lblAzul.setForeground(Color.blue);
        lblVerde.setForeground(Color.green);

        lblTitle.setFont(new Font("Consolas",Font.ITALIC,20));

        btnCancel = new JButton("Cancelar");
        btnSubmit = new JButton("Submeter");
        btnClear = new JButton("Limpar");

        btnCancel.setBackground(Color.red);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);

        btnSubmit.setBackground(Color.green);
        btnSubmit.setOpaque(true);
        btnSubmit.setBorderPainted(false);

        btnClear.setBackground(Color.yellow);
        btnClear.setOpaque(true);
        btnClear.setBorderPainted(false);
        jf.add(lblTitle);
        jf.add(lblImg);
        jf.add(cbFrutas);

        pButtons.add(btnSubmit);
        pButtons.add(btnClear);
        pButtons.add(btnCancel);
        pLabels.add(lblAmarelo);
        pLabels.add(lblAzul);
        pLabels.add(lblVermelho);
        pLabels.add(lblVerde);
        jf.add(pLabels);
        jf.add(pButtons);

        jf.setVisible(true);
    }
}
