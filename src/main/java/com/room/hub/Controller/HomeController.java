package com.room.hub.Controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.room.hub.Class.Clientes;
import com.room.hub.Repository.ClientesRepository;
 
@Controller
@RequestMapping("/home")
public class HomeController {
 
	@Autowired
	private ClientesRepository repository;
	
	@GetMapping
	public String home(Model model) {
		List<Clientes> clientes = (List<Clientes>) repository.findAll();
		model.addAttribute("Clientes", clientes);
		return "home";
	}
}
