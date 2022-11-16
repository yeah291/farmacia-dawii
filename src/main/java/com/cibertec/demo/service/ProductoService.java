/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cibertec.demo.service;

import com.cibertec.demo.entity.Producto;
import java.util.List;

/**
 *
 * @author CESAR
 */
public interface ProductoService {
    public List<Producto> listarProductos();

    public void guardar (Producto producto);

    public void eliminar (int idproducto);

    public Producto encontrarProductoPorId(int idProducto);
}