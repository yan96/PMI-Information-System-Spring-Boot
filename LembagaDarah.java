package org.pmi.models;


import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class LembagaDarah {
	@Id
	@GeneratedValue

	private Integer ld_id;
	private String username;
	private String password;
	private String nama;
	private String fax;
	private String noTelepon;
	private String alamat;
	
	private String kabupaten;
	private String typeLD; 
	
	
	
	
	
	
	
	
	
	

	
	
	
	public Integer getLd_id() {
		return ld_id;
	}
	public void setLd_id(Integer ld_id) {
		this.ld_id = ld_id;
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
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getNoTelepon() {
		return noTelepon;
	}
	public void setNoTelepon(String noTelepon) {
		this.noTelepon = noTelepon;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	public String getKabupaten() {
		return kabupaten;
	}
	public void setKabupaten(String kabupaten) {
		this.kabupaten = kabupaten;
	}
	public String getTypeLD() {
		return typeLD;
	}
	public void setTypeLD(String typeLD) {
		this.typeLD = typeLD;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	
	


}
