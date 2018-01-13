package org.pmi.dao;

import java.util.List;

import org.pmi.models.FormDonorDarah;





public interface FormDonorDarahDao {
	List <FormDonorDarah> listFormDonorDarah();
	FormDonorDarah saveOrUpdate (FormDonorDarah fDDarah);
	FormDonorDarah getIdFormDonorDarah(Integer fDDarah_id);
	void hapus(Integer fDDarah_id);

}
