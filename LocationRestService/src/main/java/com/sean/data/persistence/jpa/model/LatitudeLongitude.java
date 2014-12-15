package com.sean.data.persistence.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

// TODO: Auto-generated Javadoc
/**
 * The Class LatitudeLongitude.
 * 
 * @author seanmenezes
 */
@Entity
public class LatitudeLongitude implements Serializable {

	/** The location_id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int location_id;

	/**
	 * Gets the location_id.
	 * 
	 * @return the location_id
	 */
	public int getLocation_id() {
		return location_id;
	}

	/**
	 * Sets the location_id.
	 * 
	 * @param location_id
	 *            the new location_id
	 */
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	/**
	 * Gets the latitude.
	 * 
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 * 
	 * @param latitude
	 *            the new latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude.
	 * 
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 * 
	 * @param longitude
	 *            the new longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/** The latitude. */
	@Column(name = "latitude")
	private double latitude;

	/** The longitude. */
	@Column(name = "longitude")
	private double longitude;

}
