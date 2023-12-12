package com.codigo.Leodan_Condori.service.impl;

import com.codigo.Leodan_Condori.dao.AutorDAO;
import com.codigo.Leodan_Condori.entity.AutorEntity;
import com.codigo.Leodan_Condori.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorDAO autorDAO;
    @Override
    public AutorEntity crearAutor(AutorEntity autor) {
        return autorDAO.save(autor);
    }
    @Override
    public AutorEntity obtenerAutorPorId(Long id) throws Exception {
        Optional<AutorEntity> autor = autorDAO.findById(id);
        if(autor.isPresent()){
            return autor.get();
        } else {
            throw new Exception("Error, No existe el autor: " + id);
        }
    }

    @Override
    public AutorEntity actualizarAutor(Long id, AutorEntity autorActualizado) throws Exception{
        Optional<AutorEntity> optionalAutor = autorDAO.findById(id);

        if (optionalAutor.isPresent()) {
            AutorEntity autorExistente = optionalAutor.get();
            autorExistente.setNombre(autorActualizado.getNombre());
            autorExistente.setEstado(autorActualizado.getEstado());

            return autorDAO.save(autorExistente);
        } else {
            throw new Exception("Error, Actualizacion imposible,No existe el autor " + id);
        }
    }
    @Override
    public String eliminarAutor(Long id) throws Exception{

        Optional<AutorEntity> autorEncontrado = autorDAO.findById(id);
        //return autorEncontrado.map(autor -> {
        //    autor.setEstado(0);
        //    autorDAO.save(autor);
        //    return "Eliminado";
        //}).orElseThrow(() -> new Exception("No se pudo eliminar"));
        if(autorEncontrado.isPresent()){
            AutorEntity autorUpdate = autorEncontrado.get();
            autorUpdate.setEstado(0);
            autorDAO.save(autorUpdate);
            return "Eliminado";
        } else {
            throw new Exception("No se pudo eliminar");
        }
    }
    @Override
    public List<AutorEntity> obtenerTodos() {
        return autorDAO.findAll();
    }
}
