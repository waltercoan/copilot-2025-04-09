package br.com.kasolution.springcopilot.repository;

import br.com.kasolution.springcopilot.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}