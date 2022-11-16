/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cibertec.demo.service;

import com.cibertec.demo.entity.Categoria;
import com.cibertec.demo.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CESAR
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaRepository CategoriaRepository;

    @Override
    public List<Categoria> listarCategorias() {
        return  (List<Categoria>) CategoriaRepository.findAll();
    }
    
}
