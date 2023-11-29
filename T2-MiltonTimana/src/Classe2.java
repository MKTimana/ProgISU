import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Classe2 extends JFrame implements ActionListener {

    private JLabel lblNome;
    private JTextField txtNome;
    private JTextField txtValorI;

    private JLabel lblValor;
    private JButton btnSubmit;
    private JButton btnCancel;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem mDepositar;
    private JMenuItem mLevantar;
    private JMenuItem mExtracto;
    private JPanel pan;
    private JPanel panExtract;
    private JPanel panLevarpan;
    private JLabel lblNr;

    private int nrConta;
    Conta c = new Conta();

    Classe2() {
        Conta c = new Conta();
        this.setTitle("Login");
        this.setSize(420, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        nrConta = 136381093;
        lblNome = new JLabel("Nome");
        lblValor = new JLabel("Valor");
        txtNome = new JTextField(10);
        txtValorI = new JTextField(10);

        btnSubmit = new JButton("Depositar");
        btnSubmit.addActionListener(this);
        btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(this);

        menuBar = new JMenuBar();
        menu = new JMenu("Ficheiro");
        mDepositar = new JMenuItem("Depositar");
        mDepositar.addActionListener(this);
        mLevantar = new JMenuItem("Levantar");
        mLevantar.addActionListener(this);
        mExtracto = new JMenuItem("Extracto do cliente");
        mExtracto.addActionListener(this);

        menu.add(mDepositar);
        menu.add(mLevantar);
        menu.add(mExtracto);

        menuBar.add(menu);

        // String nome = JOptionPane.showInputDialog("Insira o seu nome");
        // String valorD = JOptionPane.showInputDialog("Insira o valor a depositar");
        // double db = Double.parseDouble(valorD);

        pan = new JPanel();
        pan.setLayout(new FlowLayout());

        this.setJMenuBar(menuBar);
        pan.add(lblNome);
        pan.add(txtNome);
        pan.add(lblValor);
        pan.add(txtValorI);
        pan.add(btnSubmit);
        lblNr = new JLabel(nrConta+"");
        panLevarpan = new JPanel();
        panLevarpan.setLayout(new FlowLayout());
        panLevarpan.add(lblNr);

        this.add(pan);
        this.add(panLevarpan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {

            String nome = txtNome.getText();
            double val = Double.parseDouble(txtValorI.getText());
            c.setNome(nome);
            c.setValorI(val);
            JOptionPane.showMessageDialog(this, "Saldo Inserido", "Submetidoo", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == mDepositar) {
            panExtract.setVisible(false);
            panLevarpan.setVisible(false);
            pan.setVisible(true);
        } else if (e.getSource() == mExtracto) {
            panLevarpan.setVisible(false);
            pan.setVisible(false);
            panExtract.setVisible(true);
        } else if (e.getSource() == mLevantar) {
            panExtract.setVisible(false);
            pan.setVisible(false);
            panLevarpan.setVisible(true);
        }
    }
}
