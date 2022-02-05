package br.example.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.example.com.enums.FaixaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="atletas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Atleta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private FaixaEnum faixa;
	
	private String categoria;
	
	private String cpf;
	
	private double peso;
}
