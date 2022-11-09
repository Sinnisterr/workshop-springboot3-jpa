package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service                                 //@Component registra sua classe como componente do spring e vai poder ser injetado com autowired
public class ProductService { // buscar todos usuarios e operacao buscar usuario por id para fazer isso o userservice
							// tem que ter uma depencia para userrepository.

	
	@Autowired				// fazer a injecao de dependencia de forma transparente
	private ProductRepository repository;
	
	public List<Product> findAll()	{						// criar um metodo para retornar todos os usuarios do banco de dados
		return repository.findAll(); 
												// para classe funcionar ela tem que estar registrada no userService
	}	
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
				
	}
}
