package org.pmi.impl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.pmi.dao.DarahDao;
import org.pmi.models.Darah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DarahDaoImpl implements DarahDao {
	private EntityManagerFactory enf;

	@Autowired
	public DarahDaoImpl(EntityManagerFactory enf) {

		this.enf = enf;
	}
	
	
	@Override
	public List<Darah> listDarah() {
		EntityManager en = enf.createEntityManager();
		return en.createQuery("from Darah", Darah.class).getResultList();
	}

	@Override
	public Darah saveOrUpdate(Darah darah) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		Darah saved = em.merge(darah);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Darah getIdDarah(Integer darah_id) {
		EntityManager em = enf.createEntityManager();
		return em.find(Darah.class, darah_id);
	}

	@Override
	public void hapus(Integer darah_id) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Darah.class, darah_id));
		em.getTransaction().commit();
		
	}


}
