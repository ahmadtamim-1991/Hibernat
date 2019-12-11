package com.ahmad.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ahmad.entities.VehicleEntity;
import com.ahmad.repository.VehicleRepository;

public class UpdateHibernate {

	public static void main(String[] args) {
	 
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

		VehicleRepository vr = (VehicleRepository) ctx.getBean("vehicleRepository");
		
		System.out.println("select by id=1");
		VehicleEntity ve=vr.getById(1l);
		
		ve.setMake("landaghar");
		ve.setModel("koshad");
		vr.update(ve);

	}

}
