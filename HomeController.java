package org.pmi.controller;


import javax.servlet.http.HttpServletRequest;

import org.pmi.dao.DarahDao;
import org.pmi.dao.LembagaDarahDao;
import org.pmi.dao.MasyarakatDao;
import org.pmi.models.Masyarakat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {
	
	@Autowired
	private MasyarakatDao mDao;
	@Autowired
	private LembagaDarahDao LDDao;
	@Autowired
	private DarahDao dDao;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("Masyarakat", new Masyarakat());
		return "login";
	}

	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		
		if (mDao.loginMasyarakat(username, password)!= null) {
			request.getSession().setAttribute("akunLogin", mDao.loginMasyarakat(username, password));
			return "redirect:/homeMasyarakat";
		}
		
		
		else if (LDDao.loginLD(username, password)!= null) {	
			request.getSession().setAttribute("akunLogin", LDDao.loginLD(username, password));
			return "redirect:/homeLD ";
		}
		else if(username.equals("admin") && password.equals("admin")){
			request.getSession().setAttribute("akunLogin", mDao.loginMasyarakat(username, password));
			return "redirect:/homeAdmin";
		}

		return "login";
		
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request)
	{
		request.getSession().removeAttribute("Admin");
		request.getSession().removeAttribute("Masyarakat");
		request.getSession().removeAttribute("LembagaDarah");
		request.getSession().setAttribute("Admin", false);
		request.getSession().setAttribute("Masyarakat", false);
		request.getSession().setAttribute("LembagaDarah", false);
		return "redirect:/login";
	}

	
	
	@RequestMapping("/pmi")
	public String index(Model model){
		return "index";
	}
	
	
	
	@RequestMapping("/homeAdmin")
	public String homeAdmin(Model model){
		return "homeAdmin";
	}
	
	@RequestMapping("/homeMasyarakat")
	public String homeMasyarakat(Model model){
		model.addAttribute("Masyarakat", mDao.listMasyarakat() );
		model.addAttribute("LembagaDarah", LDDao.listLembagaDarah() );
		
		return "homeMasyarakat";
	}
	
	@RequestMapping("/homeLD")
	public String homeLD(Model model){
		return "homeLD";
	}
	
	
	@RequestMapping("/artikel")
	public String Artikel() {
		return "artikel";
	}
	
	
	
	@RequestMapping("/aboutUs")
	public String AboutUs() {
		return "aboutUs";
	}
	
	@RequestMapping("/contact")
	public String Contact() {
		return "contact";
	}
	
	
	
	
	@RequestMapping("/LD")
	public String lembagaDarahMasyarakat(Model model) {
		model.addAttribute("LembagaDarah", LDDao.listLembagaDarah() );
		return "ListLembagaDarah";
	}
	
	@RequestMapping("/LD2")
	public String lembagaDarahAdmin(Model model) {
		model.addAttribute("LembagaDarah", LDDao.listLembagaDarah() );
		return "ListLD";
	}
	 
	@RequestMapping("/LM")
	public String Masyarakat(Model model) {
		model.addAttribute("Masyarakat", mDao.listMasyarakat() );
		return "ListMasyarakat";
	}
	
	
	
	
	
	
}
