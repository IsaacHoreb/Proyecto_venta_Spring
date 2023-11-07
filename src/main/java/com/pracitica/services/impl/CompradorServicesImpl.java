package com.pracitica.services.impl;

import com.pracitica.entity.CompradorEntity;
import com.pracitica.repository.CompradorRepository;
import com.pracitica.services.CompradorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorServicesImpl implements CompradorServices {

    @Autowired
    private CompradorRepository compradorRepository;

    @Override
    public CompradorEntity guardarComprador(CompradorEntity comprador) throws Exception {
        //Buscamos por precaucion el nombre del comprador
        CompradorEntity compradorLocal = compradorRepository.findByName(comprador.getName())
                .orElse(null);

        //Condincion
        CompradorEntity compradorNuevo;
        if (compradorLocal != null) {
            throw new Exception("Este comprador ya existe\nIngreso un nuevo registro...");
        } else {
            compradorNuevo = compradorRepository.save(comprador);
        }

        return compradorNuevo;
    }

    @Override
    public CompradorEntity obtenerCompradorId(Long id) throws Exception {
        //Buscamos por precaucion el nombre del comprador
        CompradorEntity compradorLocal = compradorRepository.findById(id)
                .orElse(null);

        //Condicion
        CompradorEntity compradorNuevo;
        if (compradorLocal != null) {
            return compradorLocal;
        } else {
            throw new Exception("Este comprador con id:" + id + "  no existe\nIngreso un nuevo registro...");
        }

    }

    @Override
    public String eliminarCompradorId(Long id) throws Exception {
        //Buscamos por precaucion el nombre del comprador
        CompradorEntity compradorLocal = compradorRepository.findById(id)
                .orElse(null);

        //Condicion
        CompradorEntity compradorNuevo;
        if (compradorLocal != null) {
            compradorRepository.deleteById(id);
            return "El comprador ha sido eliminado\nID: " + id;
        } else {
            throw new Exception("Este comprador con id:" + id + "  no existe\nIngreso otro registro...");
        }
    }

    @Override
    public CompradorEntity actualizarComprador(Long id, CompradorEntity detallesNew) throws Exception {

        //Buscamos por precaucion el nombre del comprador
        CompradorEntity compradorLocal = compradorRepository.findById(id)
                .orElse(null);

        //Condicion
        CompradorEntity compradorUpdate;
        if (compradorLocal != null) {

            //Ingreso los nuevos valores
            compradorLocal.setName(detallesNew.getName());
            compradorLocal.setLastName(detallesNew.getLastName());
            compradorLocal.setAge(detallesNew.getAge());
            compradorLocal.setPhone(detallesNew.getPhone());

            compradorUpdate = compradorRepository.save(compradorLocal);

        } else {
            throw new Exception("Este comprador con id: " + id + "no existe\nIngrese otro...");
        }
        return compradorUpdate;
    }

    @Override
    public List<CompradorEntity> listarCompradores() throws Exception {
        List<CompradorEntity> comprador = compradorRepository.findAll();

        if (comprador.isEmpty()) {
            throw new Exception("No existe ningún comprador\nIngrese valores...");
        } else {
            return comprador;
        }

    }

}
