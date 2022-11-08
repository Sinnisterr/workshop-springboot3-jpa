package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service                                 //@Component registra sua classe como componente do spring e vai poder ser injetado com autowired
public class CategoryService { // buscar todos usuarios e operacao buscar usuario por id para fazer isso o Categoryservice
							// tem que ter uma depencia para Categoryrepository.

	
	@Autowired				// fazer a injecao de dependencia de forma transparente
	private CategoryRepository repository;
	
	public List<Category> findAll()	{						// criar um metodo para retornar todos os usuarios do banco de dados
		return repository.findAll(); 
												// para classe funcionar ela tem que estar registrada no CategoryService
	}	
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
				
	}
}
