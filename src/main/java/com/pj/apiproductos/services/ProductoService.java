package com.pj.apiproductos.services;


import com.pj.apiproductos.config.JwtUtil;
import com.pj.apiproductos.model.Producto;
import com.pj.apiproductos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository ) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto modificarProducto(Long id, Producto producto) {
        Producto existente = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        existente.setDescripcion(producto.getDescripcion());
        existente.setImagenUrl(producto.getImagenUrl());
        existente.setPrecio(producto.getPrecio());


        return productoRepository.save(existente);
    }

    public boolean eliminarProducto(Long id) {

        try {
            Producto existente = productoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            productoRepository.delete(existente);
            return true;
        }catch (Exception e) {
            return false;
        }


    }
}

