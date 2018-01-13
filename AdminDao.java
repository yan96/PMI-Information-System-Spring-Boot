package org.pmi.dao;

import java.util.List;

import org.pmi.models.Admin;

public interface AdminDao {
	List <Admin> listAdmin();
	Admin saveOrUpdate (Admin admin);
	Admin getIdAdmin(Integer admin_id);
	void hapus(Integer admin_id);

}
