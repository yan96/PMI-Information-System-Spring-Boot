package org.pmi.dao;

import java.util.List;


import org.pmi.models.LembagaDarah;

public interface LembagaDarahDao {
	
	LembagaDarah loginLD(String username, String password);
	List <LembagaDarah> listLembagaDarah();
	LembagaDarah saveOrUpdate (LembagaDarah lDarah);
	LembagaDarah getIdLembagaDarah(Integer ld_id);
	void hapus(Integer ld_id);

}
