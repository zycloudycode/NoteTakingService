package ws.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data does not exist")
public class DataNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataNotFoundException() {
		super();
	}
}
