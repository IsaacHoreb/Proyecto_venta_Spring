package com.pracitica.services.impl;

import com.pracitica.entity.CarroEntity;
import com.pracitica.repository.CarroRepository;
import com.pracitica.services.CarroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        CarroEntity carroLocal = carroRepository.findById(id)
                .orElse(null);

        if (carroLocal != null) {
            return carroLocal;
        } else {
            throw new Exception("Este carro con id: " + id + "no existe\nIngrese otro");
        }

    }

    @Override
    public String eliminarCarroId(Long id) throws Exception {
        CarroEntity carroLocal = carroRepository.findById(id)
                .orElse(null);

        if (carroLocal != null) {
            carroRepository.deleteById(id);
            return "El carro ha sido eliminado\nID: " + id;
        } else {
            throw new Exception("Este carro con id: " + id + "no existe\nIngreso otro");
        }
    }

    @Override
    public CarroEntity actualizarCarroId(Long id, CarroEntity detallesNew) throws Exception {

        CarroEntity carroLocal = carroRepository.findById(id)
                .orElse(null);

        CarroEntity carUpdate; //Guardar los cambios para retornarlos

        //Verificamos
        if (carroLocal != null) {

            //Anadimos los nuevos valores para update
            carroLocal.setMarca(detallesNew.getMarca());
            carroLocal.setModelo(detallesNew.getModelo());
            carroLocal.setColor(detallesNew.getColor());
            carroLocal.setPlacas(detallesNew.getPlacas());
            carroLocal.setFechaIngreso(detallesNew.getFechaIngreso());
            carroLocal.setFechaCompra(detallesNew.getFechaCompra());
            carroLocal.setPrecio(detallesNew.getPrecio());
            carroLocal.setStatus(detallesNew.getStatus());

            carUpdate = carroRepository.save(carroLocal); //Guarda los cambios

        } else {
            throw new Exception("Este carro con id: " + id + "no existe\nIngrese otro");
        }

        return carUpdate;
    }

    @Override
    public List<CarroEntity> listarTodoCar() throws Exception {
        List<CarroEntity> carros = carroRepository.findAll();

        if (carros.isEmpty()) {
            throw new Exception("No existe ningún carro\nIngrese valores...");
        } else {
            return carros;
        }

    }

}
