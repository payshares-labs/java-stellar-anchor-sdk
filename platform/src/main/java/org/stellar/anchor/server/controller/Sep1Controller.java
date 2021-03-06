package org.stellar.anchor.server.controller;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stellar.anchor.config.Sep1Config;
import org.stellar.anchor.dto.SepExceptionResponse;
import org.stellar.anchor.exception.SepNotFoundException;
import org.stellar.anchor.sep1.Sep1Service;

@RestController
public class Sep1Controller {
  private final Sep1Config sep1Config;
  private final Sep1Service sep1Service;

  public Sep1Controller(Sep1Config sep1Config, Sep1Service sep1Service) {
    this.sep1Config = sep1Config;
    this.sep1Service = sep1Service;
  }

  @CrossOrigin(origins = "*")
  @RequestMapping(
      value = "/.well-known/stellar.toml",
      method = {RequestMethod.GET, RequestMethod.OPTIONS})
  public ResponseEntity<String> getToml() throws IOException, SepNotFoundException {
    if (!sep1Config.isEnabled()) {
      throw new SepNotFoundException("Not Found");
    }
    HttpHeaders headers = new HttpHeaders();
    headers.set("content-type", "text/plain");
    return ResponseEntity.ok().headers(headers).body(sep1Service.getStellarToml());
  }

  @ExceptionHandler({SepNotFoundException.class})
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  SepExceptionResponse handleNotFound(Exception ex) {
    return new SepExceptionResponse(ex.getMessage());
  }
}
