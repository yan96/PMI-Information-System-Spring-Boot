package org.pmi.dao;

import java.util.List;

import org.pmi.models.Darah;

public interface DarahDao {
	List <Darah> listDarah();
	Darah saveOrUpdate (Darah darah);
	Darah getIdDarah(Integer darah_id);
	void hapus(Integer darah_id);

}
