package org.example;

import org.example.auto.AutoRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Obraz {

    private AutoRepository autoRepository;

    public Obraz(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    JMenuBar menuBar = new JMenuBar();
    CardLayout cardLayout = new CardLayout();
    JFrame frame = new JFrame();

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void createMenuBar() {

        JMenu kancelarMenu = new JMenu("Kancelar");
        JMenu garazMenu = new JMenu("Garáž");

        JMenuItem zapisItem = new JMenuItem("Zadat nové auto");
        JMenuItem hotovoItem = new JMenuItem("Auta k předání");

        JMenuItem garazItem = new JMenuItem("Otevřít garáž");

        zapisItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(frame.getContentPane(), "zapisPanel");
            }
        });

        hotovoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(frame.getContentPane(), "hotovoPanel");
            }
        });

        garazItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(frame.getContentPane(), "garazPanel");
            }
        });

        kancelarMenu.add(zapisItem);
        kancelarMenu.add(hotovoItem);
        garazMenu.add(garazItem);

        menuBar.add(kancelarMenu);
        menuBar.add(garazMenu);


        JLabel label = new JLabel("Vítejte v systému autoservis Jarda z Vomáčkova.", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 40));


        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(cardLayout);
        frame.add(label,BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);


    }

    public void createKancelarFrame() {
        Zapis zapis = new Zapis(this.autoRepository);
        frame.add(zapis.zapisGUI(), "zapisPanel");
    }

    public void createGarazFrame() {
        Garaz garaz = new Garaz(this.autoRepository);
        frame.add(garaz.GarauFrame(), "garazPanel");
    }
}