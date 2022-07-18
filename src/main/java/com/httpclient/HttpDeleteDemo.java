package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpDeleteDemo {
	public static void main(String[] args) {

		String uri = "http://localhost:8080/REST_API_using_Spring/movies/5";

		CloseableHttpClient client = HttpClients.createDefault();

		try {
			HttpDelete request = new HttpDelete(uri);

			System.out.println(request.getRequestLine());
			System.out.println("****************************************************************");

			CloseableHttpResponse response = client.execute(request);

			System.out.println(response.getProtocolVersion());
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().toString());

			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String result = EntityUtils.toString(entity);
					System.out.println("Response is : "+result);
				}

			} catch (Exception e) {
				System.out.println("problum in generating response!!!");
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("issue in executing request!!!");
			e.printStackTrace();
		}
	}
}
