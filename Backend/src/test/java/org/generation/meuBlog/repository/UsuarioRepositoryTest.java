package org.generation.meuBlog.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.generation.meuBlog.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start(){

		usuarioRepository.save(new Usuario(0L, "Gabriel Costa", "gabriel@email.com", "13465278","https://imgur.com/gallery/TZvVaVq"));
		
		usuarioRepository.save(new Usuario(0L, "Adelvan Costa", "adelvan@email.com.br", "13465278","https://imgur.com/gallery/YOY0S"));
		
		usuarioRepository.save(new Usuario(0L, "Mariana de Pereira Costa", "mariana@email.com", "13465278","https://imgur.com/gallery/tRTUtkg"));

        usuarioRepository.save(new Usuario(0L, "Paulo Antunes", "paulo@email.com", "13465278","https://imgur.com/gallery/TOgPJwH"));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario>usuario=usuarioRepository.findByUsuario("adelvan@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("adelvan@email.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario>listaDeUsuarios= usuarioRepository.findAllByNomeContainingIgnoreCase("costa");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Gabriel Costa"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Adelvan Costa"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Mariana de Pereira Costa"));
		
	}

}
