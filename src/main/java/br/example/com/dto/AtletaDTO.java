package br.example.com.dto;

import lombok.Data;

@Data
public class AtletaDTO {

	private Long id;

	private String nome;

	private String faixa;

	private String categoria;

	private String cpf;

	private double peso;
}
