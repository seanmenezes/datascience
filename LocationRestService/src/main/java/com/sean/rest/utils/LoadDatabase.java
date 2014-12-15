package com.sean.rest.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sean.data.persistence.jpa.model.LatitudeLongitude;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

// TODO: Auto-generated Javadoc
/**
 * The Class LoadDatabase.
 * 
 * @author seanmenezes
 */
public class LoadDatabase {

	/**
	 * Load random data directly.
	 * 
	 * used to load to database directly witout webservice
	 * 
	 * @param load
	 *            the load
	 * @return true, if successful
	 */
	private boolean loadRandomData(int load) {
		double longitudeTemp, latitudeTemp = 0.0;
		double longitude, latitude = 0.0;

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("locationservices");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Radndom Longitude and latitude generator
		for (int i = 1; i <= load; i++) {

			longitudeTemp = -180 + Math.random() * (180 - (-180));
			longitude = Math.round(longitudeTemp * 100.0) / 100.0;
			latitudeTemp = -90 + Math.random() * (90 - (-90));
			latitude = Math.round(latitudeTemp * 100.0) / 100.0;

			try {
				EntityTransaction entr = entityManager.getTransaction();
				entr.begin();
				LatitudeLongitude latitudeLongitude = new LatitudeLongitude();
				latitudeLongitude.setLatitude(latitude);
				latitudeLongitude.setLongitude(longitude);
				entityManager.persist(latitudeLongitude);
				entr.commit();

			} finally {
				// entityManager.close();
			}
		}
		return false;

	}

	/**
	 * Please use Truncate Table call if rerun before. Load random data with
	 * webservice using addData webservice call please use this one
	 * 
	 * @param load
	 *            the load
	 * @return true, if successful
	 */
	private boolean loadRandomDataWithWebservice(int load) {
		double longitudeTemp, latitudeTemp = 0.0;
		double longitude, latitude = 0.0;

		StringBuffer sb = null;
		int counter = 0;
		for (int i = 1; i <= load; i++) {
			counter++;
			longitudeTemp = -180 + Math.random() * (180 - (-180));
			longitude = Math.round(longitudeTemp * 100.0) / 100.0;
			latitudeTemp = -90 + Math.random() * (90 - (-90));
			latitude = Math.round(latitudeTemp * 100.0) / 100.0;

			try {
				Client client = Client.create();

				WebResource webResource = client
						.resource("http://localhost:8080/locationservices/rest/latitudelongitude/addData");
				sb = new StringBuffer();
				sb.append("{\"latitude\":\"").append(latitude)
						.append("\",\"longitude\":\"").append(longitude)
						.append("\"}");

				// String input =
				// "{\"latitude\":\"34.84\",\"longitude\":\"-118.54\"}";

				ClientResponse response = webResource.type("application/json")
						.post(ClientResponse.class, sb.toString());

				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus());
				}

				System.out.println("Output from Server .... \n");
				String output = response.getEntity(String.class);
				System.out.println(output);

			} catch (Exception e) {

				e.printStackTrace();
				return false;

			}

		}
		System.out.println("Counter " + counter);
		return true;

	}

	/**
	 * The main method. run this to load database application needs to be
	 * deployed on Tomcat Server change persitence.xml to point to your local
	 * database ensure you build var after that or hot deploy persitence.xml
	 * with table created on your database
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		LoadDatabase loadDatabase = new LoadDatabase();
		// boolean done =loadDatabase.loadRandomData(100);
		boolean done = loadDatabase.loadRandomDataWithWebservice(10000);

	}

}
