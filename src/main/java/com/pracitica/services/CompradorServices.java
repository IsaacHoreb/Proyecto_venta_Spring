package com.pracitica.services;

import com.pracitica.entity.CompradorEntity;

import java.util.List;

public interface CompradorServices {

    public CompradorEntity guardarComprador(CompradorEntity comprador) throws Exception;

    public CompradorEntity obtenerCompradorId(Long id) throws Exception;

    public void eliminarCompradorId(Long id) throws Exception;

    public List<CompradorEntity> listarCompradores() throws Exception;

}
