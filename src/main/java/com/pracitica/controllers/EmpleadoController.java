package com.pracitica.controllers;

import com.pracitica.entity.EmpleadosEntity;
import com.pracitica.services.EmpleadosServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/worker")
public class EmpleadoController {

    @Autowired
    private EmpleadosServices empleadosServices;

    @PostMapping("/save")
    public EmpleadosEntity saveWorker(@Valid @RequestBody EmpleadosEntity empleados) throws Exception {
        return empleadosServices.guardarEmpleados(empleados);
    }

    @GetMapping("/info/{id}")
    public EmpleadosEntity workerInfoId(@PathVariable("id") Long id) throws Exception {
        return empleadosServices.obtenerEmpleadosId(id);
    }

    @GetMapping("/listAll")
    public List<EmpleadosEntity> listAllWorker() throws Exception {
        return empleadosServices.obtenerTodosEmpleados();
    }

    @PutMapping("/update/{id}")
    public EmpleadosEntity deleteWorkerId(@PathVariable("id") Long id, @Valid @RequestBody EmpleadosEntity detallesNew) throws Exception {
        return empleadosServices.actualizarEmpleadoId(id, detallesNew);
    }

}
