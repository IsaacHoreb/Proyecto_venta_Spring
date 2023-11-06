package com.pracitica.controllers;

import com.pracitica.entity.CarroEntity;
import com.pracitica.services.CarroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/car")
public class CarroControlador {

    @Autowired
    private CarroServices carroServices;

    @PostMapping("/saveCar")
    public CarroEntity guardar(@RequestBody CarroEntity carro) throws Exception {
        return carroServices.guardarCarro(carro);
    }


}
