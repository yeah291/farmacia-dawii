/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cibertec.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author CESAR
 */

@Entity
@Data
@Table(name="tb_producto")
public class Producto implements Serializable{
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private int idProducto;

    private String descripcion;

    private double precio;
    
    private int stock;
    
    @ManyToOne
    @JoinColumn(name="idCategoria", insertable=false, updatable= false)
    private Categoria categoria;
    
    @Column(name = "idCategoria")
    private int idCategoria;

    @Column(name = "idFoto")
    private String idFoto;

    @Column(name = "urlFoto")
    private String urlFoto;

}
