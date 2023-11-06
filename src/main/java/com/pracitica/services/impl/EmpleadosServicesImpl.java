package com.pracitica.services.impl;

import com.pracitica.entity.EmpleadosEntity;
import com.pracitica.services.EmpleadosServices;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosServicesImpl implements EmpleadosServices {

    @Override
    public EmpleadosEntity guardarEmpleados(EmpleadosEntity empleados) throws Exception {
        return null;
    }

    @Override
    public EmpleadosEntity obtenerEmpleadosId(Long id) throws Exception {
        return null;
    }

    @Override
    public void eliminarEmpleadoId(Long id) throws Exception {

    }

    @Override
    public EmpleadosEntity obtenerTodosEmpleados() throws Exception {
        return null;
    }
}
