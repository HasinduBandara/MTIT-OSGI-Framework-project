package gymmemberconsumer;

import com.gymOwner.payment.PaymentService;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceActivator implements BundleActivator {

	ServiceReference paymentServiceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Starts FLEX FITNESS GYM Payment service Subscriber.!");
		paymentServiceReference = context.getServiceReference(PaymentService.class.getName());

		PaymentService paymentService = (PaymentService) context.getService(paymentServiceReference);

		Scanner scanner = new Scanner(System.in);

		double totalPayment = 0.0;

		System.out.println("*************************WELCOME TO FLEX FITNESS GYM CORNER*************************");
		System.out.println("");

		System.out.println("\t *************** OUR SERVICES & PACKAGES ***************");
		System.out.println("\t=============================================================");
		System.out.println("");

		System.out.println("\t******************* OUR SERVICES ************************");
		System.out.println("\t----------------------------------------------------------------");

		System.out.println("\t\t\t  1. One to One training");
		System.out.println("\t\t\t\t\t  # All our personal trainers are certified and ready to ");
		System.out.println("\t\t\t\t\t  help with whatever fitness goal you may have!");
		System.out.println("\t\t\t\t\t  # Rs. 2000 per one month ");
		System.out.println("");
		System.out.println("\t\t\t  2. Fitness checkup");
		System.out.println("\t\t\t\t\t  # Get your Body Mass Index and Fat Percentage ");
		System.out.println("\t\t\t\t\t  checked every month to keep track of your body composition.");
		System.out.println("\t\t\t\t\t  # Rs. 500 per one month ");
		System.out.println("");
		System.out.println("\t\t\t  3. Juice and supplyment bar");
		System.out.println("\t\t\t\t\t  # We have a supplement bar at the gym ");
		System.out.println("\t\t\t\t\t  with pre-workout, whey protein, BCAA, Greek Yoghurt and more!");
		System.out.println("");

		System.out.println("\t************************ PACKAGES ****************************");
		System.out.println("\t---------------------------------------------------------------");
		System.out.println("");

		System.out.println("\t\t\t  A. PLATINUM membership");
		System.out.println("\t\t----------------------------------------------------------------");
		System.out.println("\t\t\t\t 1 Year");
		System.out.println("\t\t\t\t  Gents     Rs. 50,000");
		System.out.println("\t\t\t\t  Ladies    Rs. 45,000");
		System.out.println("\t\t\t\t  Couple    Rs. 75,000");
		System.out.println("\t\t\t\t  Family (3 pax)    Rs. 95,000");
		System.out.println("\t\t\t\t  Time Duration: 4:00am to 12:00 Midnight");
		System.out.println("");
		System.out.println("\t\t=================================================================");
		System.out.println("");

		System.out.println("\t\t\t  B. GOLD membership");
		System.out.println("\t\t------------------------------------------------------------------");
		System.out.println("\t\t\t\t  1 Year");
		System.out.println("\t\t\t\t  Gents     Rs. 40,000");
		System.out.println("\t\t\t\t  Ladies    Rs. 40,000");
		System.out.println("\t\t\t\t  Time Duration: 4:00am to 4:30pm");
		System.out.println("");
		System.out.println("\t\t\t\t **1 Month Membership: Rs. 10,000 | Day Pass: Rs. 1,000");
		System.out.println("");
		System.out.println("\t\t==================================================================");
		System.out.println("");

		System.out.println("\t\t\t  C. SILVER membership");
		System.out.println("\t\t------------------------------------------------------------------");
		System.out.println("\t\t\t\t  3 Months");
		System.out.println("\t\t\t\t  Gents     Rs. 28,000");
		System.out.println("\t\t\t\t  Ladies    Rs. 28,000");
		System.out.println("\t\t\t\t  Time Duration: 4:00am to 12:00 Midnight");
		System.out.println("");
		System.out.println("\t\t===================================================================");
		System.out.println("");

		System.out.print("Which type of gym membership you want to subscribe (Platinum(P)/Gold(G)/Silver(S)): ");
		String memberType = scanner.next();

		while (!memberType.matches("[PGSpgs]")) {
			System.out.println("Invalid input! Please select from the given options (P/G/S): ");
			memberType = scanner.next();
		}



		switch (memberType.toUpperCase()) {
		case "P":
			String platinumType;
			do {
				System.out.print("Select membership type (Gents/G, Ladies/L, Couple/C, Family/F): ");
				platinumType = scanner.next().toUpperCase();

				if (platinumType.matches("[GLCFglcf]")) {
					totalPayment += (platinumType.equals("G") || platinumType.equals("L")) ? 45000
							: (platinumType.equals("C") ? 75000 : 95000);
				} else {
					System.out.println("Invalid input! Please select from the given options.");
				}
			} while (!platinumType.matches("[GLCFglcf]"));
			break;
		case "G":
			String goldType;
			do {
				System.out.print("Select membership type (Gents/G, Ladies/L): ");
				goldType = scanner.next().toUpperCase();

				if (goldType.matches("[GLgl]")) {
					totalPayment += (goldType.equals("G")) ? 40000 : 40000; 
				} else {
					System.out.println("Invalid input! Please select from the given options.");
				}
			} while (!goldType.matches("[GLgl]"));
			break;
		case "S":
			String silverType;
			do {
				System.out.print("Select membership type (Gents/G, Ladies/L): ");
				silverType = scanner.next().toUpperCase();

				if (silverType.matches("[GLgl]")) {
					totalPayment += (silverType.equals("G")) ? 28000 : 28000; 
				} else {
					System.out.println("Invalid input! Please select from the given options.");
				}
			} while (!silverType.matches("[GLgl]"));
			break;
		default:
			System.out.println("Invalid input! Please select from the given options.");
			return;
		}

		String additionalServices;
		do {
			System.out.println("Do you want to subscribe to additional services? (Y/N): ");
			additionalServices = scanner.next().toUpperCase();
			if (!additionalServices.matches("[YNyn]")) {
				System.out.println("Invalid input! Please enter 'Y' or 'N'.");
			}
		} while (!additionalServices.matches("[YN]"));

		if (additionalServices.equals("Y")) {
			System.out.println("Select additional services:");
			System.out.println("1. One to One training");
			System.out.println("2. Fitness checkup");

			System.out.print("Enter the service number to subscribe (comma-separated): ");
			String selectedServices = scanner.next();

			if (selectedServices.contains("1")) {
				totalPayment += 2000;
			}
			if (selectedServices.contains("2")) {
				totalPayment += 500;
			}
		}
		
		System.out.println("\t*************** OUR SERVICE INVOICE ***************");
		System.out.println("\t-------------------------------------------------------------");
		System.out.println("");
		System.out.println("\t\t Total Monthly Payment: Rs." + totalPayment);
		System.out.println("");
		System.out.println("\t=============================================================");
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stops Gym member service");
		context.ungetService(paymentServiceReference);
	}

}
