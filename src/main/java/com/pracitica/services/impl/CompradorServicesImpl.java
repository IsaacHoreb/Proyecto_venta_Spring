package com.pracitica.services.impl;

import com.pracitica.entity.CompradorEntity;
import com.pracitica.services.CompradorServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorServicesImpl implements CompradorServices {

    @Override
    public CompradorEntity guardarComprador(CompradorEntity comprador) throws Exception {
        return null;
    }

    @Override
    public CompradorEntity obtenerCompradorId(Long id) throws Exception {
        return null;
    }

    @Override
    public void eliminarCompradorId(Long id) throws Exception {

    }

    @Override
    public List<CompradorEntity> listarCompradores() throws Exception {
        return null;
    }
}
