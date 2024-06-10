package org.example.invoice;

import java.util.List;

public interface InvoiceRepository {
	List<Invoice> getAll();

	void create(Invoice invoice);
}
