package org.example.mechanic;

import java.util.List;

public interface MechanicRepository {
	List<Mechanic> getAll();

	void create(Mechanic mechanic);
}
