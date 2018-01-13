package org.pmi.impl;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import org.pmi.dao.MasyarakatDao;
import org.pmi.models.Masyarakat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class MasyarakatDaoImpl implements MasyarakatDao {
	private EntityManagerFactory enf;

	@Autowired
	public MasyarakatDaoImpl(EntityManagerFactory enf) {

		this.enf = enf;
	}
	
	
	@Override
	public List<Masyarakat> listMasyarakat() {
		EntityManager en = enf.createEntityManager();
		return en.createQuery("from Masyarakat", Masyarakat.class).getResultList();
	}

	@Override
	public Masyarakat saveOrUpdate(Masyarakat masyarakat) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		Masyarakat saved = em.merge(masyarakat);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Masyarakat getIdMasyarakat(Integer m_id) {
		EntityManager em = enf.createEntityManager();
		return em.find(Masyarakat.class, m_id);
	}

	@Override
	public void hapus(Integer m_id) {
		EntityManager em = enf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Masyarakat.class, m_id));
		em.getTransaction().commit();
		
	}


	@Override
	public Masyarakat loginMasyarakat(String username, String password) {
		EntityManager em = enf.createEntityManager();
		try{
		Masyarakat masyarakat = em.createQuery("from Masyarakat where username=:username",Masyarakat.class).setParameter("username", username).getSingleResult();
		if(masyarakat != null && masyarakat.getPassword().equals(password)){
			return masyarakat;
		}
		return null;
		}catch(Exception ie){
			return null;
		}
	}


	@Override
	public List<Masyarakat> find(String namaDepan) {
		namaDepan = "%"+namaDepan+"%";
		EntityManager em = enf.createEntityManager();
		return em.createQuery("from Masyarakat where namaDepan like'"+namaDepan+"' or namaBelakang like '"+namaDepan+"'", Masyarakat.class).getResultList();
	}


	@Override
	public Masyarakat find(int m_id) {
		EntityManager em = enf.createEntityManager();
		return em.find(Masyarakat.class, m_id);
	}


	


	


}
