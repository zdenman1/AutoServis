package org.example;

import org.example.car.CarCreateParams;
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

		RepairShop repairShop = getRepairShop();

		// Example of creating a car
		CarCreateParams createParams = new CarCreateParams("BMW", "X5", 2020, "ABC123", "1234567890");
		repairShop.car().create(createParams);

		System.out.println(repairShop.car().getAll());


//		AppFrame appFrame = new AppFrame(orderRepository);
//		appFrame.pack();
//		appFrame.setVisible(true);

	}

	/**
	 * This method creates a RepairShop object with all the dependencies
	 *
	 * @return RepairShop object
	 */
	private static RepairShop getRepairShop() {
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

		return new RepairShop(customerService, carService, invoiceService, mechanicService, orderService);
	}
}