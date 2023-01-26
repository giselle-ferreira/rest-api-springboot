package com.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.apirest.model.Cliente;
import com.apirest.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	public List<Cliente> listAll() {
		return clienteRepo.findAll();
	}
	
	public Optional<Cliente> listOneClient(@PathVariable Long id) {
		return clienteRepo.findById(id);
	}
	
	public Cliente createClient(@RequestBody Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public Cliente updateClient(@RequestBody Cliente cliente) {
		Cliente novoCliente = clienteRepo.save(cliente);
		return novoCliente;
	}
	
	public void deleteClient(@PathVariable Long id) {
		clienteRepo.deleteById(id);
	}
	
	public void deleteAllClients() {
		clienteRepo.deleteAll();
	}	
	
}
