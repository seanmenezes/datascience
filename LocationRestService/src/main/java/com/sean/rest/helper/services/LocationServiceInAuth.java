package com.sean.rest.helper.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sean.rest.utils.ApplicationMessagesConstants;
import com.sean.rest.utils.LatitudeLongitudeVo;
import com.sean.data.persistence.jpa.model.LatitudeLongitude;
import com.sean.data.persistence.repository.LatitudeLongitudeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationServiceInAuth.
 * 
 * @author seanmenezes
 */
public class LocationServiceInAuth implements LocationService {

	/** The lat long repo. */
	LatitudeLongitudeRepository latLongRepo = null;

	/** The location service. */
	private static LocationService locationService;

	/**
	 * Instantiates a new location service in auth.
	 */
	private LocationServiceInAuth() {

	}

	/**
	 * Gets the single instance of LocationServiceInAuth.
	 * 
	 * @return single instance of LocationServiceInAuth
	 */
	public static LocationService getInstance() {
		if (locationService == null)
			locationService = new LocationServiceInAuth();

		return locationService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sean.rest.helper.services.LocationService#getLocation(double,
	 * double)
	 */
	public LatitudeLongitudeVo getLocation(double latitude, double longitude) {

		latLongRepo = new LatitudeLongitudeRepository();
		return transform(latLongRepo.findLatitudeLongitude(latitude, longitude));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sean.rest.helper.services.LocationService#checkLocationAlreadyExist
	 * (com.sean.rest.utils.LatitudeLongitudeVo)
	 */
	public boolean checkLocationAlreadyExist(
			LatitudeLongitudeVo latitudeLongitudeVo) {

		if (latitudeLongitudeVo == null)
			throw new IllegalArgumentException(
					ApplicationMessagesConstants.NULL_LATITUDE_LONGITUDE_OBJECT);
		latLongRepo = new LatitudeLongitudeRepository();

		return latLongRepo.findLatitudeLongitudeExists(
				latitudeLongitudeVo.getLatitude(),
				latitudeLongitudeVo.getLongitude());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sean.rest.helper.services.LocationService#getAllLocations()
	 */
	public List<LatitudeLongitudeVo> getAllLocations() {

		latLongRepo = new LatitudeLongitudeRepository();
		List<LatitudeLongitude> latitudeLongitudeList = latLongRepo
				.findAllLatitudeLongitudeObjects();
		List<LatitudeLongitudeVo> latitudeLongitudeVoList = Collections.EMPTY_LIST;

		if (latitudeLongitudeList != null
				|| latitudeLongitudeList != Collections.EMPTY_LIST) {
			latitudeLongitudeVoList = new ArrayList(
					latitudeLongitudeList.size());
			;
			for (LatitudeLongitude latitudeLongitude : latitudeLongitudeList) {
				latitudeLongitudeVoList.add(transform(latitudeLongitude));
			}

		} else {
			return Collections.EMPTY_LIST;
		}

		return latitudeLongitudeVoList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sean.rest.helper.services.LocationService#saveLocation(com.sean.rest
	 * .utils.LatitudeLongitudeVo)
	 */
	public boolean saveLocation(LatitudeLongitudeVo latitudeLongitudeVo) {
		latLongRepo = new LatitudeLongitudeRepository();
		LatitudeLongitude latLongitude = latLongRepo.insertLatitudeLongitude(
				latitudeLongitudeVo.getLatitude(),
				latitudeLongitudeVo.getLongitude());

		if (latLongitude != null)
			return true;
		else
			return false;
	}

	/**
	 * Transform.
	 * 
	 * @param latLongitude
	 *            the lat longitude
	 * @return the latitude longitude vo
	 */
	private LatitudeLongitudeVo transform(LatitudeLongitude latLongitude) {

		if (latLongitude == null)
			throw new IllegalArgumentException(
					ApplicationMessagesConstants.NULL_LATITUDE_LONGITUDE_OBJECT);

		LatitudeLongitudeVo latLongVo = new LatitudeLongitudeVo();
		latLongVo.setLatitude(String.valueOf(latLongitude.getLatitude()));
		latLongVo.setLongitude(String.valueOf(latLongitude.getLongitude()));
		return latLongVo;

	}

}
