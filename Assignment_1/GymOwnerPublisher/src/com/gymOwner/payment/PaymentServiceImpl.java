package com.gymOwner.payment;

public class PaymentServiceImpl implements PaymentService {
	private static final double GYM_MEMBERSHIP_PRICE = 3000.0;
	private static final double PERSONAL_TRAINER_PRICE = 2500.0;
	private static final double PERSONAL_FITNESS_PRICE = 2000.0;

	@Override
	public double calculateMonthlyPayment(boolean gymMembership, boolean personalTrainner,
			boolean personalFitness) {
		double totalPayment = 0.0;

		if (gymMembership)
			totalPayment += GYM_MEMBERSHIP_PRICE;
		if (personalTrainner)
			totalPayment += PERSONAL_TRAINER_PRICE;
		if (personalFitness)
			totalPayment += PERSONAL_FITNESS_PRICE;

		return totalPayment;
	}
}
