/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cibertec.demo.controller;

import com.cibertec.demo.entity.Producto;
import com.cibertec.demo.service.CategoriaService;
import com.cibertec.demo.service.CloudinaryService;
import com.cibertec.demo.service.ProductoService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author CESAR
 */
@Controller
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CloudinaryService cloudinaryService;


    @GetMapping("/")
    public String inicio(Model model) {
        var productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "index";
    }


    @GetMapping("/agregar")
    public String agregar(Producto producto,Model model){
        model.addAttribute("metodo","Agregar");
        model.addAttribute("lstCategorias", categoriaService.listarCategorias());
        return "modificar";
    }


    @PostMapping("/guardar")
    public String guardar(Producto producto,@RequestParam("file") MultipartFile imagen,
                          @RequestParam("metodo") String metodo){
        try {
            if(!imagen.isEmpty()){
                if(metodo.equals("Editar")){
                    cloudinaryService.delete(producto.getIdFoto());
                }
                Map result = cloudinaryService.upload(imagen);
                producto.setIdFoto((String) result.get("public_id"));
                producto.setUrlFoto((String) result.get("url"));
                productoService.guardar(producto);

                return "redirect:/";
            }
            if(imagen.isEmpty() && metodo.equals("Editar")){
                Producto producto2 = productoService.encontrarProductoPorId(producto.getIdProducto());
                producto.setIdFoto(producto2.getIdFoto());
                producto.setUrlFoto(producto2.getUrlFoto());
                productoService.guardar(producto);
                return "redirect:/";
            }

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return "guardar";
    }


    @GetMapping("/editar/{idProducto}")
    public String editar(Producto producto, Model model ){
        producto = productoService.encontrarProductoPorId(producto.getIdProducto());
        model.addAttribute("metodo", "Editar");
        model.addAttribute("producto", producto);
        model.addAttribute("lstCategorias", categoriaService.listarCategorias());
        return "modificar";
    }


    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto){
        try {
            String idfoto = productoService.encontrarProductoPorId(producto.getIdProducto()).getIdFoto();
            System.out.println(idfoto);
            cloudinaryService.delete(idfoto);
            productoService.eliminar(producto.getIdProducto());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
    
    
}
