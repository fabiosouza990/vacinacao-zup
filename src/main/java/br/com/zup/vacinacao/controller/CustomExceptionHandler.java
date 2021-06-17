package br.com.zup.vacinacao.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.zup.vacinacao.service.exception.BadRequestException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zup.vacinacao.model.dto.output.ErrorOutputDTO;

@RestControllerAdvice(basePackages="br.com.zup.vacinacao.controller")
public class CustomExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorOutputDTO>> validation(MethodArgumentNotValidException ex) {

		List<ErrorOutputDTO> errors = new ArrayList<>();

		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

		fieldErrors.forEach(error -> {
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			ErrorOutputDTO errorOutput = new ErrorOutputDTO(message);
			errors.add(errorOutput);
		});

		return ResponseEntity.badRequest().body(errors);
		
	}

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorOutputDTO> handlerBadRequestException(BadRequestException ex){
		ErrorOutputDTO errorMessage = new ErrorOutputDTO(ex.getMessage());
		return ResponseEntity.badRequest().body(errorMessage);
	}
}


