package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.serv.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drinks")
public class DrinkController {

	@Autowired
	private DrinkService drinkService;
	
	
	@GetMapping
	public String drinkIndex(Model model) {
		
		List<Drink> drinks = drinkService.findAll();
		
		model.addAttribute("drinks", drinks);
		
		return "drink-index";
	}
	
	@GetMapping("/show-drink/{id}")
	public String showDrink(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		
		Drink selectedDrink = optDrink.get();
		
		model.addAttribute("selectedDrink", selectedDrink);
		
		return "show-drink";
	}
	
	@GetMapping("/create-drink")
	public String createDrink(Model model) {
		
		Drink drink = new Drink();
		model.addAttribute("drink", drink);
		
		return "create-drink";
	}
	
	@PostMapping("/create-drink")
	public String storeDrink(@ModelAttribute("drink") Drink drink) {
		
		drinkService.save(drink);
		
		return "redirect:/drinks";
	}
	
	@GetMapping("/edit-drink/{id}")
	public String editDrink(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		
		Drink drink = optDrink.get();
		
		model.addAttribute("drink", drink);
		
		return "edit-drink";
	}
	
	@PostMapping("/edit-drink")
	public String updateDrink(Drink drink) {
		
		drinkService.save(drink);		
		
		return "redirect:/drinks";
	}
	
	@GetMapping("/delete-drink/{id}")
	public String deleteDrink(@PathVariable("id") int id) {
		
		Optional<Drink> optDrink = drinkService.findDrinkById(id);
		
		Drink drink = optDrink.get();
		
		drinkService.delete(drink);
		
		return "redirect:/drinks";
	}
}