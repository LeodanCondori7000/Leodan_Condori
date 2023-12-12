package com.codigo.Leodan_Condori.service;

import com.codigo.Leodan_Condori.entity.EditorEntity;

import java.util.List;

public interface EditorService {
    EditorEntity crearEditor(EditorEntity editor);
    EditorEntity obtenerEditorPorId(Long id) throws Exception;
    EditorEntity actualizarEditor(Long id, EditorEntity editorActualizado) throws Exception;
    String eliminarEditor(Long id) throws Exception;
    List<EditorEntity> obtenerTodos();
}
