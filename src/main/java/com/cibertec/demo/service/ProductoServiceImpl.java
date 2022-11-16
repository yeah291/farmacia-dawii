/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cibertec.demo.service;

import com.cibertec.demo.entity.Producto;
import com.cibertec.demo.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CESAR
 */
@Service
public class ProductoServiceImpl implements ProductoService{


    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminar(int idproducto) {
        productoRepository.deleteById(idproducto);
    }


    @Override
    public Producto encontrarProductoPorId(int idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }
}