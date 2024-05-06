package org.example.mechanic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Mechanic {

	private String id;
	private String firstName;
	private String lastName;
	private List<WorkHour> workHours;

	public Mechanic(String id, String firstName, String lastName, List<WorkHour> workHours) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.workHours = workHours;
	}
}
