package org.example.mechanic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WorkHour {
	private String day;
	private String from;
	private String to;

	public WorkHour(String day, String from, String to) {
		this.day = day;
		this.from = from;
		this.to = to;
	}
}
