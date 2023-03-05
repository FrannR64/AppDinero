package com.AppDinero2.App.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gasto",nullable = false)
    private int gasto;

    @Column(name = "descripcion", nullable = false,length = 50)
    private String descripcion;

    public Gasto(Integer id) {
        this.id = id;
    }
}
