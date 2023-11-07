package com.pracitica.services;

import com.pracitica.entity.EmpleadosEntity;

import java.util.List;

public interface EmpleadosServices {

    public EmpleadosEntity guardarEmpleados(EmpleadosEntity empleados) throws Exception;

    public EmpleadosEntity obtenerEmpleadosId(Long id) throws Exception;

    public String eliminarEmpleadoId(Long id) throws Exception;

    public List<EmpleadosEntity> obtenerTodosEmpleados() throws Exception;

    public EmpleadosEntity actualizarEmpleadoId(Long id, EmpleadosEntity detallesNew) throws Exception;

}
