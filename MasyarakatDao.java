package org.pmi.dao;

import java.util.List;


import org.pmi.models.Masyarakat;




public interface MasyarakatDao {
	
	List <Masyarakat> listMasyarakat();
	Masyarakat loginMasyarakat(String username, String password);
	Masyarakat saveOrUpdate (Masyarakat masyarakat);
	Masyarakat getIdMasyarakat(Integer m_id);
	void hapus(Integer m_id);
	
	List<Masyarakat> find(String namaDepan);
	Masyarakat find(int m_id);

}
