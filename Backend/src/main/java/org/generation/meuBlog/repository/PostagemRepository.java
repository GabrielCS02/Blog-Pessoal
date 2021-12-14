package org.generation.meuBlog.repository;

import java.util.List;

import org.generation.meuBlog.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	
	/**
	 * Method Query equivalente a instrução SQL
	 * SELECT * FROM tb_postagem where like "%titulo%"
	 */
	
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
