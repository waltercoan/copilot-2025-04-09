package br.com.kasolution.springcopilot.repository;

import br.com.kasolution.springcopilot.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}