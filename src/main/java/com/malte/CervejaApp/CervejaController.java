package com.malte.CervejaApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CervejaController {
	
	@Autowired
	private ApplicationContext appContext;
	
	@GetMapping("/hello")
    public String hello() {
            return "Hello Spring Boot!";
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImageAsResponseEntity() {
	    HttpHeaders headers = new HttpHeaders();
	    Resource in = appContext.getResource("classpath:construcao.jpeg");
	    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	    return new ResponseEntity(in, headers, HttpStatus.OK);
	}
	

}
