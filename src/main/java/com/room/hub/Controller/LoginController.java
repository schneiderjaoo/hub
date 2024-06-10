package com.room.hub.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.room.hub.bean.Clientes;
import com.room.hub.dao.ClientesRepository;
 
@Controller
@RequestMapping("/login")
public class LoginController {
 
	@Autowired 
	private ClientesRepository repository;
	
	@GetMapping
	public String login(Model model) {
		List<Clientes> clientes = (List<Clientes>) repository.findAll();
		model.addAttribute("Clientes", clientes);
		return "login";
	}
}
