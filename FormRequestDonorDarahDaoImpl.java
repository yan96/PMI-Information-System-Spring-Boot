package org.pmi.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import org.pmi.dao.FormRequestDonorDarahDao;
import org.pmi.models.Darah;
import org.pmi.models.FormRequestDonorDarah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormRequestDonorDarahDaoImpl implements FormRequestDonorDarahDao {
	
	private EntityManagerFactory enf;

	@Autowired
	public FormRequestDonorDarahDaoImpl(EntityManagerFactory enf) {

		this.enf = enf;
	}

	@Override
	public List<FormRequestDonorDarah> listFormRequestDonorDarah() {
		EntityManager en = enf.createEntityManager();
		return en.createQuery("from FormRequestDonorDarah", FormRequestDonorDarah.class).getResultList();
	}

	@Override
	public FormRequestDonorDarah saveOrUpdate(FormRequestDonorDarah fRDonorDarah) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		FormRequestDonorDarah saved = em.merge(fRDonorDarah);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public FormRequestDonorDarah getIdFormRequestDonorDarah(Integer fRDDarah_id) {
		EntityManager em = enf.createEntityManager();
		return em.find(FormRequestDonorDarah.class, fRDDarah_id);
	}

	@Override
	public void hapus(Integer fRDDarah_id) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Darah.class, fRDDarah_id));
		em.getTransaction().commit();
		
	}

	

	
}

