package com.ahmad.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ahmad.entities.VehicleEntity;

@Repository
public class VehicleRepository {

	private SessionFactory sessionFactory;

	public void save(VehicleEntity vehicle) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}

	public VehicleEntity getById(Long id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		VehicleEntity v = (VehicleEntity) session.get(VehicleEntity.class, id);
		session.getTransaction();
		session.close();
		return v;

	}

	public List<VehicleEntity> getByYear(String year) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("select v from VehicleEntity v where v.year =:year");
		query.setParameter("year", year);

		 List<VehicleEntity> vehicles = query.list();

		session.getTransaction().commit();
		session.close();
		return vehicles;

	}
	public void update(VehicleEntity vehicle) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.merge(vehicle);
		session.getTransaction().commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
