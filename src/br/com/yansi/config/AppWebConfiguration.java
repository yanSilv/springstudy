package br.com.yansi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.yansi.controller.HomeController;
import br.com.yansi.controller.ProductsController;
import br.com.yansi.daos.ProductDAO;

@EnableWebMvc
@ComponentScan(
		basePackageClasses = { 
				HomeController.class,
				ProductsController.class,
				ProductDAO.class
		})
public class AppWebConfiguration {
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
