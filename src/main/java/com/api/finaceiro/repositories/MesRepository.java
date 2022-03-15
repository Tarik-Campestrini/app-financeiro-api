package com.api.finaceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.finaceiro.domain.Mes;

@Repository
public interface MesRepository extends JpaRepository<Mes, Integer> {

}
