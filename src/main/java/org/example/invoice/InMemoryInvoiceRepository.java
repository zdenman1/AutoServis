package org.example.invoice;

import java.util.ArrayList;
import java.util.List;

public class InMemoryInvoiceRepository implements InvoiceRepository {

	private final List<Invoice> invoiceList;

	public InMemoryInvoiceRepository() {
		this.invoiceList = new ArrayList<>();
	}

	@Override
	public List<Invoice> getAll() {
		return this.invoiceList;
	}

	@Override
	public void create(Invoice invoice) {
		this.invoiceList.add(invoice);
	}
}
