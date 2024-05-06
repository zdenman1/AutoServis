package org.example;

import org.example.car.CarRepository;
import org.example.car.InMemoryCarRepository;
import org.example.order.InMemoryOrderRepository;
import org.example.order.OrderRepository;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {


		CarRepository carRepository = new InMemoryCarRepository();
		OrderRepository orderRepository = new InMemoryOrderRepository();

		System.out.println(carRepository.getAll());


//		Obraz obraz = new Obraz(carRepository);
//		obraz.createMenuBar();
//		obraz.createKancelarFrame();
//		obraz.createGarazFrame();

		AppFrame appFrame = new AppFrame(orderRepository);
		appFrame.pack();
		appFrame.setVisible(true);

	}
}