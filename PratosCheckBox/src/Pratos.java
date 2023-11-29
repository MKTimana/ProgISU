
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pratos extends JFrame implements ActionListener {
    // private JFrame jf;
    private JCheckBox cbFrangos;
    private JCheckBox cbTongas;
    private JCheckBox cbFeijoada;
    private JCheckBox cbTagliatela;
    private JButton btnTela;
    private ImageIcon img;

    public Pratos() {
        // jf = new JFrame("Pratos do User");
        this.setSize(250, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));

        // img = new ImageIcon("src/img/cancelar.jpg");
        btnTela = new JButton("Nova Tela");
        btnTela.addActionListener(this);
        btnTela.setToolTipText("Vai avançar para a tela de botoes");

        cbFeijoada = new JCheckBox("Feijoada com Dobrada");
        cbTongas = new JCheckBox("Prego Tongas");
        cbFrangos = new JCheckBox("Frango");
        cbTagliatela = new JCheckBox("Massa Tagliatela");

        cbFeijoada.addActionListener(this);
        cbTongas.addActionListener(this);
        cbFrangos.addActionListener(this);
        cbTagliatela.addActionListener(this);

        // cbFeijoada.setSelected(true);
        cbFeijoada.setMnemonic(KeyEvent.VK_F);
        cbFrangos.setMnemonic(KeyEvent.VK_R);
        cbTagliatela.setMnemonic(KeyEvent.VK_M);
        cbTongas.setMnemonic(KeyEvent.VK_T);

        this.add(btnTela);
        this.add(cbFeijoada);
        this.add(cbFrangos);
        this.add(cbTongas);
        this.add(cbTagliatela);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTela) {

            new Pratos().setVisible(false);
            new Botoes().setVisible(true);

         
        }
        if (e.getSource() == cbFeijoada) {
            JOptionPane.showMessageDialog(this, cbFeijoada.getText(), "Check", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == cbFrangos) {
            JOptionPane.showMessageDialog(this, cbFrangos.getText(), "Check", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == cbTagliatela) {
            JOptionPane.showMessageDialog(this, cbTagliatela.getText(), "Check", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == cbTongas) {
            JOptionPane.showMessageDialog(this, cbTongas.getText(), "Check", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
