package br.example.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.example.com.model.Atleta;
@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Long>{

	public Atleta findByCpf(String cpf);
	
	public boolean existsByCpf(String cpf);
}
