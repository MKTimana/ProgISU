import javax.swing.*;
import java.awt.*;

public class Mt {
    private JFrame jf;
    private JPanel panBanner;
    private JPanel panComp;
    private JPanel panButtons;
    private JPanel panFields;
    private JPanel panTa;
    private JPanel panCompAll;

    private JLabel lblImageBanner;
    private JLabel lblName;
    private JLabel lblSex;
    private JLabel lblCourse;
    private JLabel lblFun;
    private JLabel lblCopy;

    private JTextField txtName;
    private JTextArea taText;

    private ButtonGroup bg;
    private JRadioButton radMasc;
    private JRadioButton radFem;


    private ImageIcon img;

    private JButton btnClear;
    private JButton btnSubmit;
    private JButton btnProgrammer;

    private JComboBox cboCourses;

    private String [] cursos;
    private String [] fun;
    private JList lFun;
private JScrollPane scr;


    public Mt(){
        jf = new JFrame("Exercicio 1");
        jf.setSize(760,370);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(2,1));


        panBanner = new JPanel(new FlowLayout());
        img = new ImageIcon("src/img/img.png");
        lblImageBanner = new JLabel(img);
        panBanner.add(lblImageBanner);

        panComp = new JPanel(new GridLayout(1,3));
//        panComp = new JPanel(new FlowLayout());

        panButtons = new JPanel(new GridLayout(3,1));
        btnClear = new JButton("Limpar");
        btnSubmit = new JButton("Submeter");
        btnProgrammer = new JButton("Programador");

//        btnSubmit.setMaximumSize(new Dimension(10,10));
//        btnProgrammer.setMaximumSize(new Dimension(10,10));
//        btnClear.setMaximumSize(new Dimension(10,10));

        panButtons.add(btnClear);
        panButtons.add(btnSubmit);
        panButtons.add(btnProgrammer);

        panFields = new JPanel(new FlowLayout());
//        panFields = new JPanel(new GridLayout(2,1));
        lblName = new JLabel("Nome");
        txtName = new JTextField(10);
        lblCourse = new JLabel("Curso");
        cursos=new String[]{"Informatica","Contabilidade","Civil","Auditoria"};
        cboCourses = new JComboBox(cursos);
        lblSex = new JLabel("Sexo");
        radMasc = new JRadioButton("Masculino");
        radFem = new JRadioButton("Feminino");
        bg = new ButtonGroup();
        bg.add(radMasc);
        bg.add(radFem);
        lblFun = new JLabel("Diversao");
        fun = new String[]{"Futebol","Andebol","internet","Ler"};
        lFun = new JList(fun);



        panFields.add(lblName);
        panFields.add(txtName);
        panFields.add(lblCourse);
        panFields.add(cboCourses);
        panFields.add(lblSex);
        panFields.add(radMasc);
        panFields.add(radFem);
        panFields.add(lblFun);
        panFields.add(lFun);

        panTa = new JPanel(new FlowLayout());
        taText = new JTextArea(10,25);
        taText.setBackground(Color.CYAN);
        scr = new JScrollPane(taText);
        panTa.add(scr);



        panComp.add(panButtons);
        panComp.add(panFields);
        panComp.add(panTa);


lblCopy = new JLabel("Direitos reservados ao autor MK");
lblCopy.setForeground(Color.blue);
//lblCopy.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);

    jf.add(panBanner);
    jf.add(panComp);
//    jf.add(lblCopy);
    jf.setVisible(true);
    }
}
