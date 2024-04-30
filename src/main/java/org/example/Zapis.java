package org.example;

import org.example.auto.Auto;
import org.example.auto.AutoRepository;
import org.example.zakaznik.MemoryZakaznikRepository;
import org.example.zakaznik.Zakaznik;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Zapis  {

    private final AutoRepository autoRepository;
    private final AutoTableModel autoTableModel;
    private final MemoryZakaznikRepository zakaznikRepository;
    private JComboBox<Zakaznik> zakaznikComboBox;
    private Garaz garaz;

    public Zapis(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
        this.autoTableModel = new AutoTableModel();
        this.zakaznikRepository = new MemoryZakaznikRepository();
        this.zakaznikComboBox = new JComboBox<>();
        this.garaz = new Garaz(autoRepository);
    }

    public Zapis(AutoRepository autoRepository, MemoryZakaznikRepository zakaznikRepository) {
        this.autoRepository = autoRepository;
        this.zakaznikRepository = zakaznikRepository;
        // inicializace atributů třídy
        autoTableModel = null;
    }


    JPanel zapisGUI() {
        JPanel zapisPanel = new JPanel(new GridLayout(11, 1));

        JLabel label = new JLabel("Zde zadejte nové auto a zákazníka", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 40));

        JPanel noveAuto = new JPanel(new FlowLayout());
        JLabel auto1 = new JLabel("Zadejte údaje o autě:");
        auto1.setFont(new Font("Serif", Font.BOLD, 15));
        JLabel vinPopis = new JLabel("Vin: ");
        JTextField vin = new JTextField(null, 15);
        JLabel znackaPopis = new JLabel("Značka: ");
        JTextField znacka = new JTextField(null, 11);
        JLabel modelPopis = new JLabel("Model: ");
        JTextField model = new JTextField(null, 11);
        JLabel rokPopis = new JLabel("Rok výroby: ");
        JTextField rok = new JTextField(null, 11);
        JLabel spzPopis = new JLabel("SPZ: ");
        JTextField spz = new JTextField(null, 11);
        noveAuto.add(znackaPopis);
        noveAuto.add(znacka);
        noveAuto.add(modelPopis);
        noveAuto.add(model);
        noveAuto.add(rokPopis);
        noveAuto.add(rok);
        noveAuto.add(spzPopis);
        noveAuto.add(spz);
        noveAuto.add(vinPopis);
        noveAuto.add(vin);


        JLabel lavel2 = new JLabel("Zadejte údaje o zákazníkovi:");
        lavel2.setFont(new Font("Serif", Font.BOLD, 15));
        JPanel novyzakaznik = new JPanel(new FlowLayout());
        JLabel jmenoPopis = new JLabel("Jméno: ");
        JTextField jmeno = new JTextField(null, 11);
        JLabel prijimenioPopis = new JLabel("Příjmení: ");
        JTextField prijimeni = new JTextField(null, 11);
        JLabel telPopis = new JLabel("Telefonní číslo: ");
        JTextField tel = new JTextField(null, 11);
        JLabel emailPopis = new JLabel("Email: ");
        JTextField email = new JTextField(null, 15);
        novyzakaznik.add(jmenoPopis);
        novyzakaznik.add(jmeno);
        novyzakaznik.add(prijimenioPopis);
        novyzakaznik.add(prijimeni);
        novyzakaznik.add(telPopis);
        novyzakaznik.add(tel);
        novyzakaznik.add(emailPopis);
        novyzakaznik.add(email);


        JLabel lavel3 = new JLabel("Zadejte informace o závadě:");
        lavel2.setFont(new Font("Serif", Font.BOLD, 15));
        JPanel novaZavada = new JPanel(new FlowLayout());
        JLabel castPopis = new JLabel("Zadejte kde je závada (motor/interier/exterier apod) :");
        JTextField castZavady = new JTextField(null, 11);
        JLabel detailPopis = new JLabel("Důkladně specifikujte co je špatně: ");
        JTextField detailZavady = new JTextField(null, 40);
        novaZavada.add(castPopis);
        novaZavada.add(castZavady);
        novaZavada.add(detailPopis);
        novaZavada.add(detailZavady);


        JPanel ulozit = new JPanel();
        JButton ulozitB = new JButton();
        ulozitB.setText("ULOŽIT");
        ulozitB.setFont(new Font("Serif", Font.BOLD, 25));
        ulozitB.setBackground(Color.GREEN);
        ulozitB.setForeground(Color.BLACK);
        ulozitB.setOpaque(true);
        ulozitB.setContentAreaFilled(true);
        ulozitB.setPreferredSize(new Dimension(180, 90));


        ulozitB.addActionListener(e -> {
            String prijmeniValue = prijimeni.getText();
            String jmenoValue = jmeno.getText();
            String telValue = tel.getText();
            String emailValue = email.getText();
            Zakaznik novyZakaznik = new Zakaznik(jmenoValue, prijmeniValue, Integer.toString(Integer.parseInt(telValue)), emailValue);

            String vinValue = vin.getText();
            String znackaValue = znacka.getText();
            String modelValue = model.getText();
            int rokValue = Integer.parseInt(rok.getText()); // assuming rok is an integer
            String spzValue = spz.getText();
            Auto noveAuto1 = new Auto(znackaValue, modelValue, rokValue, spzValue, vinValue, ""); // assuming the last parameter is a placeholder for now


            autoRepository.addAuto(noveAuto1);
            autoTableModel.addAuto(noveAuto1);

            zakaznikRepository.addZakaznik(novyZakaznik);

            AutoTableModel autoTableModel = new AutoTableModel();
            autoTableModel.addAuto(noveAuto1);


            List<Auto> auta = autoRepository.getAll();
            JComboBox<Auto> autoComboBox = new JComboBox<>(auta.toArray(new Auto[0]));

            autoComboBox.setModel(new DefaultComboBoxModel<>(auta.toArray(new Auto[0])));
            zakaznikComboBox.setModel(new DefaultComboBoxModel<>(zakaznikRepository.getAll().toArray(new Zakaznik[0])));

            garaz.updateTable();

        });

        zapisPanel.add(zakaznikComboBox);
        MemoryZakaznikRepository zakaznikRepository = new MemoryZakaznikRepository();



        ulozit.add(ulozitB);


        List<Auto> auta = autoRepository.getAll();


        JComboBox<Auto> autoComboBox = new JComboBox<>(auta.toArray(new Auto[0]));

        JComboBox<Zakaznik> zakaznikComboBox = new JComboBox<>();
        zapisPanel.add(zakaznikComboBox);





        zapisPanel.add(label);
        zapisPanel.add(auto1);
        zapisPanel.add(noveAuto);
        zapisPanel.add(lavel2);
        zapisPanel.add(novyzakaznik);
        zapisPanel.add(lavel3);
        zapisPanel.add(novaZavada);
        zapisPanel.add(ulozit);
        zapisPanel.add(zakaznikComboBox);
        zapisPanel.add(autoComboBox);






        return zapisPanel;
    }




}