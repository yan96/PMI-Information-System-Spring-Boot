package org.pmi.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="formDonorDarah")
public class FormDonorDarah {
	
	
	
	@Id
	@GeneratedValue
	private Integer dDarah_id;
	private String namaPendonor;
	private String namaLD;
	private String golonganDarah;
	private String banyakDarah;
	private String waktuDonor;
	
	
	
    @JoinColumn(name = "masyarakat_id")
    private Integer masyarakat_id;
	
	
    @JoinColumn(name = "lembagaDarah_id")
    private Integer lembagaDarah_id;
	
	
	
	
	
	
    
	
	
	public FormDonorDarah(Integer dDarah_id, String namaPendonor, String namaLD, String golonganDarah,
			String banyakDarah, String waktuDonor, Integer masyarakat_id, Integer lembagaDarah_id) {
		super();
		this.dDarah_id = dDarah_id;
		this.namaPendonor = namaPendonor;
		this.namaLD = namaLD;
		this.golonganDarah = golonganDarah;
		this.banyakDarah = banyakDarah;
		this.waktuDonor = waktuDonor;
		this.masyarakat_id = masyarakat_id;
		this.lembagaDarah_id = lembagaDarah_id;
	}



	public FormDonorDarah() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Integer getdDarah_id() {
		return dDarah_id;
	}
	public void setdDarah_id(Integer dDarah_id) {
		this.dDarah_id = dDarah_id;
	}
	public String getNamaPendonor() {
		return namaPendonor;
	}
	public void setNamaPendonor(String namaPendonor) {
		this.namaPendonor = namaPendonor;
	}
	public String getNamaLD() {
		return namaLD;
	}
	public void setNamaLD(String namaLD) {
		this.namaLD = namaLD;
	}
	public String getGolonganDarah() {
		return golonganDarah;
	}
	public void setGolonganDarah(String golonganDarah) {
		this.golonganDarah = golonganDarah;
	}
	public String getBanyakDarah() {
		return banyakDarah;
	}
	public void setBanyakDarah(String banyakDarah) {
		this.banyakDarah = banyakDarah;
	}


	public String getWaktuDonor() {
		return waktuDonor;
	}


	public void setWaktuDonor(String waktuDonor) {
		this.waktuDonor = waktuDonor;
	}


	public Integer getMasyarakat_id() {
		return masyarakat_id;
	}


	public void setMasyarakat_id(Integer masyarakat_id) {
		this.masyarakat_id = masyarakat_id;
	}


	public Integer getLembagaDarah_id() {
		return lembagaDarah_id;
	}


	public void setLembagaDarah_id(Integer lembagaDarah_id) {
		this.lembagaDarah_id = lembagaDarah_id;
	}
	
	
	
	

}
