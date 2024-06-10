package org.example.repairshop;

import org.example.car.CarService;
import org.example.customer.CustomerService;
import org.example.invoice.InvoiceService;
import org.example.mechanic.MechanicService;
import org.example.order.OrderService;

public class RepairShop {

	private final CustomerService customerService;
	private final CarService carService;
	private final InvoiceService invoiceService;
	private final MechanicService mechanicService;
	private final OrderService orderService;

	public RepairShop(CustomerService customerService, CarService carService, InvoiceService invoiceService, MechanicService mechanicService, OrderService orderService) {
		this.customerService = customerService;
		this.carService = carService;
		this.invoiceService = invoiceService;
		this.mechanicService = mechanicService;
		this.orderService = orderService;
	}

	public CustomerService customer() {
		return this.customerService;
	}

	public CarService car() {
		return this.carService;
	}

	public InvoiceService invoice() {
		return this.invoiceService;
	}

	public MechanicService mechanic() {
		return this.mechanicService;
	}

	public OrderService order() {
		return this.orderService;
	}
}
