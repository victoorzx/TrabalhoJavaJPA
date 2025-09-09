package com.victor.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

// Pessoa - Entidade
// Long - Tipo de Dados do ID
//JpaRepository<Pessoa, Long>
// Repository - DAO
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
