package br.example.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.example.com.exception.AtletaExistenteException;
import br.example.com.exception.AtletaNotFoundException;
import br.example.com.model.Atleta;
import br.example.com.repository.AtletaRepository;

@Service
public class AtletaServiceImplementacao implements AtletaService {

	@Autowired
	private AtletaRepository repository;

	@Override
	public Atleta criarAtelta(Atleta atleta) {
		if (repository.existsByCpf(atleta.getCpf())) {
			throw new AtletaExistenteException();
		}
		return repository.save(atleta);
	}

	@Override
	public Atleta buscarAtletaPorId(Long id) {
		Optional<Atleta> atleta = repository.findById(id);
		return atleta.orElseThrow(() -> new AtletaNotFoundException());
	}

	@Override
	public Atleta buscarAtletaPorCpf(String cpf) {
		Atleta atleta = (repository.findByCpf(cpf));
		if (atleta == null) {
			throw new AtletaNotFoundException();
		}
		return atleta;
	}

	@Override
	public List<Atleta> listaDeAtleta() {
		return repository.findAll();
	}

}
