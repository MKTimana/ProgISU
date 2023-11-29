import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botoes extends JFrame implements ActionListener{
    // private JFrame jf;
    private JButton btnCancelar;
    private JButton btnSubmit;
    private JButton btnPrev;
    private JButton btnNext;
    

    private ImageIcon img;

    public Botoes() {
        this.setSize(350, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        img = new ImageIcon("src/img/cancel.png");
        btnCancelar = new JButton(img);
        btnCancelar.setToolTipText("Este botao serve para cancelar");
        btnCancelar.addActionListener(this);

        btnNext = new JButton("Proximo");
        btnPrev = new JButton("Anterior");
        btnSubmit = new JButton("Subtmeter");

        this.add(btnCancelar);
        this.add(btnNext);
        this.add(btnPrev);
        this.add(btnSubmit);

        // this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnCancelar){
            // new Botoes().setVisible(false);
            // new Pratos().setVisible(true);
        }
    }
}
