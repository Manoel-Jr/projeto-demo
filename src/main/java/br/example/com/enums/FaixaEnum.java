package br.example.com.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import br.example.com.exception.FaixaInvalidaException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum FaixaEnum {

	PRETA(1),
	MARRON(2),
	AZUL(3),
	ROXA(4);
	
	private int codigo;
	
	@JsonCreator
	public static FaixaEnum valueOf(Integer idTipoFaixa) {
		for(FaixaEnum value : FaixaEnum.values()) {
			if(idTipoFaixa.equals(value.getCodigo())) {
				return value;
			}
		}
		throw new FaixaInvalidaException();
	}

	@JsonValue
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
