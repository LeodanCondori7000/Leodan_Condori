package com.codigo.Leodan_Condori.controller;

import com.codigo.Leodan_Condori.entity.EditorEntity;
import com.codigo.Leodan_Condori.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class EditorController {
    @Autowired
    private EditorService editorService;
    @PostMapping
    public ResponseEntity<EditorEntity> crearEditor(@RequestBody EditorEntity editor){
        EditorEntity nuevoEditor = editorService.crearEditor(editor);
        return new ResponseEntity<>(nuevoEditor, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EditorEntity> obtenerEditorPorId(@PathVariable Long id) throws Exception{
        EditorEntity editor = editorService.obtenerEditorPorId(id);
        return ResponseEntity.ok(editor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EditorEntity> actualizarEditorPorId(@PathVariable Long id, @RequestBody EditorEntity editorActualizado) throws Exception {
        //try {
        //    EditorEntity editorActualizadoResponse = editorService.actualizarEditor(id, editorActualizado);
        //    return ResponseEntity.ok(editorActualizadoResponse);
        //} catch (Exception e) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        EditorEntity editor = editorService.actualizarEditor(id, editorActualizado);
        if(editor != null){
            return ResponseEntity.ok(editorActualizado);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEditorPorId(@PathVariable Long id) throws Exception{
        //try {
        //    editorService.eliminarEditor(id);
        //    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //} catch (Exception e) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        String editorEliminado = editorService.eliminarEditor(id);
        if(editorEliminado != null){
            return ResponseEntity.ok("eliminado");
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping
    public List<EditorEntity> ListarAutores(){
        return editorService.obtenerTodos();
    }
}