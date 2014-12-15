package com.sean.rest.helper.services;

import java.util.List;

import com.sean.data.persistence.jpa.model.LatitudeLongitude;
import com.sean.rest.utils.LatitudeLongitudeVo;

// TODO: Auto-generated Javadoc
/**
 * The Interface LocationService.
 * 
 * @author Sean Menezes
 */
public interface LocationService {

	/**
	 * Gets the location.
	 * 
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 * @return the location
	 */
	public LatitudeLongitudeVo getLocation(double latitude, double longitude);

	/**
	 * Location exist.
	 * 
	 * @param latitudeLongitudeVo
	 *            the latitude longitude
	 * @return true, if successful
	 */
	public boolean checkLocationAlreadyExist(
			LatitudeLongitudeVo latitudeLongitudeVo);

	/**
	 * Gets the all locations.
	 * 
	 * @return the all locations
	 */
	public List<LatitudeLongitudeVo> getAllLocations();

	/**
	 * Save location.
	 * 
	 * @param latitudeLongitudeVo
	 *            the latitude longitude vo
	 * @return true, if successful
	 */
	public boolean saveLocation(LatitudeLongitudeVo latitudeLongitudeVo);

}
