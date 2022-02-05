package br.example.com.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HandlerGeneric {

	private String timestamp;

	private Integer status;
	
	private String message;
}
