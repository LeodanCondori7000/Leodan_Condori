package com.codigo.Leodan_Condori.service;

import com.codigo.Leodan_Condori.entity.AutorEntity;

import java.util.List;

public interface AutorService {
    List<AutorEntity> obtenerTodos();
    AutorEntity obtenerAutorPorId(Long id) throws Exception;
    AutorEntity crearAutor(AutorEntity autor);
    AutorEntity actualizarAutor(Long id, AutorEntity autorActualizado) throws Exception;
    //void eliminarAutor(Long id);
    String eliminarAutor(Long id) throws Exception;
}
