package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;  // criada dependencia para o service.
	
	
	@GetMapping								// Responde a requisicao get do http tem que colocar essa anotacao
	public ResponseEntity<List<Category>> findAll() {   // metodo endpoint para acessar os usuarios teste
		List<Category> list = service.findAll();	
		return ResponseEntity.ok().body(list);	// retornar uma resposta ok no htttp e o body corpo da resposta
	}	
		
	@GetMapping(value = "/{id}")											// Criar endpoint para buscar os usuarios por ID
	public ResponseEntity<Category> findById(@PathVariable Long id) {			// Para aceitar dentro do endpoint, para aceitar esse id e considerar como parametro que vai chegar na url 
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}
