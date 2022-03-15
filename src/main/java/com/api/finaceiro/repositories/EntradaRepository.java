package com.api.finaceiro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.finaceiro.domain.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
	@Query("Select obj From Entrada obj Where obj.usuario.id = :id_usu Order BY data")
	List<Entrada> findAllByUsuario(@Param(value = "id_usu")  Integer id_usu);

}
