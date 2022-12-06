package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String index(Model model) {
		
		List<Pizza> pizze = pizzaService.findAll();
		
		model.addAttribute("pizze", pizze);
		
		return "home";
	}
	
	@GetMapping("/pizza/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> optPizza = pizzaService.findPizzaById(id);
		
		Pizza selectedPizza = optPizza.get();
		
		model.addAttribute("selectedPizza", selectedPizza);
		
		return "show";
	}
	
	@GetMapping("/pizza/create")
	public String create(Model model) {
		
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		
		return "create";
	}
	
	@PostMapping("/pizza/create")
	public String store(@ModelAttribute("pizza") Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/update/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> optPizza = pizzaService.findPizzaById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "edit";
	}
	
	@PostMapping("/pizza/update")
	public String update(Pizza pizza) {
		
		pizzaService.save(pizza);		
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		
		Optional<Pizza> optPizza = pizzaService.findPizzaById(id);
		Pizza pizza = optPizza.get();
		
		pizzaService.delete(pizza);
		
		return "redirect:/";
	}
}
