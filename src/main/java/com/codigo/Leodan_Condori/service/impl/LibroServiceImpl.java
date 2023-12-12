package com.codigo.Leodan_Condori.service.impl;

import com.codigo.Leodan_Condori.dao.LibroDAO;
import com.codigo.Leodan_Condori.entity.EditorEntity;
import com.codigo.Leodan_Condori.entity.LibroEntity;
import com.codigo.Leodan_Condori.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroDAO libroDAO;

    @Override
    public LibroEntity crearLibro(LibroEntity libro) {
        return libroDAO.save(libro);
    }

    @Override
    public LibroEntity obtenerLibroPorId(Long id) throws Exception {
        Optional<LibroEntity> libro = libroDAO.findById(id);
        if(libro.isPresent()){
            return libro.get();
        } else {
            throw new Exception("Error, No existe ese libro");
        }
    }
    @Override
    public LibroEntity actualizarLibro(Long id, LibroEntity libroActualizado) throws Exception{
         Optional<LibroEntity> optionalLibro = libroDAO.findById(id);

        if (optionalLibro.isPresent()) {
            LibroEntity libroExistente = optionalLibro.get();
            libroExistente.setTitulo(libroActualizado.getTitulo());
            libroExistente.setEditor(libroActualizado.getEditor());
            libroExistente.setEstado(libroActualizado.getEstado());

            return libroDAO.save(libroExistente);
        } else {
            throw new Exception("Error, No existe ese libro, atualizacion imposible");
        }
    }
    @Override
    public String eliminarLibro(Long id) throws Exception {
        Optional<LibroEntity> libroEncontrado = libroDAO.findById(id);
        return libroEncontrado.map(libro -> {
            libro.setEstado(0);
            return "Eliminado";
        }).orElseThrow(() -> new Exception("No se pudo eliminar"));
    }

    @Override
    public List<LibroEntity> obtenerTodos() {
        return libroDAO.findAll();
    }
}
