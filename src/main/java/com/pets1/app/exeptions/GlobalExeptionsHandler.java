package com.pets1.app.exeptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExeptionsHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoudExeption.class)
	public ResponseEntity<ErroreDetails> manejarResourceNotFoundExeption(ResourceNotFoudExeption exeption, WebRequest webRequest){
		ErroreDetails erroreDetails = new ErroreDetails(new Date(), exeption.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(erroreDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AppPetsCareExeption.class)
	public ResponseEntity<ErroreDetails> manejarAppPetscareExeption(AppPetsCareExeption exeption, WebRequest webRequest){
		ErroreDetails erroreDetails = new ErroreDetails(new Date(), exeption.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(erroreDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErroreDetails> manejarGlobalExeption(Exception exeption, WebRequest webRequest){
		ErroreDetails errorDetalles=new ErroreDetails(new Date(), exeption.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetalles, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String nombreCampo = ((FieldError)error).getField();
			String mensaje = error.getDefaultMessage();
			
			errores.put(nombreCampo, mensaje);
		});
		return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
	}
}