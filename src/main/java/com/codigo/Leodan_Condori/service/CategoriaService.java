package com.codigo.Leodan_Condori.service;

import com.codigo.Leodan_Condori.entity.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    CategoriaEntity crearCategoria(CategoriaEntity categoria);
    CategoriaEntity obtenerCategoriaPorId(Long id) throws Exception;
    CategoriaEntity actualizarCategoria(Long id, CategoriaEntity categoriaActualizado) throws Exception;
    String eliminarCategoria(Long id) throws Exception;
    List<CategoriaEntity> obtenerTodos();
}
