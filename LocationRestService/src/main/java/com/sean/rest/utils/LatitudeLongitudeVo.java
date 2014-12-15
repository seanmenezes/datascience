/*
 * 
 */
package com.sean.rest.utils;

import org.codehaus.jackson.annotate.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class LatitudeLongitude.
 * 
 * @author Sean Ajay Menezes
 */
public class LatitudeLongitudeVo {

	/** The latitude. */
	@JsonProperty
	private Double latitude;

	/** The longitude. */
	@JsonProperty
	private Double longitude;

	/**
	 * Gets the latitude.
	 * 
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 * 
	 * @param latitude
	 *            the new latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = Double.parseDouble(latitude);
	}

	/**
	 * Gets the longitude.
	 * 
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 * 
	 * @param longitude
	 *            the new longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = Double.parseDouble(longitude);
		;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder().append("LatitudeLongitude [ latitude=")
				.append(latitude.toString()).append(", longitude=")
				.append(longitude.toString()).append(" ]").toString();
	}

}
