package com.AppDinero2.App.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dinero")
public class Dinero {

    @Id
    private Long id;

    @Column(name = "saldo")
    private int saldo;
}
