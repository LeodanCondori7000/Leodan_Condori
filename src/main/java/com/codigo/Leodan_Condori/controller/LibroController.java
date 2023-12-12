package com.codigo.Leodan_Condori.controller;

import com.codigo.Leodan_Condori.entity.LibroEntity;
import com.codigo.Leodan_Condori.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class LibroController {
    @Autowired
    private LibroService libroService;
    @PostMapping
    public ResponseEntity<LibroEntity> crearLibro(@RequestBody LibroEntity libro){
        LibroEntity nuevoEditor = libroService.crearLibro(libro);
        return new ResponseEntity<>(nuevoEditor, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LibroEntity> obtenerLibroPorId(@PathVariable Long id) throws Exception{
        LibroEntity libro = libroService.obtenerLibroPorId(id);
        return ResponseEntity.ok(libro);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LibroEntity> actualizarLibroPorId(@PathVariable Long id, @RequestBody LibroEntity libroActualizado) throws Exception {
        //try {
        //    LibroEntity libroActualizadoResponse = libroService.actualizarLibro(id, libroActualizado);
        //    return ResponseEntity.ok(libroActualizadoResponse);
        //} catch (Exception e) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        LibroEntity libro = libroService.actualizarLibro(id, libroActualizado);
        if(libro != null){
            return ResponseEntity.ok(libroActualizado);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibroPorId(@PathVariable Long id) throws Exception{
        //ry {
        //    libroService.eliminarLibro(id);
        //    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //} catch (Exception e) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        String libroEliminado = libroService.eliminarLibro(id);
        if(libroEliminado != null){
            return ResponseEntity.ok("eliminado");
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping
    public List<LibroEntity> ListarAutores(){
        return libroService.obtenerTodos();
    }
}