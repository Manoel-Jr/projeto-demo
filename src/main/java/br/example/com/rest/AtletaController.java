package br.example.com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.example.com.model.Atleta;
import br.example.com.service.AtletaService;

@RestController
@RequestMapping("/rest/atletas")
public class AtletaController {

	@Autowired
	private AtletaService atletaService;
	
	
	@PostMapping
	public ResponseEntity<Atleta> createAtlete(@RequestBody Atleta atleta){
		return new ResponseEntity<>(atletaService.criarAtelta(atleta), HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar-atleta-por-id/{id}")
	public ResponseEntity<Atleta> seachAtletaId(@PathVariable Long id){
		Atleta atleta = atletaService.buscarAtletaPorId(id);
		return  ResponseEntity.ok().body(atleta);
	}
	
	@GetMapping(value="/buscar-atleta-por-cpf/{cpf}")
	public ResponseEntity<Atleta> seachAtletaCpf(@PathVariable String cpf){
		return new ResponseEntity<>(atletaService.buscarAtletaPorCpf(cpf), HttpStatus.OK);
	}
	
	@GetMapping(value= "/listar-todos-todos-atletas")
	public ResponseEntity<List<Atleta>> listarTodosAtletas(){
		return new ResponseEntity<>(atletaService.listaDeAtleta(), HttpStatus.OK);
	}
	
}
