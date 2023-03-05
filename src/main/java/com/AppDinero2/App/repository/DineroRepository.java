package com.AppDinero2.App.repository;

import com.AppDinero2.App.entity.Dinero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DineroRepository extends JpaRepository <Dinero,Long> {


}
