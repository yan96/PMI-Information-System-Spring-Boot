package org.pmi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class FormRequestDonorDarah {
	@Id
	@GeneratedValue
	private Integer fRDDarah_id;
	private String namaPendonor;
	private String email;
	private String noTlp;
	private String rencanaDonorDarah;
	private String golDarah;
	private String status;
	private String namaLembagaDarah;
	
	
	
    @JoinColumn(name = "masyarakat_id")
    private Integer  masyarakat_id;
	
	
    @JoinColumn(name = "lembagaDarah_id")
    private Integer  lembaga_id;
	
	
	
	public FormRequestDonorDarah() {
		super();
	}
	
	public FormRequestDonorDarah(Integer fRDDarah_id, String namaPendonor, String email, String noTlp,
			String rencanaDonorDarah, String golDarah, String status, String namaLembagaDarah, Integer masyarakat_id,
			Integer lembaga_id) {
		super();
		this.fRDDarah_id = fRDDarah_id;
		this.namaPendonor = namaPendonor;
		this.email = email;
		this.noTlp = noTlp;
		this.rencanaDonorDarah = rencanaDonorDarah;
		this.golDarah = golDarah;
		this.status = status;
		this.namaLembagaDarah = namaLembagaDarah;
		this.masyarakat_id = masyarakat_id;
		this.lembaga_id = lembaga_id;
	}

	public Integer getfRDDarah_id() {
		return fRDDarah_id;
	}
	public void setfRDDarah_id(Integer fRDDarah_id) {
		this.fRDDarah_id = fRDDarah_id;
	}
	public String getNamaPendonor() {
		return namaPendonor;
	}
	public void setNamaPendonor(String namaPendonor) {
		this.namaPendonor = namaPendonor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNoTlp() {
		return noTlp;
	}
	public void setNoTlp(String noTlp) {
		this.noTlp = noTlp;
	}
	public String getRencanaDonorDarah() {
		return rencanaDonorDarah;
	}
	public void setRencanaDonorDarah(String rencanaDonorDarah) {
		this.rencanaDonorDarah = rencanaDonorDarah;
	}
	public String getGolDarah() {
		return golDarah;
	}
	public void setGolDarah(String golDarah) {
		this.golDarah = golDarah;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public String getNamaLembagaDarah() {
		return namaLembagaDarah;
	}
	public void setNamaLembagaDarah(String namaLembagaDarah) {
		this.namaLembagaDarah = namaLembagaDarah;
	}
	public Integer getMasyarakat_id() {
		return masyarakat_id;
	}
	public void setMasyarakat_id(Integer masyarakat_id) {
		this.masyarakat_id = masyarakat_id;
	}

	public Integer getLembaga_id() {
		return lembaga_id;
	}

	public void setLembaga_id(Integer lembaga_id) {
		this.lembaga_id = lembaga_id;
	}

	
	
	
	
	
	
	
	
	
	

}
