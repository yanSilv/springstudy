package br.com.yansi.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.yansi.daos.ProductDAO;
import br.com.yansi.enums.BookType;
import br.com.yansi.models.Product;

@Controller
@Transactional
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
	
	@RequestMapping(value="/produtos", method = RequestMethod.POST) 
	public void save (@ModelAttribute(value = "product") Product product) {
		productDAO.save(product);
		list();
		//return "products/ok";
	}
	
	@RequestMapping(value="/produtos", method = RequestMethod.GET)
	public ModelAndView list () {
		
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", productDAO.list());
		return modelAndView;
	}
}
