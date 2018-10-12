package br.com.yansi.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.yansi.daos.ProductDAO;
import br.com.yansi.enums.BookType;
import br.com.yansi.models.Product;
import br.com.yansi.validation.ProductValidator;

@Controller
@Transactional
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;
	
	@InitBinder
	protected void initBinder (WebDataBinder binder) {
		binder.setValidator(new ProductValidator());
	}
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
	
	@RequestMapping( value="/produtos", method = RequestMethod.POST) 
	public ModelAndView save (@Valid @ModelAttribute(value = "product") Product product,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			return form();
		}
		
		productDAO.save(product);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping( value="/produtos", method = RequestMethod.GET)
	public ModelAndView list () {
		
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", productDAO.list());
		return modelAndView;
	}
}
