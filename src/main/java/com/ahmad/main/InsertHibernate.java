package com.ahmad.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ahmad.entities.VehicleEntity;
import com.ahmad.repository.VehicleRepository;

public class InsertHibernate {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
		VehicleRepository vr = (VehicleRepository) ctx.getBean("vehicleRepository");

		VehicleEntity ve = new VehicleEntity();
		ve.setMake("bmw");
		ve.setModel("aaa");
		ve.setYear("2048");

		vr.save(ve);

	}

}
