package com.putao.upload.controller;

import com.putao.upload.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @version 1.0
 * @author: panpan
 * @create: 2020-08-14 14:57
 **/
@Controller
@RequestMapping("upload")
//@CrossOrigin
public class UploadController {

  @Autowired
  private UploadService uploadService;

  @PostMapping("image")
  public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file) {
    String url = this.uploadService.uploadImage(file);
    if (StringUtils.isBlank(url)) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(url);
  }

}
