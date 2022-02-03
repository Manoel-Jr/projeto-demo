package br.example.com.service;

import java.util.List;

import br.example.com.model.Atleta;

public interface AtletaService {

	public Atleta criarAtelta(Atleta atleta);
	
	public Atleta buscarAtletaPorCpf(String cpf);
	
	public Atleta buscarAtletaPorId(Long id);
	
	public List<Atleta> listaDeAtleta();
}
