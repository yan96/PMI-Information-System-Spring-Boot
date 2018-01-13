package org.pmi.controller;


import javax.servlet.http.HttpServletRequest;

import org.pmi.dao.FormDonorDarahDao;
import org.pmi.dao.FormRequestDonorDarahDao;
import org.pmi.dao.LembagaDarahDao;
import org.pmi.dao.MasyarakatDao;
import org.pmi.models.FormDonorDarah;
import org.pmi.models.LembagaDarah;
import org.pmi.models.Masyarakat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LembagaDarahController {
	
	
	@Autowired
	private FormDonorDarahDao fDDDao;
	@Autowired
	private LembagaDarahDao LDDao;
	@Autowired
	private MasyarakatDao mDao;
	@Autowired
	private FormRequestDonorDarahDao fRDDao;
	
	
	
	@Autowired
	public LembagaDarahController(LembagaDarahDao LDDao) {
		
		this.LDDao = LDDao;
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------------*/
	
	
	@RequestMapping("/formDonorDarah/create")
	public String createFormDonorDarah(Model model) {
		model.addAttribute("FormDonorDarah", new FormDonorDarah());
		return "formCreateFDD";
	}
	
	@RequestMapping(value = "/formDonorDarah/create", method = RequestMethod.POST)
	public String simpanDataFormDonorDarah(Model model, FormDonorDarah fDDarah ) {
		model.addAttribute("FormDonorDarah", fDDDao.saveOrUpdate(fDDarah));
		return "redirect:/fDD";
		
	} 
	
	

	@RequestMapping(value="/formDonorDarah/show/{fDDarah_id}",method=RequestMethod.GET)
	public String showFormDonorDarah(@PathVariable Integer fDDarah_id,Model model){
		model.addAttribute("LembagaDarah",fDDDao.getIdFormDonorDarah(fDDarah_id));
		return "redirect:/fDD/{fDDarah_id}";
	}
	
	@RequestMapping(value="/fDDarah_id/edit/{fDDarah_id}",method=RequestMethod.GET)
	public String updateFormDonorProfil(@PathVariable Integer fDDarah_id,Model model){
		model.addAttribute("LembagaDarah",fDDDao.getIdFormDonorDarah(fDDarah_id));
		return "formCreateFDD";
		
	}
	
	
	@RequestMapping(value="/fDDarah_id/hapus/{fDDarah_id}")
	public String hapus(@PathVariable Integer ld_id){
		fDDDao.hapus(ld_id);
		return "redirect:/FDD";
		
		
		
	}
	
	@RequestMapping("/profilLD")
	public String profilMasyarakat(Model model, HttpServletRequest request) {
		model.addAttribute("Masyarakat", LDDao.listLembagaDarah() );
		model.addAttribute("idAkun",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getLd_id());
		model.addAttribute("namaAkun",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getNama());
		model.addAttribute("faxAkun",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getFax());
		model.addAttribute("alamatAkun",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getAlamat());
		model.addAttribute("noTeleponAkun",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getNoTelepon());
		
		return "profilLD";
	}
	
	@RequestMapping("/addDonorDarah/{fRDDarah_id}")
	public String createFormDonorDarah(Model model, HttpServletRequest request, @PathVariable Integer fRDDarah_id) {
		model.addAttribute("idAkun",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getLd_id());
		model.addAttribute("namaLembagaDarah",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getNama());
		
		
		model.addAttribute("formDonor", fRDDao.getIdFormRequestDonorDarah(fRDDarah_id));
		return "formDonorDarah";
		
		
	}
	
	@RequestMapping(value="/addDonorDarah", method = RequestMethod.POST)
	public String simpanFormDonorDarah(Model model, HttpServletRequest request) {
		model.addAttribute("idAkun",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getLd_id());
		model.addAttribute("namaLembagaDarah",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getNama());
		String namaPendonor = request.getParameter("namaDD");
		String namaLD = request.getParameter("namaLD");
		String golonganDarah = request.getParameter("golonganDD");
		String banyakDarah = request.getParameter("banyakDD");
		String waktuDonor = request.getParameter("waktuDD");
		Integer masyarakat_id = Integer.parseInt(request.getParameter("idMDD"));
		Integer lembagaDarah_id = Integer.parseInt(request.getParameter("idLDD"));
		
		
		FormDonorDarah formDonor = new FormDonorDarah(0, namaPendonor, namaLD, golonganDarah, banyakDarah, waktuDonor, masyarakat_id, lembagaDarah_id);
		fDDDao.saveOrUpdate(formDonor);
		
		
		return "redirect:/showRequestDonorDarah";
		
		
	}
	
}
