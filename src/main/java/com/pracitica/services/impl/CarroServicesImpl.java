package com.pracitica.services.impl;

import com.pracitica.entity.CarroEntity;
import com.pracitica.repository.CarroRepository;
import com.pracitica.services.CarroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroServicesImpl implements CarroServices {

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public CarroEntity guardarCarro(CarroEntity carro) throws Exception {

        //Buscamos el carro por precaucion
        CarroEntity carroLocal = carroRepository.findByMarca(carro.getMarca())
                .orElse(null);

        //Verificamos
        if (carroLocal != null) {
            throw new Exception("El carro ya esta presente\nIngreso otro por favor...");
        } else {
            carroRepository.save(carro);
        }

        return carroLocal;

    }

    @Override
    public CarroEntity obtenerCarroId(Long id) throws Exception {
        return null;
    }

    @Override
    public void eliminarCarroId(Long id) throws Exception {

    }
}
