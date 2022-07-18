package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpPutDemo {
	public static void main(String[] args) {

		String uri = "http://localhost:8080/REST_API_using_Spring/movies/2";

		CloseableHttpClient client = HttpClients.createDefault();

		try {
			HttpPut request = new HttpPut(uri);
			
			request.setHeader("Accept", "application/json");
			request.setHeader("content-type", "application/json");
			
			String json = " { \n"
						+ " \"releaseDate\" : 2020, \n"
						+ " \"movie_name\" : \"Sersenapati HambirRao\""
						+ " } \n";
			
			//Alternative ---> HttpEntity stringEntity = new StringEntity(jsonBody,ContentType.APPLICATION_JSON);
			StringEntity requestEntity = new StringEntity(json);
			request.setEntity(requestEntity);
			
			System.out.println(request.getRequestLine());
			System.out.println("***************************************************");

			CloseableHttpResponse response = client.execute(request);

			System.out.println(response.getProtocolVersion());
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().toString());

			try {
				HttpEntity entity = response.getEntity();
				if(entity != null) {
					String result = EntityUtils.toString(entity);
					System.out.println("Response is : "+result);
				}

			} catch (Exception e) {
				System.out.println("unable to generate response!!!");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("issue in updating details!!!");
			e.printStackTrace();
		}
	}
}
