package com.codigo.Leodan_Condori.service;

import com.codigo.Leodan_Condori.entity.LibroEntity;

import java.util.List;

public interface LibroService {
    LibroEntity crearLibro(LibroEntity libro);
    LibroEntity obtenerLibroPorId(Long id) throws Exception;
    LibroEntity actualizarLibro(Long id, LibroEntity libroActualizado) throws Exception;
    String eliminarLibro(Long id) throws Exception;
    List<LibroEntity> obtenerTodos();
}
