package com.sean.rest.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import org.codehaus.jettison.json.JSONException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

// TODO: Auto-generated Javadoc
/**
 * The Class GenerateExcelFile.
 * 
 * @author seanmenezes
 */
public class GenerateExcelFile {

	/**
	 * Creates the file.
	 * 
	 * @param restUrl
	 *            the rest url
	 * @param filePath
	 *            the file path
	 * @param fileName
	 *            the file name
	 * @return true, if successful
	 * @throws JSONException
	 *             the JSON exception
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public boolean createFile(String restUrl, String filePath, String fileName)
			throws JSONException, JsonParseException, JsonMappingException,
			IOException {

		Client client = Client.create();
		WebResource webResource = client.resource(restUrl);

		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		final String incomingJSON = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(incomingJSON);
		// Parse Jason to collection
		Gson gson = new Gson();
		Type type = new TypeToken<List<LatitudeLongitudeVo>>() {
		}.getType();
		List<LatitudeLongitudeVo> latitudeLongitudeVoList = gson.fromJson(
				incomingJSON, type);
		Path directory = Paths.get(filePath);
		// create a file newFile.txt using the Files singleton
		// under the example directory
		Path newFile = directory.resolve(fileName);
		Files.createFile(newFile);

		try {
			// any resources (must implement AutoCloseable) in here
			// will automatically be closed on exiting the try block.
			FileWriter writer = new FileWriter(newFile.toFile());
			PrintWriter printWriter = new PrintWriter(writer);
			String usaCheck;
			HashMap<String, String> distanceCityMap;

			for (LatitudeLongitudeVo latitudeLongitudeVo : latitudeLongitudeVoList) {
				// check if in USA using GeoLocatorStatic function
				usaCheck = GeoLocatorUtility.checkIfCoordinatesInUSA(
						latitudeLongitudeVo.getLatitude(),
						latitudeLongitudeVo.getLongitude());
				if (!(usaCheck == ApplicationMessagesConstants.NOT_IN_UNITED_STATES_OF_AMERICA)) {
					// now write out to the file
					StringBuilder sb = new StringBuilder();
					sb.append(latitudeLongitudeVo.getLatitude()).append(" , ")
							.append(latitudeLongitudeVo.getLongitude())
							.append(" , ").append(usaCheck).append(",")
							.append(" USA ").append(" ,").append(0)
							.append(", ").append(new Date());
					printWriter.println(sb.toString());
				} else {
					distanceCityMap = GeoLocatorUtility
							.checkDistanceToNearestCity(
									latitudeLongitudeVo.getLatitude(),
									latitudeLongitudeVo.getLongitude());
					StringBuilder sb = new StringBuilder();
					System.out.println(distanceCityMap.size());
					if (distanceCityMap.size() == 2) {
						System.out.println(1);	
						sb.append(latitudeLongitudeVo.getLatitude()).append(" , ")
								.append(latitudeLongitudeVo.getLongitude())
								.append(" , ").append(usaCheck).append(",")
								.append((String)distanceCityMap.get(ApplicationMessagesConstants.NEAREST_CITY))
								.append(" ,")
								.append((String)distanceCityMap.get(ApplicationMessagesConstants.DISTANCE))
								.append(", ").append(new Date());
						
						 printWriter.println(sb.toString());
					
					} else {
						sb.append(latitudeLongitudeVo.getLatitude())
								.append(" , ")
								.append(latitudeLongitudeVo.getLongitude())
								.append(" , ")
								.append(usaCheck)
								.append(",")
								.append(ApplicationMessagesConstants.NO_CITY_WITHIN_500_MILES)
								.append(" ,").append(0).append(", ")
								.append(new Date());
						
						printWriter.println(sb.toString());
					}
				}

			}
			printWriter.close();
			writer.close();
			return true;
		} catch (IOException e) {
			// just need to deal with any errors.
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		GenerateExcelFile generateFile = new GenerateExcelFile();
		try {
			boolean success = generateFile
					.createFile(
							"http://localhost:8080/locationservices/rest/latitudelongitude/getAllData",
							"/Users/seanmenezes/Desktop/",
							"LongitudeLatitudeData.csv");
			if (success)
				System.out.println("File created !!!");
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
