package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetAllDemo {
	public static void main(String[] args) {
		
		String uri = "http://localhost:8080/REST_API_using_Spring/movies";
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		try {
			HttpGet request = new HttpGet(uri);
			
			System.out.println(request.getRequestLine());
			System.out.println("****************************************************************");

			CloseableHttpResponse response = client.execute(request);
			
			System.out.println(response.getProtocolVersion());
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().toString());
			
			try {
				
				HttpEntity entity = response.getEntity();
				if(entity != null) {
					String result = EntityUtils.toString(entity);
					System.out.println(result);
				}
				
			} catch (Exception e) {
				
				System.out.println("Exception while decoding response!!!");
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			System.out.println("issue in executing http request!!!");
			e.printStackTrace();
		}
	}
}
