package org.pmi.models;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;






@Entity
public class Masyarakat {
	
	@Id
	@GeneratedValue
	
	private Integer m_id;
	private String username;
	private String password;
	private String namaDepan;
	private String namaBelakang;
	private String email;
	private String alamat;
	private String noTelepon;
	
	
	
	  
	
	
	
	
	
	public Masyarakat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Masyarakat(Integer m_id, String username, String password, String namaDepan, String namaBelakang,
			String email, String alamat, String noTelepon) {
		super();
		this.m_id = m_id;
		this.username = username;
		this.password = password;
		this.namaDepan = namaDepan;
		this.namaBelakang = namaBelakang;
		this.email = email;
		this.alamat = alamat;
		this.noTelepon = noTelepon;
		
	}
	
	
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNamaDepan() {
		return namaDepan;
	}
	public void setNamaDepan(String namaDepan) {
		this.namaDepan = namaDepan;
	}
	public String getNamaBelakang() {
		return namaBelakang;
	}
	public void setNamaBelakang(String namaBelakang) {
		this.namaBelakang = namaBelakang;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNoTelepon() {
		return noTelepon;
	}
	public void setNoTelepon(String noTelepon) {
		this.noTelepon = noTelepon;
	}
	
	
	
	
	
	
	
	
}
