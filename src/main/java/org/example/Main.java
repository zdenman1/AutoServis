package org.example;

import org.example.car.CarRepository;
import org.example.car.CarService;
import org.example.car.InMemoryCarRepository;
import org.example.customer.CustomerRepository;
import org.example.customer.CustomerService;
import org.example.customer.InMemoryCustomerRepository;
import org.example.invoice.InMemoryInvoiceRepository;
import org.example.invoice.InvoiceRepository;
import org.example.invoice.InvoiceService;
import org.example.mechanic.InMemoryMechanicRepository;
import org.example.mechanic.MechanicRepository;
import org.example.mechanic.MechanicService;
import org.example.order.InMemoryOrderRepository;
import org.example.order.OrderRepository;
import org.example.order.OrderService;
import org.example.repairshop.RepairShop;

public class Main {

	public static void main(String[] args) {

		CarRepository carRepository = new InMemoryCarRepository();
		OrderRepository orderRepository = new InMemoryOrderRepository();
		CustomerRepository customerRepository = new InMemoryCustomerRepository();
		MechanicRepository mechanicRepository = new InMemoryMechanicRepository();
		InvoiceRepository invoiceRepository = new InMemoryInvoiceRepository();

		CustomerService customerService = new CustomerService(customerRepository);
		OrderService orderService = new OrderService(orderRepository);
		InvoiceService invoiceService = new InvoiceService(invoiceRepository);
		MechanicService mechanicService = new MechanicService(mechanicRepository);
		CarService carService = new CarService(carRepository);

		RepairShop repairShop = new RepairShop(
				customerService,
				carService,
				invoiceService,
				mechanicService,
				orderService
		);

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