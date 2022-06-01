package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;

    private JTextField husyField;

    private JLabel kraliciLabel;

    private JTextField kraliciField;

    private JLabel pocetHlavLabel;

    private JLabel pocetNohouLabel;

    private JTextField pocetHlavField;

    private JTextField pocetNohouField;

    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmář Hejný 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(350, 250));

        //TODO implementovat formulář podle zadání

        husyField = new JTextField();
        husyLabel = new JLabel("Počet hus");
        husyLabel.setDisplayedMnemonic('H');
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Počet králíků");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);

        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton,"span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('L');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField.setEditable(false);
        pocetHlavField.setEnabled(true);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        add(pocetHlavLabel);
        add(pocetHlavField);


        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('N');
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField.setEditable(false);
        pocetNohouField.setEnabled(true);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        add(pocetNohouLabel);
        add(pocetNohouField);

        pack();

        vypocitatButton.addActionListener(this::handleVypocitat);
    }
    private void handleVypocitat(ActionEvent actionEvent) {
        int pocetHusCislo = Integer.parseInt(husyField.getText());
        int pocetKralikuCislo = Integer.parseInt(kraliciField.getText());
        int pocetHlav;
        int pocetNoh;
        pocetHlav = pocetHusCislo + pocetKralikuCislo;
        pocetNoh = pocetHusCislo*2 + pocetKralikuCislo*4;
        System.out.println("Počítám husy:" + pocetHusCislo);
        System.out.println("Počítám králiky:" + pocetKralikuCislo);
        System.out.println("Počítám hlavy:" + pocetHlav);
        System.out.println("Počítám nohy:" + pocetNoh);
        pocetHlavField.setText(Integer.toString(pocetHlav));
        pocetNohouField.setText(Integer.toString(pocetNoh));


        }


}
