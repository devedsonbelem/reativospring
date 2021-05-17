package br.com.ame.config;

import br.com.ame.exceptions.PlanetsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestControllerHandler {

  @ExceptionHandler(PlanetsException.class)
  public ResponseEntity<String> handleNotFound(final PlanetsException ex) {
    log.error(ex.getMessage(), ex);
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

}
