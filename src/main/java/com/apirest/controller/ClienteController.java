package com.apirest.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.model.Cliente;
import com.apirest.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {	
	
	@Autowired
	private ClienteService service;

	@GetMapping
	public List<Cliente> list() {
		return service.listAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Optional<Cliente> listOneClient(@PathVariable Long id) {
		return service.listOneClient(id);
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return service.createClient(cliente);
	}
	
	@PutMapping("/update")
	public Cliente update(@RequestBody Cliente cliente) {
		Cliente novoCliente = service.updateClient(cliente);
		return novoCliente;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		service.deleteClient(id);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		service.deleteAllClients();
	}	
	
}
