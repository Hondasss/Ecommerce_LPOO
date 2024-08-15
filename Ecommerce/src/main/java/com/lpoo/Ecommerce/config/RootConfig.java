package com.lpoo.Ecommerce.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lpoo.Ecommerce.entities.Cliente;
import com.lpoo.Ecommerce.entities.Endereco;
import com.lpoo.Ecommerce.repositories.ClienteRepository;

@Configuration
public class RootConfig implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente("Guilherme", "000222200022", "email@gmail.com", new Endereco(null, "log", "num", "bairro", "cid", "est", "cep"));
		Cliente c2 = new Cliente("Robson", "11111200022", "email2@gmail.com", new Endereco(null, "losg", "nums", "bairros", "cids", "ests", "ceps"));
		
		clienteRepository.saveAll(Arrays.asList(c1, c2));
	}
	
	
}
