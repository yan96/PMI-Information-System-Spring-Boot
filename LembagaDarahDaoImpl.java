package org.pmi.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.pmi.dao.LembagaDarahDao;
import org.pmi.models.LembagaDarah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LembagaDarahDaoImpl implements LembagaDarahDao{
	private EntityManagerFactory enf;

	@Autowired
	public LembagaDarahDaoImpl(EntityManagerFactory enf) {

		this.enf = enf;
	}
	
	
	@Override
	public List<LembagaDarah> listLembagaDarah() {
		EntityManager en = enf.createEntityManager();
		return en.createQuery("from LembagaDarah", LembagaDarah.class).getResultList();
	}

	@Override
	public LembagaDarah saveOrUpdate(LembagaDarah lDarah) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		LembagaDarah saved = em.merge(lDarah);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public LembagaDarah getIdLembagaDarah(Integer ld_id) {
		EntityManager em = enf.createEntityManager();
		return em.find(LembagaDarah.class, ld_id);
	}

	@Override
	public void hapus(Integer ld_id) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(LembagaDarah.class, ld_id));
		em.getTransaction().commit();
		
	}


	@Override
	public LembagaDarah loginLD(String username, String password) {
		EntityManager em = enf.createEntityManager();
		try{
		LembagaDarah lDarah = em.createQuery("from LembagaDarah where username=:username",LembagaDarah.class).setParameter("username", username).getSingleResult();
		if(lDarah != null && lDarah.getPassword().equals(password)){
			return lDarah;
		}
		return null;
		}catch(Exception ie){
			return null;
		}
	}
	

}
