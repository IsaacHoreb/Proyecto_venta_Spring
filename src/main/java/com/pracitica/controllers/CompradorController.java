package com.pracitica.controllers;

import com.pracitica.entity.CompradorEntity;
import com.pracitica.services.CompradorServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/shopping")
public class CompradorController {

    @Autowired
    private CompradorServices compradorServices;

    @PostMapping("/save")
    public CompradorEntity saveShooper(@Valid @RequestBody CompradorEntity comprador) throws Exception {
        return compradorServices.guardarComprador(comprador);
    }

    @GetMapping("/Info/{id}")
    public CompradorEntity getShopperId(@PathVariable("id") Long id) throws Exception {
        return compradorServices.obtenerCompradorId(id);
    }

    @GetMapping("/all")
    public List<CompradorEntity> litAllShopper() throws Exception {
        return compradorServices.listarCompradores();
    }

    @PutMapping("/update/{id}")
    public CompradorEntity updateShooper(@PathVariable("id") Long id, @Valid @RequestBody CompradorEntity detallesNew) throws Exception {
        return compradorServices.actualizarComprador(id, detallesNew);
    }

    @DeleteMapping("/delete")
    public String deleteShooper(@PathVariable("id") Long id) throws Exception {
        return compradorServices.eliminarCompradorId(id);
    }


}
