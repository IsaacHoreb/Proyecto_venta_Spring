package com.pracitica.services;

import com.pracitica.entity.CarroEntity;

public interface CarroServices {

    public CarroEntity guardarCarro(CarroEntity carro) throws Exception;

    public CarroEntity obtenerCarroId(Long id) throws Exception;

    public void eliminarCarroId(Long id) throws Exception;


}
