package com.example.ejemplo.controller;

import com.example.ejemplo.model.Producto;
import com.example.ejemplo.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }
    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerPorId(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));
    }
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }
    @PutMapping("/{id}")
    public Producto actualizar(
            @PathVariable Long id,
            @RequestBody Producto producto) {
        return productoService.actualizar(id, producto);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
