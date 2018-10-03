package br.com.yansi.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.yansi.daos.ProductDAO;
import br.com.yansi.enums.BookType;
import br.com.yansi.models.Product;

@Controller
@Transactional
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
	
	@RequestMapping("/produtos")
	public String save (Product product) {
		
		System.out.println("Linha 31");
		
		productDAO.save(product);
		return "products/ok";
	}
}
