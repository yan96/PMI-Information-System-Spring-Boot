package org.pmi.controller;







import javax.servlet.http.HttpServletRequest;

import org.pmi.dao.FormDonorDarahDao;
import org.pmi.dao.FormRequestDonorDarahDao;
import org.pmi.dao.LembagaDarahDao;
import org.pmi.dao.MasyarakatDao;
import org.pmi.models.FormRequestDonorDarah;
import org.pmi.models.LembagaDarah;
import org.pmi.models.Masyarakat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;







@Controller
public class MasyarakatController {
	@Autowired
	private MasyarakatDao mDao;
	
	@Autowired
	private LembagaDarahDao lDDao;
	
	@Autowired
	private FormRequestDonorDarahDao fRDDDao;
	@Autowired
	private FormDonorDarahDao fDDDao;
	
	@Autowired
	public MasyarakatController(MasyarakatDao mDao) {
		
		this.mDao = mDao;
	}
	
	@RequestMapping("/createAkun")
	public String tampilkanForm(Model model) {
		model.addAttribute("Masyarakat", new Masyarakat());
		return "formPendaftaranMasyarakat";
	}
	
	@RequestMapping("/editAkun")
	public String tampilkan(Model model) {
		model.addAttribute("Masyarakat", new Masyarakat());
		return "redirect:/LM";
	}
	
	@RequestMapping("/editAkunMasyarakat")
	public String tampilkan2(Model model) {
		model.addAttribute("Masyarakat", new Masyarakat());
		return "redirect:/profil";
	}
	
	@RequestMapping(value = "/createAkun", method = RequestMethod.POST)
	public String simpanDataMasyarakat(Model model, Masyarakat masyarakat ) {
		model.addAttribute("Masyarakat", mDao.saveOrUpdate(masyarakat));
		return "redirect:/login";
		
	} 

	
	@RequestMapping(value="/masyarakat/edit/{m_id}",method=RequestMethod.GET)
	public String updateProfilMasyarakat(@PathVariable Integer m_id,Model model){
		model.addAttribute("Masyarakat",mDao.getIdMasyarakat(m_id));
		return "EditMasyarakat";
		
	}
	
	@RequestMapping(value="/admin/edit/{m_id}",method=RequestMethod.GET)
	public String updateProfilMasyarakatbyAdmin(@PathVariable Integer m_id,Model model){
		model.addAttribute("Masyarakat",mDao.getIdMasyarakat(m_id));
		return "formEditMasyarakat";
		
	}
	
	
	@RequestMapping(value="/masyarakat/hapus/{m_id}")
	public String hapusMasyarakat(@PathVariable Integer m_id){
		mDao.hapus(m_id);
		return "redirect:/LM";
		
		
		
	}
	
	@RequestMapping("/profil")
	public String profilMasyarakat(Model model, HttpServletRequest request) {
		//model.addAttribute("Masyarakat", mDao.listMasyarakat() );
		model.addAttribute("idAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getM_id());
		model.addAttribute("namaDepanAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getNamaDepan());
		model.addAttribute("namaBelakangAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getNamaBelakang());
		model.addAttribute("emailAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getEmail());
		model.addAttribute("alamatAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getAlamat());
		model.addAttribute("noTeleponAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getNoTelepon());
		
		
		
		model.addAttribute("FormRequestDonorDarah",fRDDDao.listFormRequestDonorDarah());
		model.addAttribute("FormDonorDarah",fDDDao.listFormDonorDarah());
		
		return "profil";
	}
	
/*-----------------------------------request Darah-----------------------------------------*/	
	@RequestMapping("/RD")
	public String requestDonorDarah(Model model) {
		model.addAttribute("FormRequestDonorDarah", fRDDDao.listFormRequestDonorDarah());
		return "FormRequestDonorDarah";
	}
	
	
	
	
	
	
	@RequestMapping("/requestDonorDarah/create/{ld_id}")
	public String createFormDonorDarah(Model model, HttpServletRequest request,@PathVariable Integer ld_id) {
		
		//model.addAttribute("FormRequestDonorDarah", new FormRequestDonorDarah());
		model.addAttribute("idLembaga", lDDao.getIdLembagaDarah(ld_id));
		
		
		model.addAttribute("idAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getM_id());
		model.addAttribute("namaDepanAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getNamaDepan());
		model.addAttribute("namaBelakangAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getNamaBelakang());
		model.addAttribute("emailAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getEmail());
		model.addAttribute("alamatAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getAlamat());
		model.addAttribute("noTeleponAkun",((Masyarakat)request.getSession().getAttribute("akunLogin")).getNoTelepon());
		
		return "formRequestDonorDarah";
		
		
	}
	

	
	
	@RequestMapping(value = "/requestDonorDarah", method = RequestMethod.POST)
	public String request(Model model, FormRequestDonorDarah formRequestDonorDarah ,HttpServletRequest request ) {
		String namaPendonor = request.getParameter("pendonorFd");
		String namaLembagaDarah = request.getParameter("namFd");
		Integer lembaga_id = Integer.parseInt(request.getParameter("idFd"));
		Integer masyarakat_id = Integer.parseInt(request.getParameter("idM"));
		String noTlp = request.getParameter("noTelpFd");
		String rencanaDonorDarah = request.getParameter("rencanaFd");
		String golDarah = request.getParameter("golFd");
		String email = request.getParameter("emailFd");
		String status = "Waiting";

		
		
		
		FormRequestDonorDarah frdd = new FormRequestDonorDarah(0, namaPendonor, email, noTlp, rencanaDonorDarah, golDarah, status, namaLembagaDarah, masyarakat_id, lembaga_id);
		
		fRDDDao.saveOrUpdate(frdd);
		return "redirect:/LD";
		
	}
	
	
	@RequestMapping(value = "/showRequestDonorDarah" )
	public String tampilkanListRequest(Model model,HttpServletRequest request ) {
			model.addAttribute("idAkun",((LembagaDarah)request.getSession().getAttribute("akunLogin")).getLd_id());
			model.addAttribute("lembaga", lDDao.listLembagaDarah());
			model.addAttribute("FormRequestDonorDarah",fRDDDao.listFormRequestDonorDarah());
			return "listRequestDonorDarah";
		
	} 
	

	@RequestMapping ("/approveRequests/{fRDDarah_id}")
	public String approveRequest(@PathVariable Integer fRDDarah_id,  Model model)
	{
		FormRequestDonorDarah formRequest = fRDDDao.getIdFormRequestDonorDarah(fRDDarah_id);
		formRequest.setStatus("Accept");
		fRDDDao.saveOrUpdate(formRequest);
		return "redirect:/showRequestDonorDarah";
	}
		
		
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String SearchByKeyword(Model model, HttpServletRequest request){
		String namaDepan = request.getParameter("namaDepan");
		model.addAttribute("search", namaDepan);
		model.addAttribute("Masyarakat", mDao.find(namaDepan));
		return "listMasyarakat";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
