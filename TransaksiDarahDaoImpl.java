package org.pmi.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.pmi.dao.TransaksiDarahDao;
import org.pmi.models.FormTransaksiDarah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TransaksiDarahDaoImpl implements TransaksiDarahDao {
	private EntityManagerFactory enf;

	@Autowired
	public TransaksiDarahDaoImpl(EntityManagerFactory enf) {

		this.enf = enf;
	}
	
	
	@Override
	public List<FormTransaksiDarah> listTransaksiDarah() {
		EntityManager en = enf.createEntityManager();
		return en.createQuery("from TransaksiDarah", FormTransaksiDarah.class).getResultList();
	}

	@Override
	public FormTransaksiDarah saveOrUpdate(FormTransaksiDarah tDarah) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		FormTransaksiDarah saved = em.merge(tDarah);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public FormTransaksiDarah getIdTransaksiDarah(Integer id) {
		EntityManager em = enf.createEntityManager();
		return em.find(FormTransaksiDarah.class, id);
	}

	@Override
	public void hapus(Integer id) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(FormTransaksiDarah.class, id));
		em.getTransaction().commit();
		
	}


}
