package org.pmi.controller;


import org.pmi.dao.LembagaDarahDao;
import org.pmi.dao.MasyarakatDao;
import org.pmi.models.LembagaDarah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@Autowired
	private LembagaDarahDao lDao;
	@Autowired
	private MasyarakatDao mDao;
	public void createLembagaDarah(){
		
	}
	
	@RequestMapping("/admin/create/lembagaDarah")
	public String createLembagaDarah(Model model) {
		model.addAttribute("LembagaDarah", new LembagaDarah());
		return "formCreateLD";
	}
	
	@RequestMapping(value = "/admin/create/lembagaDarah", method = RequestMethod.POST)
	public String simpanDataMasyarakat(Model model, LembagaDarah lDarah ) {
		model.addAttribute("LembagaDarah", lDao.saveOrUpdate(lDarah));
		return "redirect:/LD2";
		
	} 
	
	

	@RequestMapping(value="/LembagaDarah/profil/{ld_id}",method=RequestMethod.GET)
	public String showProfil(@PathVariable Integer ld_id,Model model){
		model.addAttribute("LembagaDarah",lDao.getIdLembagaDarah(ld_id));
		return "lembagaDarah";
	}
	
	@RequestMapping(value="/LembagaDarah/edit/{ld_id}",method=RequestMethod.GET)
	public String updateProfil(@PathVariable Integer ld_id,Model model){
		model.addAttribute("LembagaDarah",lDao.getIdLembagaDarah(ld_id));
		return "formEditLD";
		
	}
	
	
	
	
	@RequestMapping(value="/LembagaDarah/hapus/{ld_id}")
	public String hapus(@PathVariable Integer ld_id){
		lDao.hapus(ld_id);
		return "redirect:/LD2";
		
		
		
	}
	

}
