package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.serv.DrinkService;
import org.generation.italy.demo.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductConroller {

	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/search")
	public String getSearchByName(Model model, @RequestParam(name = "query", required = false) String query) {
		
		List<Drink> drinks = null;
		
		if (query == null) {
			
			drinks = drinkService.findAll();
			
		} else {
			
			drinks = drinkService.searchByName(query);
			
		}
		
		List<Pizza> pizzas = null;
		
		if (query == null) {
			
			pizzas = pizzaService.findAll();
			
		} else {
			
			pizzas = pizzaService.searchByName(query);
			
		}
		
		model.addAttribute("pizzas", pizzas);
		
 		model.addAttribute("drinks", drinks);
 		
		model.addAttribute("query", query);
		
		return "product-search";
 	}
}
