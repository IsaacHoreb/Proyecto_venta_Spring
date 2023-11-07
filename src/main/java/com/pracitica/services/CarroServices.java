package com.pracitica.services;

import com.pracitica.entity.CarroEntity;

import java.util.List;

public interface CarroServices {

    public CarroEntity guardarCarro(CarroEntity carro) throws Exception;

    public CarroEntity obtenerCarroId(Long id) throws Exception;

    public String eliminarCarroId(Long id) throws Exception;

    public CarroEntity actualizarCarroId(Long id, CarroEntity detallesNew) throws Exception;

    public List<CarroEntity> listarTodoCar() throws Exception;

}
