package com.codigo.Leodan_Condori.controller;

import com.codigo.Leodan_Condori.entity.CategoriaEntity;
import com.codigo.Leodan_Condori.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @PostMapping
    public ResponseEntity<CategoriaEntity> crearCategoria(@RequestBody CategoriaEntity categoria){
        CategoriaEntity nuevoCategoria = categoriaService.crearCategoria(categoria);
        return new ResponseEntity<>(nuevoCategoria, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> obtenerCategoriaPorId(@PathVariable Long id) throws Exception{
        CategoriaEntity categoria = categoriaService.obtenerCategoriaPorId(id);
        return ResponseEntity.ok(categoria);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> actualizarCategoriaPorId(@PathVariable Long id, @RequestBody CategoriaEntity categoriaActualizada) throws Exception {
        //try {
        //    CategoriaEntity categoriaActualizadaResponse = categoriaService.actualizarCategoria(id, categoriaActualizada);
        //    return ResponseEntity.ok(categoriaActualizadaResponse);
        //} catch (Exception e) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        CategoriaEntity categoria = categoriaService.actualizarCategoria(id, categoriaActualizada);
        if(categoria != null){
            return ResponseEntity.ok(categoriaActualizada);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoriaPorId(@PathVariable Long id) throws Exception{
        //try {
        //    categoriaService.eliminarCategoria(id);
        //    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //} catch (Exception e) {
        //    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //}
        String categoriaEliminado = categoriaService.eliminarCategoria(id);
        if(categoriaEliminado != null){
            return ResponseEntity.ok("eliminado");
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public List<CategoriaEntity> ListarAutores(){
        return categoriaService.obtenerTodos();
    }
}
