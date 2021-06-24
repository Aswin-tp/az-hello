package com.in28minutes.rest.webservices.restfulwebservices;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/")
	public ResponseEntity<byte[]> getImage() throws IOException {
	    InputStream in = getClass()
	      .getResourceAsStream("/static/images/m&m.png");
	    byte[] imageBytes = StreamUtils.copyToByteArray(in);

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello Aswin1";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		// throw new RuntimeException("Some Error has Happened! Contact Support at
		// ***-***");
		return new HelloWorldBean("Hello Aswin");
	}

	/// hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello Aswin, %s", name));
	}
}
