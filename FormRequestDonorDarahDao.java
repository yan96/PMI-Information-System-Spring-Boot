package org.pmi.dao;

import java.util.List;

import org.pmi.models.FormRequestDonorDarah;

public interface FormRequestDonorDarahDao {
	List <FormRequestDonorDarah> listFormRequestDonorDarah();
	FormRequestDonorDarah saveOrUpdate (FormRequestDonorDarah fRDDarah);
	FormRequestDonorDarah getIdFormRequestDonorDarah(Integer fRDDarah_id);
	void hapus(Integer fRDDarah_id);

}
