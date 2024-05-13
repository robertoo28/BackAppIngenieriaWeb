package com.example.backendclientes.controllers;

import com.example.backendclientes.model.Cliente;
import com.example.backendclientes.model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backendclientes.services.IClienteService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ClienteRestController {
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        System.out.println("Funciona el endpoint");
        return clienteService.findAll();
    }
    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable long id){
        return clienteService.findById(id);
    }
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Cliente cliente){
        try {

            if (cliente.getNombre().length() > 20) {
                return ResponseEntity.badRequest().body("El nombre tiene mas de 20 caracteres");
            }
            if (cliente.getApellido().length() > 20) {
                return ResponseEntity.badRequest().body("El apellido tiene mas de 20 caracteres");
            }
            if(!cliente.validarEmail(cliente.getEmail())){
                return ResponseEntity.badRequest().body("El email es inválido");
            }
            clienteService.save(cliente);
        }catch (Exception e){

        }
        return ResponseEntity.ok().build();
    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id){
        try {

            Cliente clienteActual = clienteService.findById(id);

            if(clienteActual == null){
                return ResponseEntity.badRequest().body("El cliente no existe");
            }
            if(cliente.getApellido().length() > 20) {
                return ResponseEntity.badRequest().body("El apellido tiene mas de 20 caracteres");
            }

            clienteActual.setApellido(cliente.getApellido());
            if(cliente.getNombre().length() > 20) {
                return ResponseEntity.badRequest().body("El nombre tiene mas de 20 caracteres");
            }
            clienteActual.setNombre(cliente.getNombre());
            if(!cliente.validarEmail(cliente.getEmail())){
                return ResponseEntity.badRequest().body("El email es inválido");
            }
            clienteActual.setEmail(cliente.getEmail());
            clienteService.save(clienteActual);


        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        Cliente clientec = clienteService.findById(id);
        clienteService.delete(id);

    }
}
