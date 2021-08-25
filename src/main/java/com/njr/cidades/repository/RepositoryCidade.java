package com.njr.cidades.repository;

import com.njr.cidades.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface RepositoryCidade extends  JpaRepository<Cidade, Long>{
    @Query(value = "SELECT * from cidade where nome ILIKE '(?1)'", nativeQuery = true)
    List<Cidade> cidadesPorNomeDB(final String cidade);
}
