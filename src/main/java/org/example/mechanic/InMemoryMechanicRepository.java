package org.example.mechanic;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMechanicRepository implements MechanicRepository {

	private final List<Mechanic> mechanicList;

	public InMemoryMechanicRepository() {
		this.mechanicList = new ArrayList<>();
	}

	@Override
	public List<Mechanic> getAll() {
		return mechanicList;
	}

	@Override
	public void create(Mechanic mechanic) {
		this.mechanicList.add(mechanic);
	}
}
