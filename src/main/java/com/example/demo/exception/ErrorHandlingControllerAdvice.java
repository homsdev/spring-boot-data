package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dto.ValidationErrorDTO;
import com.example.demo.dto.ViolationDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorDTO onConstraintValidationError(ConstraintViolationException e) {
		ValidationErrorDTO error = new ValidationErrorDTO();
		for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
			ViolationDTO dto = new ViolationDTO(violation.getPropertyPath().toString(), violation.getMessage());
			error.getViolations().add(dto);
		}

		return error;
	}
}
