import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ParteC extends JFrame implements ActionListener {
    private JPanel cardPanel;
    private JButton btn1, btn2, btn3;

    public ParteC() {
        this.setTitle("Disposicao de Botoes");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        btn1 = new JButton("Botão 1");
        btn2 = new JButton("Botão 2");
        btn3 = new JButton("Botão 3");

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        cardPanel = new JPanel(new CardLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(btn3);

        // panel2.add(btn1);
        // panel2.add(btn3);

        // panel3.add(btn1);
        // panel3.add(btn2);

        cardPanel.add(panel1, "Painel 1");
        cardPanel.add(panel2, "Painel 2");
        cardPanel.add(panel3, "Painel 3");

        this.add(cardPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        if (e.getSource() == btn1) {
            cardLayout.show(cardPanel, "Painel 1");
        } else if (e.getSource() == btn2) {
            cardLayout.show(cardPanel, "Painel 2");
        } else if (e.getSource() == btn3) {
            cardLayout.show(cardPanel, "Painel 3");
        }
    }

    public static void main(String[] args) {

        new ParteC().setVisible(true);

    }
}
