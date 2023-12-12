package com.codigo.Leodan_Condori.controller;

import com.codigo.Leodan_Condori.service.AutorService;
import com.codigo.Leodan_Condori.entity.AutorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;
    @PostMapping
    public ResponseEntity<AutorEntity> crearAutor(@RequestBody AutorEntity autor){
        AutorEntity nuevoAutor = autorService.crearAutor(autor);
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AutorEntity> obtenerAutorPorId(@PathVariable Long id) throws Exception{
        AutorEntity autor = autorService.obtenerAutorPorId(id);
        return ResponseEntity.ok(autor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AutorEntity> actualizarAutorPorId(@PathVariable Long id,@RequestBody AutorEntity autor) throws Exception{
        //try {
        //    AutorEntity autorActualizadoResponse = autorService.actualizarAutor(id, autor);
        //    return ResponseEntity.ok(autorActualizadoResponse);
        //} catch (Exception e) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        AutorEntity autorActualizado = autorService.actualizarAutor(id, autor);
        if(autor != null){
            return ResponseEntity.ok(autorActualizado);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAutorPorId(@PathVariable Long id) throws Exception{
        //try {
        //    autorService.eliminarAutor(id);
        //    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //} catch (Exception e) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        String autorEliminado = autorService.eliminarAutor(id);
        if(autorEliminado != null){
            return ResponseEntity.ok("eliminado");
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping
    public List<AutorEntity> ListarAutores(){
        return autorService.obtenerTodos();
    }
}
