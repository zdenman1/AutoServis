package org.example.order;

import javax.swing.*;

public class OrderPanel extends JPanel {

	private final OrderRepository orderRepository;
	private final String[] columnNames = {"ID", "Car", "Customer", "Mechanic", "Status"};

	public OrderPanel(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
		createGUI();
	}

	private Object[][] generateData() {
		return orderRepository.getAll().stream()
				.map(order -> new Object[]{order.getId(), order.getCar(), order.getCustomer(), order.getMechanic(), order.getStatus()})
				.toArray(Object[][]::new);
	}

	private void createGUI() {
		// create table with orders

		Object[][] data = generateData();

		JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		table.getTableHeader().setBounds(0, 0, 0, 0);

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		// create buttons for creating new order
		JButton createButton = new JButton("Nová objednávka");
		add(createButton);
	}
}
