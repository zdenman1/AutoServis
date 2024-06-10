package org.example;

import org.example.car.CarRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Obraz {

	JMenuBar menuBar = new JMenuBar();
	CardLayout cardLayout = new CardLayout();
	JFrame frame = new JFrame();
	private CarRepository carRepository;

	public Obraz(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public void createMenuBar() {

		JMenu officeMenu = new JMenu("Kancelář");
		JMenu garageMenu = new JMenu("Garáž");

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

		officeMenu.add(zapisItem);
		officeMenu.add(hotovoItem);
		garageMenu.add(garazItem);

		menuBar.add(officeMenu);
		menuBar.add(garageMenu);

		JLabel label = new JLabel("Vítejte v systému autoservis Jarda z Vomáčkova.", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 40));

		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(cardLayout);
		frame.add(label, BorderLayout.CENTER);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	public void createKancelarFrame() {
		Zapis zapis = new Zapis(this.carRepository);
		frame.add(zapis.zapisGUI(), "zapisPanel");
	}

	public void createGarazFrame() {
		Garaz garaz = new Garaz(this.carRepository);
		frame.add(garaz.GarauFrame(), "garazPanel");
	}
}