package com.escuelait.gestionsensores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escuelait.gestionsensores.models.Transductor;

@Repository
public interface TransductorsRepository extends JpaRepository<Transductor, String>{

}
