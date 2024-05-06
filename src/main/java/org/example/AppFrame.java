package org.example;

import org.example.car.CarRepository;
import org.example.order.Order;
import org.example.order.OrderPanel;
import org.example.order.OrderRepository;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

	private static final Dimension PREFERRED_SIZE = new Dimension(600, 400);
	private JPanel currentPanel;
	private OrderRepository orderRepository;

	public AppFrame(OrderRepository orderRepository) throws HeadlessException {
		this.orderRepository = orderRepository;

		setTitle("Autoservis Jarda z Vomáčkova");
		setSize(PREFERRED_SIZE);
		setMinimumSize(PREFERRED_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		createGUI();
	}

	private void createWelcomePanel() {
		if (currentPanel != null) {
			return;
		}
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Vítejte v systému", SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 34));
		panel.add(label);
		add(panel, BorderLayout.CENTER);
	}

	private void createGUI() {

		createWelcomePanel();

		JMenuBar menuBar = new JMenuBar();
		JMenu officeMenu = new JMenu("Kancelář");
		JMenuItem orderItem = new JMenuItem("Objednávky");
		orderItem.addActionListener(e -> {
			if (currentPanel != null) {
				remove(currentPanel);
			}
			currentPanel = new OrderPanel(orderRepository);
			add(currentPanel, BorderLayout.CENTER);
			revalidate();
		});
		officeMenu.add(orderItem);

		JMenu garageMenu = new JMenu("Garáž");
		menuBar.add(officeMenu);
		menuBar.add(garageMenu);

		add(menuBar, BorderLayout.NORTH);
	}
}
