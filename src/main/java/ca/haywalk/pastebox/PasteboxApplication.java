/*
 * Pastebin clone in Spring Boot
 * Hayden Walker, 2025-06-25
 */

package ca.haywalk.pastebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic "Pastebin" clone.
 */
@SpringBootApplication
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Allow all origins for testing; restrict in production!
public class PasteboxApplication {
	/**
	 * Start the application.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PasteboxApplication.class, args);
	}

	/**
	 * Return a home page.
	 * 
	 * @return Home page.
	 */
	@GetMapping("/")
	public String homepage() {
		return "Hello, world!";
	}

	// /**
	//  * Upload content.
	//  * 
	//  * @param content Content.
	//  * @return Content ID.
	//  */
	// @GetMapping("/paste") 
	// public String paste(@RequestParam(value = "content", defaultValue = "") String content) {
	// 	return ContentDB.instance().addContent(content);
	// }

	/**
	 * Upload content.
	 * 
	 * @param content Content.
	 * @return Content ID.
	 */
	@PostMapping("/paste")
	public ResponseEntity<String> paste(@RequestBody String paste) {
		String id = ContentDB.instance().addContent(paste);
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
	} 

	/**
	 * Retrieve content.
	 * 
	 * @param id Content ID.
	 * @return Content.
	 */
	@GetMapping("/retrieve") 
	public String retrieve(@RequestParam(value = "id", defaultValue = "") String id) {
		return ContentDB.instance().getContent(id);
	}
}
