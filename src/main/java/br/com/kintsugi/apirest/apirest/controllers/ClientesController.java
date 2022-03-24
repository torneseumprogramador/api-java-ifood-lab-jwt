package br.com.kintsugi.apirest.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.kintsugi.apirest.apirest.domain.entidade.Cliente;
import br.com.kintsugi.apirest.apirest.domain.repo.ClienteRepo;
import br.com.kintsugi.apirest.apirest.model_views.ClientePatch;

@RestController
public class ClientesController {

  @Autowired
  private ClienteRepo repo;

  @GetMapping("/clientes")
  public List<Cliente> index(){
    List<Cliente> clientes = (List<Cliente>)repo.findAll();
    return clientes;
  }

  @PostMapping("/clientes")
  public ResponseEntity<Cliente> create(@RequestBody Cliente cli){
    repo.save(cli);
    return ResponseEntity.status(201).body(cli);
  }

  @PutMapping("/clientes/{id}")
  public ResponseEntity<Cliente> update(@PathVariable int id, @RequestBody Cliente cli){
    if(!repo.existsById(id)) return ResponseEntity.status(404).build();

    cli.setId(id);
    repo.save(cli);

    return ResponseEntity.ok(cli);
  }

  @PatchMapping("/clientes/{id}")
  public ResponseEntity<Cliente> updateNome(@PathVariable int id, @RequestBody ClientePatch cli){
    if(!repo.existsById(id)) return ResponseEntity.status(404).build();
    Cliente clienteDb = repo.findById(id).get();
    clienteDb.setNome(cli.getNome());
    repo.save(clienteDb);
    return ResponseEntity.ok(clienteDb);
  }

  @GetMapping("/clientes/{id}")
  public ResponseEntity<Cliente> show(@PathVariable int id){
    if(!repo.existsById(id)) return ResponseEntity.status(404).build();
    Optional<Cliente> cli = repo.findById(id);
    return ResponseEntity.ok(cli.get());
  }

  @DeleteMapping("/clientes/{id}")
  public ResponseEntity<Cliente> update(@PathVariable int id){
    if(!repo.existsById(id)) return ResponseEntity.status(404).build();

    repo.deleteById(id);
    
    return ResponseEntity.status(204).build();
  }
}
