package com.codigo.Leodan_Condori.service.impl;

import com.codigo.Leodan_Condori.dao.EditorDAO;
import com.codigo.Leodan_Condori.entity.CategoriaEntity;
import com.codigo.Leodan_Condori.entity.EditorEntity;
import com.codigo.Leodan_Condori.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EditorServiceImpl implements EditorService {
    @Autowired
    private EditorDAO editorDAO;

    @Override
    public EditorEntity crearEditor(EditorEntity editor) {
        return editorDAO.save(editor);
    }

    @Override
    public EditorEntity obtenerEditorPorId(Long id) throws Exception {
        Optional<EditorEntity> editor = editorDAO.findById(id);
        if(editor.isPresent()){
            return editor.get();
        } else {
            throw new Exception("Error, No existe ese editor");
        }
    }

    @Override
    public EditorEntity actualizarEditor(Long id, EditorEntity editorActualizado) throws Exception{
        Optional<EditorEntity> optionalEditor = editorDAO.findById(id);

        if (optionalEditor.isPresent()) {
            EditorEntity editorExistente = optionalEditor.get();
            editorExistente.setNombre(editorActualizado.getNombre());
            editorExistente.setEstado(editorActualizado.getEstado());

            return editorDAO.save(editorExistente);
        } else {
            throw new Exception("Error, No existe ese editor, atualizacion imposible");
        }
    }

    @Override
    public String eliminarEditor(Long id) throws Exception {
        Optional<EditorEntity> editorEncontrado = editorDAO.findById(id);
        return editorEncontrado.map(editor -> {
            editor.setEstado(0);
            editorDAO.save(editor);
            return "Eliminado";
        }).orElseThrow(() -> new Exception("No se pudo eliminar"));
    }

    @Override
    public List<EditorEntity> obtenerTodos() {
        return editorDAO.findAll();
    }
}
