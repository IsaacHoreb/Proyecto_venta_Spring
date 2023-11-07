package com.pracitica.services.impl;

import com.pracitica.entity.EPuesto;
import com.pracitica.entity.EmpleadosEntity;
import com.pracitica.repository.EmpleadoRepository;
import com.pracitica.services.EmpleadosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmpleadosServicesImpl implements EmpleadosServices {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public EmpleadosEntity guardarEmpleados(EmpleadosEntity empleados) throws Exception {

        //Verificamos
        EmpleadosEntity empleadoLocal = empleadoRepository.findByName(empleados.getName())
                .orElse(null);

        //Condicion
        EmpleadosEntity empleadoNuevo;
        if (empleadoLocal != null) {
            throw new Exception("Este empleado ya existe\nIngrese otro registro nuevo...");
        } else {
            empleadoNuevo = empleadoRepository.save(empleados); //Guardamos el empleado nuevo
        }

        return empleadoNuevo; //Regresa el valor
    }

    @Override
    public EmpleadosEntity obtenerEmpleadosId(Long id) throws Exception {
        //Verificamos
        EmpleadosEntity empleadoLocal = empleadoRepository.findById(id)
                .orElse(null);

        //Condicion
        EmpleadosEntity empleadoNuevo;
        if (empleadoLocal != null) {
            return empleadoLocal;
        } else {
            throw new Exception("Este empleado no con id: " + id + " no existe\nIngrese otro registro nuevo...");
        }

    }

    @Override
    public String eliminarEmpleadoId(Long id) throws Exception {
        //Verificamos
        EmpleadosEntity empleadoLocal = empleadoRepository.findById(id)
                .orElse(null);

        //Condicion
        EmpleadosEntity empleadoNuevo;
        if (empleadoLocal != null) {
            empleadoRepository.deleteById(id);
            return "El empleado ha sido eliminado\nID: " + id;
        } else {
            throw new Exception("Este empleado no existe\nIngrese otro registro...");
        }

    }

    @Override
    public List<EmpleadosEntity> obtenerTodosEmpleados() throws Exception {

        List<EmpleadosEntity> empleados = empleadoRepository.findAll();

        if (empleados.isEmpty()) {
            throw new Exception("No existe ningún empleado\nIngrese valores...");
        } else {
            return empleados;
        }

    }

    @Override
    public EmpleadosEntity actualizarEmpleadoId(Long id, EmpleadosEntity detallesNew) throws Exception {

        //Verificamos
        EmpleadosEntity empleadoLocal = empleadoRepository.findById(id)
                .orElse(null);

        EmpleadosEntity empleadoUpdate = null; //Almacenamos los nuevos detalles

        //Condicion
        if (empleadoLocal != null) {

            empleadoLocal.setName(detallesNew.getName());
            empleadoLocal.setLastName(detallesNew.getLastName());
            empleadoLocal.setPhone(detallesNew.getPhone());
            empleadoLocal.setEmail(detallesNew.getEmail());
            empleadoLocal.setPuesto(detallesNew.getPuesto());

            empleadoUpdate = empleadoRepository.save(empleadoLocal);
        }

        return empleadoUpdate;

    }

}
