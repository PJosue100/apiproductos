package com.pj.apiproductos.repository;


import com.pj.apiproductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findById(Long id);



}

