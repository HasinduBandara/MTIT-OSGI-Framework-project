package com.gymOwner.payment;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
	ServiceRegistration paymentServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("=================FLEX FITNESS GYM Payment Service starts=================");
		PaymentService paymentService = new PaymentServiceImpl();
		paymentServiceRegistration = context.registerService(PaymentService.class.getName(), paymentService, null);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("!!==============FLEX FITNESS GYM Payment Service stops===================!!");
		System.out.println("Thank you for using our service...Have a Nice day!!");
		paymentServiceRegistration.unregister();

	}

}
