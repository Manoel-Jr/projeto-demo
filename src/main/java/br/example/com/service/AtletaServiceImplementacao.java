package br.example.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.example.com.dto.AtletaDTO;
import br.example.com.model.Atleta;
import br.example.com.repository.AtletaRepository;

@Service
public class AtletaServiceImplementacao implements AtletaService {

	@Autowired
	private AtletaRepository repository;

	@Override
	public Atleta criarAtelta(Atleta atleta) {
		if (repository.existsByCpf(atleta.getCpf())) {
			System.out.println("cpf já existe!");
		} else {
			return repository.save(atleta);
		}
		return null;
	}

	@Override
	public Atleta buscarAtletaPorId(Long id) {
		Atleta atleta = repository.findById(id).get();
		if (atleta == null) {
			System.out.println("atleta Invalido!");
		}
		return atleta;
	}

	@Override
	public Atleta buscarAtletaPorCpf(String cpf) {
		Atleta at = repository.findByCpf(cpf);
		if (at == null) {
			System.out.println("atleta Invalido!");
		}
		return at;
	}

	@Override
	public List<Atleta> listaDeAtleta() {
		if (repository.findAll() == null) {
			System.out.println("lista Vazia!!");
		}
		return repository.findAll();
	}

//	public void verificarCpf(String cpf) {
//		if (repository.existsByCpf(cpf)) {
//			System.out.println("cpf já existe!");
//		}
//	}

//	public AtletaDTO recebeAtleta(Atleta atleta) {
//		AtletaDTO at = new AtletaDTO();
//		at.setNome(atleta.getNome());
//		at.setCpf(atleta.getCpf());
//		at.setFaixa(atleta.getFaixa());
//		at.setCategoria(atleta.getCategoria());
//		at.setPeso(atleta.getPeso());
//		return at;
//	}

}
