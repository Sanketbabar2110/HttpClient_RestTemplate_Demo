package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpPostDemo {
	public static void main(String[] args) {

		String uri = "http://localhost:8080/REST_API_using_Spring/movies";

		CloseableHttpClient client = HttpClients.createDefault();

		try {
			HttpPost request = new HttpPost(uri);
			
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");

			String json = " { \n" 
						+ "    \"releaseDate\" : 2007,\n"
						+ "    \"movie_name\" : \"How to train your Dragon : Part 1\"\n"
						+ " } \n";

			//Alternative ---> HttpEntity stringEntity = new StringEntity(jsonBody,ContentType.APPLICATION_JSON);
			StringEntity requestEntity = new StringEntity(json);
			request.setEntity(requestEntity);

			System.out.println(request.getRequestLine());
			System.out.println("****************************************************************");

			CloseableHttpResponse response = client.execute(request);

			System.out.println(response.getProtocolVersion());
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().toString());

			try {
				HttpEntity responseEntity = response.getEntity();

				if (responseEntity != null) {
					String result = EntityUtils.toString(responseEntity);
					System.out.println("Response is : " + result);
				}

			} catch (Exception e) {
				System.out.println("exception while decoding response");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("Failed to execute post request!!!");
			e.printStackTrace();
		}
	}
}
