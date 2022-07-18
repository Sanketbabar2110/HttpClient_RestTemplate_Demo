package com.resttemplate;

import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo {
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();

		String result = restTemplate.getForObject("http://localhost:8080/REST_API_using_Spring/movies/1", String.class);

		System.out.println(result);
	}
}
	
	/**
	 * 	
	 * 		Methods in RestTamplate class :
	 * 
	 * 		1.	getForEntity()		: returns the entity as a response with http status code and resource as a entity
	 * 								  in JSON format
	 * 	
	 * 		2.	getForObject()		: returns the converted object as POJO, it returns resource directly or returns
	 * 								  representation found in the response 
	 * 
	 *  	3.	postForEntity		: Create a new resource by POSTing the given object to the URI template, and 
	 *  							  returns the response as ResponseEntity.
	 *  
	 *  	4.	postForObject()		: Create a new resource by POSTing the given object to the URI template, and 
	 *  							  returns the representation found in the response.
	 *  
	 *  	5.	put()				: Create or update a resource by PUTting the given object to the URI. keep in
	 *  							  mind that the operation isn't returning a body back to the client
	 *  
	 *  	6.	delete()			: Delete the resources at the specified URI.
	 *  
	 *  	7.	patchForObject()	: Update a resource by PATCHing the given object to the URI template, and 
	 *  							  return the representation found in the response.
	 *  
	 *  	8.	execute()			: Execute the HTTP method to the given URI template, preparing the request
	 *  							  with the RequestCallback, and reading the response with a ResponseExtractor
	 *  
	 *  	9.	exchange()			: Execute the HTTP method to the given URI template, writing the given 
	 *  							  request entity to the request, and returns the response as ResponseEntity
	 * 
	 * **/
	 