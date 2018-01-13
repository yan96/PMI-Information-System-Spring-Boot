package org.pmi.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="formTransaksiDarah")
public class FormTransaksiDarah {
	
	@Id
	@GeneratedValue
	private Integer td_id;
	private String LDPemberi;
	private String LDPenerima;
	private String GolonganDarah;
	private String banyakDarah;
	
	
	
	
    @JoinColumn(name = "lembagaDarah_id")
    private Integer  lembaga_id;
	
	
	
	public Integer getTd_id() {
		return td_id;
	}
	public void setTd_id(Integer td_id) {
		this.td_id = td_id;
	}
	public String getLDPemberi() {
		return LDPemberi;
	}
	public void setLDPemberi(String lDPemberi) {
		LDPemberi = lDPemberi;
	}
	public String getLDPenerima() {
		return LDPenerima;
	}
	public void setLDPenerima(String lDPenerima) {
		LDPenerima = lDPenerima;
	}
	
	public String getGolonganDarah() {
		return GolonganDarah;
	}
	public void setGolonganDarah(String golonganDarah) {
		GolonganDarah = golonganDarah;
	}
	public String getBanyakDarah() {
		return banyakDarah;
	}
	public void setBanyakDarah(String banyakDarah) {
		this.banyakDarah = banyakDarah;
	}
	

}
