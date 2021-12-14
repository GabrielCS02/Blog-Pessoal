package org.generation.meuBlog.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.meuBlog.model.Postagem;
import org.generation.meuBlog.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;
	
	
    // retorna todas as postagens
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
    // Retorna uma postagem pelo título
	 @GetMapping("/{id}")
	 public ResponseEntity<Postagem> GetById(@PathVariable long id){
		 return postagemRepository.findById(id)
		.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}

	    // Retorna postagem pelo título
	  @GetMapping("/titulo/{titulo}")
	  public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		  return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
		}
	  // Adiciona uma postagem
	  @PostMapping
	  public ResponseEntity<Postagem> post (@Valid @RequestBody Postagem postagem){
		  return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	  //altera uma postagem
	  }
	  @PutMapping
	  public ResponseEntity<Postagem> put (@Valid @RequestBody Postagem postagem){
		  return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
	  }
	  
	  @DeleteMapping("/{id}")
	  public void delete(@PathVariable long id) {
		  postagemRepository.deleteById(id);
	  }
}
