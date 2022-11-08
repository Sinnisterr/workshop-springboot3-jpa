package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service                                 //@Component registra sua classe como componente do spring e vai poder ser injetado com autowired
public class UserService { // buscar todos usuarios e operacao buscar usuario por id para fazer isso o userservice
							// tem que ter uma depencia para userrepository.

	
	@Autowired				// fazer a injecao de dependencia de forma transparente
	private UserRepository repository;
	
	public List<User> findAll()	{						// criar um metodo para retornar todos os usuarios do banco de dados
		return repository.findAll(); 
												// para classe funcionar ela tem que estar registrada no userService
	}	
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
				
	}
}