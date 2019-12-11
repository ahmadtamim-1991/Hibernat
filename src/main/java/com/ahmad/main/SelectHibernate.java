package com.ahmad.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ahmad.entities.VehicleEntity;
import com.ahmad.repository.VehicleRepository;

public class SelectHibernate {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

		VehicleRepository vr = (VehicleRepository) ctx.getBean("vehicleRepository");

		System.out.println("select by id=2");

		VehicleEntity ve = vr.getById(2l);

		if (ve != null) {
			System.out.println(ve.toString());
		}
		System.out.println("select by year=2017");

		List<VehicleEntity> vehicles = vr.getByYear("2017");
		for (VehicleEntity a : vehicles) {
			System.out.println(a.toString());
		}

	}

}
