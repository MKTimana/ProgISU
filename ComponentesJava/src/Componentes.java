import javax.swing.*;
import java.awt.*;

public class Componentes {
    private JFrame jf;
    private ImageIcon img;

    public Componentes(){
        jf = new JFrame();
        jf.setTitle("Login");
        jf.setSize(350, 150);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());


        jf.setVisible(true);
    }
}
