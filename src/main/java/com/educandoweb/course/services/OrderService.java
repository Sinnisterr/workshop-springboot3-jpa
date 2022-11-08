package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service                                 //@Component registra sua classe como componente do spring e vai poder ser injetado com autowired
public class OrderService { // buscar todos usuarios e operacao buscar usuario por id para fazer isso o Orderservice
							// tem que ter uma depencia para Orderrepository.

	
	@Autowired				// fazer a injecao de dependencia de forma transparente
	private OrderRepository repository;
	
	public List<Order> findAll()	{						// criar um metodo para retornar todos os usuarios do banco de dados
		return repository.findAll(); 
												// para classe funcionar ela tem que estar registrada no OrderService
	}	
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
				
	}
}
