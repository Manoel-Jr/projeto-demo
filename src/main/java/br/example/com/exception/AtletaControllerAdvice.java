package br.example.com.exception;

import static br.example.com.utils.Constantes.ATLETA_NAO_ENCONTRADO;
import static br.example.com.utils.Constantes.CPF_JA_EXISTE;
import static br.example.com.utils.Constantes.FAIXA_INVALIDA;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class AtletaControllerAdvice {

	@ResponseBody
	@ExceptionHandler(AtletaNotFoundException.class)
	public ResponseEntity<Object> atletaNotFound(){
		HandlerGeneric generic = new HandlerGeneric(
				getTimesTamp(),
				HttpStatus.NOT_FOUND.value(),
				ATLETA_NAO_ENCONTRADO );
		return new ResponseEntity<>(generic, HttpStatus.NOT_FOUND);
		
	}
	
	@ResponseBody
	@ExceptionHandler(AtletaExistenteException.class)
	public ResponseEntity<Object> atletaExistente(){
		HandlerGeneric generic = new HandlerGeneric(getTimesTamp(),
				HttpStatus.BAD_REQUEST.value(),
				CPF_JA_EXISTE);
		return new ResponseEntity<>(generic, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FaixaInvalidaException.class)
	public ResponseEntity<Object> faixaInvalida() {
		HandlerGeneric generic = new HandlerGeneric(getTimesTamp(),
				HttpStatus.BAD_REQUEST.value(),
				FAIXA_INVALIDA);
		return new ResponseEntity<>(generic, HttpStatus.BAD_REQUEST);
	}
	
	public String getTimesTamp() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return formatter.format(dateTime);
	}
	
	
}
