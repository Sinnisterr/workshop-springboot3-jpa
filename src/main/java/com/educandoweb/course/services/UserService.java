package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
				
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);	
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try { 
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
		

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
