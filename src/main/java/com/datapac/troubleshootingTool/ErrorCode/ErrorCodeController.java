package com.datapac.troubleshootingTool.ErrorCode;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/errorcodes")
public class ErrorCodeController {

  private final ErrorCodeService errorCodeService;

  public ErrorCodeController(ErrorCodeService errorCodeService) {
    this.errorCodeService = errorCodeService;
  }

  // read all
  @GetMapping("/all")
  public List<ErrorCode> findAllErrorCodes() {
    return errorCodeService.findAllErrorCodes();
  }

  // read by id
  @GetMapping("/{id}")
  public ErrorCode findErrorCodeById(@PathVariable Long id) {
    return errorCodeService.findByErrorCodeId(id);
  }

}
