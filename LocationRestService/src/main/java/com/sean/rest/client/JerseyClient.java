package com.sean.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

// TODO: Auto-generated Javadoc
/**
 * The Class JerseyClient.
 * 
 * @author seanmenezes
 * 
 *         Class is used to test webservice and webservice calls. please change
 *         urls ensure persistence.xml point to your database where table is
 *         created. build war and deploy.
 */
public class JerseyClient {

	/**
	 * Gets the methods client.
	 * 
	 * @return the methods client
	 */
	public void getMethodsClient() {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/locationservices/rest/latitudelongitude/getAllData");

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * Post methods client.
	 */
	public void postMethodsClient() {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/locationservices/rest/latitudelongitude/addData");

			String input = "{\"latitude\":\"34.84\",\"longitude\":\"-118.54\"}";

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * The main method.
	 * 
	 * @param arg
	 *            the arguments
	 */
	public static void main(String[] arg) {
		JerseyClient jc = new JerseyClient();
		jc.postMethodsClient();
		jc.getMethodsClient();

	}

}