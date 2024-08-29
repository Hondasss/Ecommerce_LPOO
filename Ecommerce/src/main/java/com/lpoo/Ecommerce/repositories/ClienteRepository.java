package com.lpoo.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpoo.Ecommerce.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
