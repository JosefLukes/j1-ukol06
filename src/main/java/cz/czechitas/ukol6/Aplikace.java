package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;

    private JSpinner husyField;

    private JLabel kraliciLabel;

    private JSpinner kraliciField;

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

        //ODO implementovat formulář podle zadání
        SpinnerNumberModel modelHusy = new SpinnerNumberModel(1, 0, 100, 1);
        SpinnerNumberModel modelKralici = new SpinnerNumberModel(1, 0, 100, 1);

        husyField = new JSpinner();
        husyLabel = new JLabel("Počet hus");
        husyLabel.setDisplayedMnemonic('H');
        husyField.setModel(modelHusy);
        //husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel.setLabelFor(husyField);

        add(husyLabel);
        add(husyField);

        kraliciField = new JSpinner();
        kraliciLabel = new JLabel("Počet králíků");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciField.setModel(modelKralici);
        //kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        kraliciLabel.setLabelFor(kraliciField);

        add(kraliciLabel);
        add(kraliciField);

        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton, "span");

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

        husyField.addChangeListener(this::handleChangeHusy);
        kraliciField.addChangeListener(this::handleChangeKralici);
        vypocitatButton.addActionListener(this::handleVypocitat);
    }


    private void handleVypocitat(ActionEvent actionEvent) {
        int pocetHusCislo = (int) husyField.getValue();
        int pocetKralikuCislo = (int) kraliciField.getValue();
        int pocetHlav;
        int pocetNoh;
        pocetHlav = pocetHusCislo + pocetKralikuCislo;
        pocetNoh = pocetHusCislo * 2 + pocetKralikuCislo * 4;
        System.out.println("Počítám husy:" + pocetHusCislo);
        System.out.println("Počítám králíky:" + pocetKralikuCislo);
        System.out.println("Počítám hlavy:" + pocetHlav);
        System.out.println("Počítám nohy:" + pocetNoh);
        pocetHlavField.setText(Integer.toString(pocetHlav));
        pocetNohouField.setText(Integer.toString(pocetNoh));
    }

    private void handleChangeHusy(ChangeEvent changeEvent) {
        JSpinner spinner = (JSpinner) changeEvent.getSource();
        husyField.setValue(spinner.getValue());
    }
    private void handleChangeKralici(ChangeEvent changeEvent) {
        JSpinner spinner = (JSpinner) changeEvent.getSource();
        kraliciField.setValue(spinner.getValue());
    }
}