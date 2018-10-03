package br.com.yansi.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.yansi.models.Product;

@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Product product) {
		manager.persist(product);
	}
}
