package com.pracitica.controllers;

import com.pracitica.entity.CarroEntity;
import com.pracitica.services.CarroServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarroControlador {

    @Autowired
    private CarroServices carroServices;

    @PostMapping("/saveCar")
    public CarroEntity saveCar(@Valid @RequestBody CarroEntity carro) throws Exception {
        return carroServices.guardarCarro(carro);
    }

    @GetMapping("/carInfo/{id}")
    public CarroEntity getCarId(@PathVariable("id") Long id) throws Exception {
        return carroServices.obtenerCarroId(id);
    }

    @DeleteMapping("/deleteCar/{id}")
    public String deleteCarId(@PathVariable("id") Long id) throws Exception {
        return carroServices.eliminarCarroId(id);
    }

    @PutMapping("/updateCar/{id}")
    public CarroEntity updateCarId(@PathVariable("id") Long id, @Valid @RequestBody CarroEntity cardetalles) throws Exception {
        return carroServices.actualizarCarroId(id, cardetalles);
    }

    @GetMapping("/listAllCar")
    public List<CarroEntity> listarCarro() throws Exception {
        return carroServices.listarTodoCar();
    }

}
