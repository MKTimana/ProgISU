import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Estudante extends JFrame implements ActionListener {
    private JLabel lblNome, lblCurso, lblIdade, lblDias, lblGenero, lblHeader, lblFooter;
    private JTextField txtNome;
    private JComboBox cboCurso, cboIdade;
    private JCheckBox ck2, ck3, ck4, ck5, ck6, ckSabado, ckDomingo;
    private JRadioButton radMasc, radFem;
    private ButtonGroup bg;
    private JButton btnSubmeter, btnSair;
    private JPanel panHeader, panFooter, panEst, pan, panWest, panCheck, panRad;

    String cursos[] = { "Educacao Fisica", "Gastronomia", "Engenharia e Ciencias de Computacao",
            "Engenharia Electronica", "Engenharia Informatica e Telecomunicacoes" };
    String idades[] = { "16", "17", "18", "19", "20", "21", "22", "23" };

    public Estudante() {
        this.setTitle("Inscricao de estudante");
        this.setSize(690, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        bg = new ButtonGroup();
        radFem = new JRadioButton("Feminino");
        radMasc = new JRadioButton("Masculino");

        bg.add(radMasc);
        bg.add(radFem);

        panRad = new JPanel();
        panRad.add(radMasc);
        panRad.add(radFem);
        radMasc.setSelected(true);

        cboCurso = new JComboBox(cursos);
        cboIdade = new JComboBox(idades);

        panHeader = new JPanel();
        panHeader.setLayout(new GridLayout(1, 1));
        lblHeader = new JLabel("===========================Janela de inscricao no ISUTC==============================");
        panHeader.add(lblHeader);

        panWest = new JPanel();
        panWest.setLayout(new GridLayout(5, 1));
        lblCurso = new JLabel("Nome do Curso");
        lblDias = new JLabel("Dias de estudo");
        lblGenero = new JLabel("Genero");
        lblNome = new JLabel("Nome do Estudante");
        lblIdade = new JLabel("Idade do estudante");
        panWest.add(lblNome);
        panWest.add(lblCurso);
        panWest.add(lblIdade);
        panWest.add(lblDias);
        panWest.add(lblGenero);

        panEst = new JPanel();
        panEst.setLayout(new GridLayout(5, 1));
        panCheck = new JPanel();
        ck2 = new JCheckBox("2 feira");
        ck3 = new JCheckBox("3 feira");
        ck4 = new JCheckBox("4 feira");
        ck5 = new JCheckBox("5 feira");
        ck6 = new JCheckBox("6 feira");
        ckSabado = new JCheckBox("Sabado");
        ckDomingo = new JCheckBox("Domingo");

        panCheck.add(ck2);
        panCheck.add(ck3);
        panCheck.add(ck4);
        panCheck.add(ck5);
        panCheck.add(ck6);
        panCheck.add(ckSabado);
        panCheck.add(ckDomingo);

        txtNome = new JTextField(10);
        panEst.add(txtNome);
        panEst.add(cboCurso);
        panEst.add(cboIdade);
        panEst.add(panCheck);
        panEst.add(panRad);

        pan = new JPanel();
        pan.setLayout(new GridLayout(5, 1));

        panFooter = new JPanel();
        panFooter.setLayout(new GridLayout(2, 1));
        btnSubmeter = new JButton("Submeter");
        btnSubmeter.addActionListener(this);
        btnSair = new JButton("Sair");
        btnSair.addActionListener(this);
        lblFooter = new JLabel("=====================Direitos reservados ao ISUTC=====================");
        panFooter.add(btnSubmeter);
        panFooter.add(btnSair);
        panFooter.add(lblFooter);

        this.add(panHeader, (BorderLayout.NORTH));
        this.add(panWest, (BorderLayout.WEST));
        this.add(pan, (BorderLayout.CENTER));
        this.add(panEst, (BorderLayout.EAST));
        this.add(panFooter, (BorderLayout.SOUTH));

    }

    private int idade;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmeter) {
            idade = Integer.parseInt(cboIdade.getSelectedItem().toString());

            if (idade < 18) {
                JOptionPane.showMessageDialog(
                        null,
                        "Não é permitida a inscrição devido à idade do estudante " + txtNome.getText(),
                        "ERRO",
                        JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null,
                        txtNome.getText() + " foi cadastrado no curso " + cboCurso.getSelectedItem().toString(),
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(e.getSource() == btnSair){
            new Autenticacao().setVisible(true);
            this.dispose();
        }

    }

}
