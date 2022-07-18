package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetDemo {
	public static void main(String[] args) {

		String uri = "http://localhost:8080/REST_API_using_Spring/movies/1";

		CloseableHttpClient client = HttpClients.createDefault();

		try {

			HttpGet request = new HttpGet(uri); // throws IllegalArgumentException
												// create request

			CloseableHttpResponse response = client.execute(request); // IOException, ClientProtocolException
																		// generate response executing request

			System.out.println(response.getProtocolVersion());					//the name of the protocol, for example "HTTP" and version of protocol
			System.out.println(response.getStatusLine().getStatusCode());		//status code of the protocol
			System.out.println(response.getStatusLine().getReasonPhrase());		//textual line of status code
			System.out.println(response.getStatusLine().toString());			//combination of protocol + status code + reason phrase

			try {

				HttpEntity entity = response.getEntity();

				if (entity != null) {
					String result = EntityUtils.toString(entity);
					System.out.println("Response is  :   " + result);
				}

			} catch (Exception e) {

				System.out.println("exception while decoding response");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("issue in making http call!!!");
			e.printStackTrace();
		}
	}
}