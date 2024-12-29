package com.datapac.troubleshootingTool.ErrorCode;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ErrorCodeService {

  private final ErrorCodeRepository errorCodeRepository;

  public ErrorCodeService(ErrorCodeRepository errorCodeRepository) {
    this.errorCodeRepository = errorCodeRepository;
  }

  // read all
  public List<ErrorCode> findAllErrorCodes() {
    return errorCodeRepository.findAll();
  }

  // read by id
  public ErrorCode findByErrorCodeId(Long id) {
    return errorCodeRepository.findById(id).get();
  }

}
