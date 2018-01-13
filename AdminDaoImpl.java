package org.pmi.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.pmi.dao.AdminDao;
import org.pmi.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDaoImpl implements AdminDao {
	private EntityManagerFactory enf;

	@Autowired
	public AdminDaoImpl(EntityManagerFactory enf) {

		this.enf = enf;
	}
	
	
	@Override
	public List<Admin> listAdmin() {
		EntityManager en = enf.createEntityManager();
		return en.createQuery("from Admin", Admin.class).getResultList();
	}

	@Override
	public Admin saveOrUpdate(Admin admin) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		Admin saved = em.merge(admin);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Admin getIdAdmin(Integer admin_id) {
		EntityManager em = enf.createEntityManager();
		return em.find(Admin.class, admin_id);
	}

	@Override
	public void hapus(Integer admin_id) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Admin.class, admin_id));
		em.getTransaction().commit();
		
	}

	
}