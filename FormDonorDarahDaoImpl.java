package org.pmi.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.pmi.dao.FormDonorDarahDao;
import org.pmi.models.Darah;
import org.pmi.models.FormDonorDarah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormDonorDarahDaoImpl implements FormDonorDarahDao {
	
	private EntityManagerFactory enf;

	@Autowired
	public FormDonorDarahDaoImpl(EntityManagerFactory enf) {

		this.enf = enf;
	}

	@Override
	public List<FormDonorDarah> listFormDonorDarah() {
		EntityManager en = enf.createEntityManager();
		return en.createQuery("from FormDonorDarah", FormDonorDarah.class).getResultList();
	}

	@Override
	public FormDonorDarah saveOrUpdate(FormDonorDarah formDonorDarah) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		FormDonorDarah saved = em.merge(formDonorDarah);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public FormDonorDarah getIdFormDonorDarah(Integer fDDarah_id) {
		EntityManager em = enf.createEntityManager();
		return em.find(FormDonorDarah.class, fDDarah_id);
	}

	@Override
	public void hapus(Integer fDDarah_id) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Darah.class, fDDarah_id));
		em.getTransaction().commit();
		
	}

	
}
