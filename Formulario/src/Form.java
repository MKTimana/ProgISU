import javax.swing.*;
import java.awt.*;

public class Form {
    private JFrame jf;

    private JPanel panHeader;
    private JPanel panFields;
    private JPanel panButtons;

    private JSeparator sep;

//    Labels
    private JLabel lblCod;
    private JLabel lblNum;
    private JLabel lblName;
    private JLabel lblAddress;
    private JLabel lblCell;
    private JLabel lblPostal;

//    TextFields
    private JTextField txtCod;
    private JTextField txtNum;
    private JTextField txtName;
    private JTextField txtAddress;
    private JTextField txtCell;
    private JTextField txtPostal;

//    RadioButton
    private JRadioButton radCor;
    private JRadioButton radPou;
    private ButtonGroup bg;

//    Buttons
    private JButton btnQuery;
    private JButton btnUpdate;
    private JButton btnClose;

    public Form(){
        jf = new JFrame("Formulario 1");
        jf.setSize(650,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());




        panButtons = new JPanel();

        sep = new JSeparator();

        lblCod = new JLabel("Codigo da Agencia:");
        lblNum = new JLabel("Numero da conta:");
        lblName = new JLabel("Nome:");
        lblAddress = new JLabel("Endereco:");
        lblCell = new JLabel("Telefone:");
        lblPostal = new JLabel("CPF:");

        txtCod = new JTextField(5);
        txtNum = new JTextField(5);
        txtName = new JTextField(25);
        txtAddress = new JTextField(25);
        txtCell = new JTextField(25);
        txtPostal = new JTextField(25);

        radCor = new JRadioButton("Conta Corrente");
        radPou = new JRadioButton("Conta Poupaça");
        bg = new ButtonGroup();
        bg.add(radCor);
        bg.add(radPou);

        btnQuery = new JButton("Consultar");
        btnUpdate = new JButton("Actualizar");
        btnClose = new JButton("Fechar");

        panHeader = new JPanel();
        panHeader.setLayout(new GridLayout(1,2));

        panHeader.add(lblCod);
        panHeader.add(txtCod);
        panHeader.add(lblNum);
        panHeader.add(txtNum);

        panFields = new JPanel();
        panFields.setLayout(new GridLayout(4,1));

        panFields.add(lblName);
        panFields.add(txtName);
        panFields.add(lblAddress);
        panFields.add(txtAddress);
        panFields.add(lblCell);
        panFields.add(txtCell);
        panFields.add(lblPostal);
        panFields.add(txtPostal);
        panFields.add(radCor);
        panFields.add(radPou);


        jf.add(panHeader);
        jf.add(panFields);
        jf.add(panButtons);
        jf.setVisible(true);
    }


}
