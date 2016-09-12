package io.egen.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EntityAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -1905297114620801383L;
	
	public EntityAlreadyExistsException (String message){
		super(message);
	}

}
