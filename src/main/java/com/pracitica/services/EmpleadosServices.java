package com.pracitica.services;

import com.pracitica.entity.EmpleadosEntity;

public interface EmpleadosServices {

    public EmpleadosEntity guardarEmpleados(EmpleadosEntity empleados) throws Exception;

    public EmpleadosEntity obtenerEmpleadosId(Long id) throws Exception;

    public void eliminarEmpleadoId(Long id) throws Exception;

    public EmpleadosEntity obtenerTodosEmpleados() throws Exception;


}
