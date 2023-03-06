package com.AppDinero2.App.repository;

import com.AppDinero2.App.entity.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresosRepository extends JpaRepository<Ingreso,Integer> {
}
