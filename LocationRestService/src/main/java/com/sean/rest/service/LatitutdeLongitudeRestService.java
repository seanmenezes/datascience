package com.sean.rest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONArray;

import com.google.gson.Gson;
import com.sean.data.persistence.jpa.model.LatitudeLongitude;
import com.sean.rest.helper.services.LocationService;
import com.sean.rest.helper.services.LocationServiceInAuth;
import com.sean.rest.utils.ApplicationMessagesConstants;
import com.sean.rest.utils.LatitudeLongitudeVo;

// TODO: Auto-generated Javadoc
/**
 * The Class LatitutdeLongitudeRestService.
 * 
 * @author seanmenezes
 * 
 *         the Rest Service Class for LongitudeLatitude.
 */
@Path("/latitudelongitude")
public class LatitutdeLongitudeRestService {

	/** The context. */
	@Context
	private UriInfo context;

	/** The Constant locationService. */
	private final static LocationService locationService = LocationServiceInAuth
			.getInstance();

	/**
	 * Gets the all data sets.
	 * 
	 * @return the all data sets
	 */
	@GET
	@Path("/getAllData")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllDataSets() {
		// JSONArray mJSONArray = new JSONArray();
		Gson gson = null;
		String jsonLatitudeLongitude = "";
		List<LatitudeLongitudeVo> latitudeLongitudeVoList = locationService
				.getAllLocations();

		if (latitudeLongitudeVoList != null
				|| latitudeLongitudeVoList != Collections.EMPTY_LIST) {
			gson = new Gson();
			jsonLatitudeLongitude = gson.toJson(latitudeLongitudeVoList);
			System.out.println("jsonLatitudeLongitude  = "
					+ jsonLatitudeLongitude);
			return jsonLatitudeLongitude;
			// return new JSONArray(latitudeLongitudeVoList);
		} else {
			jsonLatitudeLongitude = gson.toJson(Collections.EMPTY_LIST);
			return jsonLatitudeLongitude;
			// return new JSONArray(Collections.EMPTY_LIST);
		}
	}

	/**
	 * Gets the data.
	 * 
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 * @return the data
	 */
	@GET
	@Path("/getData")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean getData(@QueryParam("latitude") String latitude,
			@QueryParam("longitude") String longitude) {

		if (latitude != null && latitude.equals("") && longitude != null
				&& longitude.equals("")) {
			LatitudeLongitudeVo latLongitudeVo = new LatitudeLongitudeVo();
			latLongitudeVo.setLatitude(latitude);
			latLongitudeVo.setLongitude(longitude);

			if (locationService.checkLocationAlreadyExist(latLongitudeVo))
				return true;

		}
		return false;
	}

	/**
	 * Adds the data.
	 * 
	 * @param latitudeLongitudeVo
	 *            the latitude longitude vo
	 * @return the response
	 */
	@POST
	@Path("/addData")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addData(LatitudeLongitudeVo latitudeLongitudeVo) {
		boolean flag = false;
		String result;

		System.out.println("Latitude Sent is -->"
				+ latitudeLongitudeVo.getLatitude());
		System.out.println("Longitude Sent is -->"
				+ latitudeLongitudeVo.getLongitude());
		flag = locationService.checkLocationAlreadyExist(latitudeLongitudeVo);
		if (flag) {
			result = ApplicationMessagesConstants.RESULT_NOT_SAVED;

			return Response.status(201).entity(result).build();
		} else {
			boolean saved = locationService.saveLocation(latitudeLongitudeVo);
			if (saved)
				result = ApplicationMessagesConstants.RESULT_SAVED;
			else
				result = ApplicationMessagesConstants.RESULT_NOT_SAVED;

			return Response.status(201).entity(result).build();

		}
	}

}
