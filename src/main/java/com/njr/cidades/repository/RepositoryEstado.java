package com.njr.cidades.repository;

import com.njr.cidades.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEstado extends JpaRepository<Estado, Long> {
}
