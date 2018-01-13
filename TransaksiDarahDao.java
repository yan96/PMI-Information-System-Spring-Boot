package org.pmi.dao;

import java.util.List;

import org.pmi.models.FormTransaksiDarah;

public interface TransaksiDarahDao {
	List <FormTransaksiDarah> listTransaksiDarah();
	FormTransaksiDarah saveOrUpdate (FormTransaksiDarah tDarah);
	FormTransaksiDarah getIdTransaksiDarah(Integer td_id);
	void hapus(Integer td_id);

}
