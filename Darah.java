package org.pmi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Darah {
	
	@Id
	@GeneratedValue
	private Integer darah_id;
	private String jenis;
	private String rhesus;
	private String jumlah;

	
	
	public Integer getDarah_id() {
		return darah_id;
	}
	public void setDarah_id(Integer darah_id) {
		this.darah_id = darah_id;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public String getRhesus() {
		return rhesus;
	}
	public void setRhesus(String rhesus) {
		this.rhesus = rhesus;
	}
	public String getJumlah() {
		return jumlah;
	}
	public void setJumlah(String jumlah) {
		this.jumlah = jumlah;
	}
	
	


}
