package com.codigo.Leodan_Condori.service.impl;

import com.codigo.Leodan_Condori.dao.CategoriaDAO;
import com.codigo.Leodan_Condori.entity.AutorEntity;
import com.codigo.Leodan_Condori.entity.CategoriaEntity;
import com.codigo.Leodan_Condori.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaDAO categoriaDAO;
    @Override
    public CategoriaEntity crearCategoria(CategoriaEntity categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public CategoriaEntity obtenerCategoriaPorId(Long id) throws Exception {
        Optional<CategoriaEntity> categoria = categoriaDAO.findById(id);
        if(categoria.isPresent()){
            return categoria.get();
        } else {
            throw new Exception("Error, No existe esa categoria " + id);
        }
    }

    @Override
    public CategoriaEntity actualizarCategoria(Long id, CategoriaEntity categoriaActualizado) throws Exception{
        Optional<CategoriaEntity> optionalCategoria = categoriaDAO.findById(id);

        if (optionalCategoria.isPresent()) {
            CategoriaEntity categoriaExistente = optionalCategoria.get();
            categoriaExistente.setNombre(categoriaActualizado.getNombre());
            categoriaExistente.setEstado(categoriaActualizado.getEstado());

            return categoriaDAO.save(categoriaExistente);
        } else {
            throw new Exception("Error, Actualizacion imposible, No existe esa categoria " + id);
        }
    }
    @Override
    public String eliminarCategoria(Long id) throws Exception {
        Optional<CategoriaEntity> categoriaEncontrado = categoriaDAO.findById(id);
        if(categoriaEncontrado.isPresent()){
            CategoriaEntity categoriaUpdate = categoriaEncontrado.get();
            categoriaUpdate.setEstado(0);
            categoriaDAO.save(categoriaUpdate);
            return "Eliminado";
        } else {
            throw new Exception("No se pudo eliminar");
        }
        //return categoriaEncontrado.map(categoria -> {
        //    categoria.setEstado(0);
        //    categoriaDAO.save(categoria);
        //    return "Eliminado";
        //}).orElseThrow(() -> new Exception("No se pudo eliminar"));
    }

    @Override
    public List<CategoriaEntity> obtenerTodos() {
        return categoriaDAO.findAll();
    }
}
