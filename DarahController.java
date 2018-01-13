package org.pmi.controller;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;

import org.pmi.dao.DarahDao;
import org.pmi.models.Darah;
import org.pmi.models.LembagaDarah;
import org.pmi.models.Masyarakat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class DarahController {
	@Autowired
	private DarahDao dDao;
	
	@RequestMapping("/statistikA")
	public String StatistikA(Model model,HttpServletRequest request, Integer darah_id) {
		
		
		
		
		request.getSession().setAttribute("A+", dDao.getIdDarah(darah_id=1));
		model.addAttribute("A_Positif",((Darah)request.getSession().getAttribute("A+")).getJumlah());
		
		request.getSession().setAttribute("A-", dDao.getIdDarah(darah_id=2));
		model.addAttribute("A_Negatif",((Darah)request.getSession().getAttribute("A-")).getJumlah());
		
		request.getSession().setAttribute("B+", dDao.getIdDarah(darah_id=3));
		model.addAttribute("B_Positif",((Darah)request.getSession().getAttribute("B+")).getJumlah());
		
		request.getSession().setAttribute("B-", dDao.getIdDarah(darah_id=4));
		model.addAttribute("B_Negatif",((Darah)request.getSession().getAttribute("B-")).getJumlah());
		
		request.getSession().setAttribute("AB+", dDao.getIdDarah(darah_id=5));
		model.addAttribute("AB_Positif",((Darah)request.getSession().getAttribute("AB+")).getJumlah());
		
		request.getSession().setAttribute("AB-", dDao.getIdDarah(darah_id=6));
		model.addAttribute("AB_Negatif",((Darah)request.getSession().getAttribute("AB-")).getJumlah());
		
		request.getSession().setAttribute("O+", dDao.getIdDarah(darah_id=7));
		model.addAttribute("O_Positif",((Darah)request.getSession().getAttribute("O+")).getJumlah());
		
		request.getSession().setAttribute("O-", dDao.getIdDarah(darah_id=8));
		model.addAttribute("O_Negatif",((Darah)request.getSession().getAttribute("O-")).getJumlah());
		
		
		
		
		
		
		return "statistikA";
	}
	
	@RequestMapping("/statistikM")
	public String StatistikM(Model model,HttpServletRequest request, Integer darah_id) {
		
		
		
		
		request.getSession().setAttribute("A+", dDao.getIdDarah(darah_id=1));
		model.addAttribute("A_Positif",((Darah)request.getSession().getAttribute("A+")).getJumlah());
		
		request.getSession().setAttribute("A-", dDao.getIdDarah(darah_id=2));
		model.addAttribute("A_Negatif",((Darah)request.getSession().getAttribute("A-")).getJumlah());
		
		request.getSession().setAttribute("B+", dDao.getIdDarah(darah_id=3));
		model.addAttribute("B_Positif",((Darah)request.getSession().getAttribute("B+")).getJumlah());
		
		request.getSession().setAttribute("B-", dDao.getIdDarah(darah_id=4));
		model.addAttribute("B_Negatif",((Darah)request.getSession().getAttribute("B-")).getJumlah());
		
		request.getSession().setAttribute("AB+", dDao.getIdDarah(darah_id=5));
		model.addAttribute("AB_Positif",((Darah)request.getSession().getAttribute("AB+")).getJumlah());
		
		request.getSession().setAttribute("AB-", dDao.getIdDarah(darah_id=6));
		model.addAttribute("AB_Negatif",((Darah)request.getSession().getAttribute("AB-")).getJumlah());
		
		request.getSession().setAttribute("O+", dDao.getIdDarah(darah_id=7));
		model.addAttribute("O_Positif",((Darah)request.getSession().getAttribute("O+")).getJumlah());
		
		request.getSession().setAttribute("O-", dDao.getIdDarah(darah_id=8));
		model.addAttribute("O_Negatif",((Darah)request.getSession().getAttribute("O-")).getJumlah());
		
		
		
		
		
		
		return "statistikM";
	}
	
	@RequestMapping("/statistikLD")
	public String StatistikLD(Model model,HttpServletRequest request, Integer darah_id) {
		
		
		
		
		request.getSession().setAttribute("A+", dDao.getIdDarah(darah_id=1));
		model.addAttribute("A_Positif",((Darah)request.getSession().getAttribute("A+")).getJumlah());
		
		request.getSession().setAttribute("A-", dDao.getIdDarah(darah_id=2));
		model.addAttribute("A_Negatif",((Darah)request.getSession().getAttribute("A-")).getJumlah());
		
		request.getSession().setAttribute("B+", dDao.getIdDarah(darah_id=3));
		model.addAttribute("B_Positif",((Darah)request.getSession().getAttribute("B+")).getJumlah());
		
		request.getSession().setAttribute("B-", dDao.getIdDarah(darah_id=4));
		model.addAttribute("B_Negatif",((Darah)request.getSession().getAttribute("B-")).getJumlah());
		
		request.getSession().setAttribute("AB+", dDao.getIdDarah(darah_id=5));
		model.addAttribute("AB_Positif",((Darah)request.getSession().getAttribute("AB+")).getJumlah());
		
		request.getSession().setAttribute("AB-", dDao.getIdDarah(darah_id=6));
		model.addAttribute("AB_Negatif",((Darah)request.getSession().getAttribute("AB-")).getJumlah());
		
		request.getSession().setAttribute("O+", dDao.getIdDarah(darah_id=7));
		model.addAttribute("O_Positif",((Darah)request.getSession().getAttribute("O+")).getJumlah());
		
		request.getSession().setAttribute("O-", dDao.getIdDarah(darah_id=8));
		model.addAttribute("O_Negatif",((Darah)request.getSession().getAttribute("O-")).getJumlah());
		
		
		
		
		
		
		return "statistikLD";
	}
	
	@RequestMapping("/statistik")
	public String Statistik(Model model,HttpServletRequest request, Integer darah_id) {
		
		
		
		
		request.getSession().setAttribute("A+", dDao.getIdDarah(darah_id=1));
		model.addAttribute("A_Positif",((Darah)request.getSession().getAttribute("A+")).getJumlah());
		
		request.getSession().setAttribute("A-", dDao.getIdDarah(darah_id=2));
		model.addAttribute("A_Negatif",((Darah)request.getSession().getAttribute("A-")).getJumlah());
		
		request.getSession().setAttribute("B+", dDao.getIdDarah(darah_id=3));
		model.addAttribute("B_Positif",((Darah)request.getSession().getAttribute("B+")).getJumlah());
		
		request.getSession().setAttribute("B-", dDao.getIdDarah(darah_id=4));
		model.addAttribute("B_Negatif",((Darah)request.getSession().getAttribute("B-")).getJumlah());
		
		request.getSession().setAttribute("AB+", dDao.getIdDarah(darah_id=5));
		model.addAttribute("AB_Positif",((Darah)request.getSession().getAttribute("AB+")).getJumlah());
		
		request.getSession().setAttribute("AB-", dDao.getIdDarah(darah_id=6));
		model.addAttribute("AB_Negatif",((Darah)request.getSession().getAttribute("AB-")).getJumlah());
		
		request.getSession().setAttribute("O+", dDao.getIdDarah(darah_id=7));
		model.addAttribute("O_Positif",((Darah)request.getSession().getAttribute("O+")).getJumlah());
		
		request.getSession().setAttribute("O-", dDao.getIdDarah(darah_id=8));
		model.addAttribute("O_Negatif",((Darah)request.getSession().getAttribute("O-")).getJumlah());
		
		
		
		
		
		
		return "statistik";
	}
	

	@RequestMapping("/LD/add/darah")
	public String createLembagaDarah(Model model) {
		model.addAttribute("Darah", new Darah());
		return "formCreateLD";
	}
	
	@RequestMapping(value = "/LD/add/darah", method = RequestMethod.POST)
	public String simpanDarah(Model model, Darah dDarah ) {
		model.addAttribute("Darah", dDao.saveOrUpdate(dDarah));
		return "redirect:/login";
		
	} 
	
	

	@RequestMapping(value="/LD/darah/{darah_id}",method=RequestMethod.GET)
	public String showDarah(@PathVariable Integer darah_id,Model model){
		model.addAttribute("Darah",dDao.getIdDarah(darah_id));
		return "redirect:/LD/{darah_id}";
	}
	
	@RequestMapping(value="/darah/edit/{darah_id}",method=RequestMethod.GET)
	public String updateProfil(@PathVariable Integer darah_id,Model model){
		model.addAttribute("Darah",dDao.getIdDarah(darah_id));
		return "formCreateLD";
		
	}
	
	
	
	@RequestMapping(value="/darah/hapus/{darah_id}")
	public String hapus(@PathVariable Integer darah_id){
		dDao.hapus(darah_id);
		return "redirect:/login";
		
		
		
	}
}
