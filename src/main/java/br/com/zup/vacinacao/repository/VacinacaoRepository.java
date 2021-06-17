package br.com.zup.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.vacinacao.model.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao,Long> {
	
}



