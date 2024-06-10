package org.example.car;

public record CarCreateParams(
		String brand,
		String model,
		int year,
		String registrationNumber,
		String vin
) {
}