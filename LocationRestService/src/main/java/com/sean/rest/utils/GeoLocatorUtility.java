package com.sean.rest.utils;

import java.util.HashMap;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class GeoLocatorUtility.
 * 
 * @author seanmenezes
 */
public class GeoLocatorUtility {

	/** The Constant unitedStatesMap. */
	private final static HashMap<String, State> unitedStatesMap = new HashMap(
			50);

	/**
	 * The Constant cityMap.
	 * 
	 * Static intializer to hold State coordinates and City coordinates
	 * 
	 * 
	 * */
	private final static HashMap<String, City> cityMap = new HashMap(50);

	static {
		State tempState;
		City tempCity;
		LatitudeLongitudeVo tempLatLongVo;

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.ALABAMA);
		tempState.setNORTH(35.00);
		tempState.setSOUTH(30.13);
		tempState.setEAST(-84.51);
		tempState.setWEST(-88.28);
		unitedStatesMap.put(ApplicationMessagesConstants.ALABAMA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.ALASKA);
		tempState.setNORTH(71.50);
		tempState.setSOUTH(54.40);
		tempState.setEAST(-130.00);
		tempState.setWEST(-173.28);
		unitedStatesMap.put(ApplicationMessagesConstants.ALASKA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.CALIFORNIA);
		tempState.setNORTH(42.00);
		tempState.setSOUTH(32.30);
		tempState.setEAST(-114.80);
		tempState.setWEST(-124.24);
		unitedStatesMap.put(ApplicationMessagesConstants.CALIFORNIA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.COLORADO);
		tempState.setNORTH(41.00);
		tempState.setSOUTH(37.00);
		tempState.setEAST(-102.80);
		tempState.setWEST(-109.00);
		unitedStatesMap.put(ApplicationMessagesConstants.COLORADO, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.CONNECTICUT);
		tempState.setNORTH(42.30);
		tempState.setSOUTH(40.58);
		tempState.setEAST(-71.47);
		tempState.setWEST(-73.44);
		unitedStatesMap
				.put(ApplicationMessagesConstants.CONNECTICUT, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.DELAWARE);
		tempState.setNORTH(39.50);
		tempState.setSOUTH(38.27);
		tempState.setEAST(-72.20);
		tempState.setWEST(-75.47);
		unitedStatesMap.put(ApplicationMessagesConstants.DELAWARE, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.FLORIDA);
		tempState.setNORTH(31.00);
		tempState.setSOUTH(24.30);
		tempState.setEAST(-79.48);
		tempState.setWEST(-87.38);
		unitedStatesMap.put(ApplicationMessagesConstants.FLORIDA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.GEORGIA);
		tempState.setNORTH(35.00);
		tempState.setSOUTH(30.31);
		tempState.setEAST(-81.00);
		tempState.setWEST(-85.53);
		unitedStatesMap.put(ApplicationMessagesConstants.GEORGIA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.HAWAII);
		tempState.setNORTH(23.00);
		tempState.setSOUTH(16.55);
		tempState.setEAST(-154.40);
		tempState.setWEST(-162.00);
		unitedStatesMap.put(ApplicationMessagesConstants.HAWAII, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.IDAHO);
		tempState.setNORTH(49.00);
		tempState.setSOUTH(42.55);
		tempState.setEAST(-111.40);
		tempState.setWEST(-117.00);
		unitedStatesMap.put(ApplicationMessagesConstants.IDAHO, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.ILLINOIS);
		tempState.setNORTH(42.30);
		tempState.setSOUTH(36.58);
		tempState.setEAST(-87.30);
		tempState.setWEST(-91.30);
		unitedStatesMap.put(ApplicationMessagesConstants.ILLINOIS, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.INDIANA);
		tempState.setNORTH(41.46);
		tempState.setSOUTH(37.47);
		tempState.setEAST(-84.49);
		tempState.setWEST(-88.40);
		unitedStatesMap.put(ApplicationMessagesConstants.INDIANA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.IOWA);
		tempState.setNORTH(43.30);
		tempState.setSOUTH(40.36);
		tempState.setEAST(-89.50);
		tempState.setWEST(-96.31);
		unitedStatesMap.put(ApplicationMessagesConstants.IOWA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.KANSAS);
		tempState.setNORTH(40.00);
		tempState.setSOUTH(37.00);
		tempState.setEAST(-94.38);
		tempState.setWEST(-102.01);
		unitedStatesMap.put(ApplicationMessagesConstants.KANSAS, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.KENTUCKY);
		tempState.setNORTH(39.90);
		tempState.setSOUTH(36.30);
		tempState.setEAST(-81.58);
		tempState.setWEST(-89.34);
		unitedStatesMap.put(ApplicationMessagesConstants.KENTUCKY, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.LOUISIANA);
		tempState.setNORTH(33.00);
		tempState.setSOUTH(29.00);
		tempState.setEAST(-89.00);
		tempState.setWEST(-94.00);
		unitedStatesMap.put(ApplicationMessagesConstants.LOUISIANA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.MAINE);
		tempState.setNORTH(47.28);
		tempState.setSOUTH(43.04);
		tempState.setWEST(-71.01);
		tempState.setEAST(-66.57);
		unitedStatesMap.put(ApplicationMessagesConstants.MAINE, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.MARYLAND);
		tempState.setNORTH(39.43);
		tempState.setSOUTH(37.53);
		tempState.setWEST(-79.33);
		tempState.setEAST(-75.04);
		unitedStatesMap.put(ApplicationMessagesConstants.MARYLAND, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.MASSACHUSETTS);
		tempState.setNORTH(42.53);
		tempState.setSOUTH(41.10);
		tempState.setWEST(-73.30);
		tempState.setEAST(-69.57);
		unitedStatesMap.put(ApplicationMessagesConstants.MASSACHUSETTS,
				tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.MICHIGAN);
		tempState.setNORTH(47.30);
		tempState.setSOUTH(41.41);
		tempState.setWEST(-90.31);
		tempState.setEAST(-82.26);
		unitedStatesMap.put(ApplicationMessagesConstants.MICHIGAN, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.MINNESOTA);
		tempState.setNORTH(49.23);
		tempState.setSOUTH(43.34);
		tempState.setWEST(-97.12);
		tempState.setEAST(-89.34);
		unitedStatesMap.put(ApplicationMessagesConstants.MINNESOTA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.MISSISSIPI);
		tempState.setNORTH(35.00);
		tempState.setSOUTH(30.13);
		tempState.setWEST(-91.41);
		tempState.setEAST(-88.07);
		unitedStatesMap.put(ApplicationMessagesConstants.MISSISSIPI, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.MISSOURI);
		tempState.setNORTH(40.35);
		tempState.setSOUTH(36.00);
		tempState.setWEST(-95.42);
		tempState.setEAST(-89.06);
		unitedStatesMap.put(ApplicationMessagesConstants.MISSOURI, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.MONTANA);
		tempState.setNORTH(49.00);
		tempState.setSOUTH(44.26);
		tempState.setWEST(-116.02);
		tempState.setEAST(-104.02);
		unitedStatesMap.put(ApplicationMessagesConstants.MONTANA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.NEBRASKA);
		tempState.setNORTH(43.00);
		tempState.setSOUTH(40.00);
		tempState.setWEST(-104.00);
		tempState.setEAST(-95.25);
		unitedStatesMap.put(ApplicationMessagesConstants.NEBRASKA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.NEVADA);
		tempState.setNORTH(42.00);
		tempState.setSOUTH(35.00);
		tempState.setWEST(-120.00);
		tempState.setEAST(-114.00);
		unitedStatesMap.put(ApplicationMessagesConstants.NEVADA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.NEW_HAMPSHIRE);
		tempState.setNORTH(45.18);
		tempState.setSOUTH(42.40);
		tempState.setWEST(-72.37);
		tempState.setEAST(-70.37);
		unitedStatesMap.put(ApplicationMessagesConstants.NEW_HAMPSHIRE,
				tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.NEW_JERSEY);
		tempState.setNORTH(41.21);
		tempState.setSOUTH(38.55);
		tempState.setWEST(-75.35);
		tempState.setEAST(-73.53);
		unitedStatesMap.put(ApplicationMessagesConstants.NEW_JERSEY, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.NEW_MEXICO);
		tempState.setNORTH(37.00);
		tempState.setSOUTH(31.20);
		tempState.setWEST(-109.00);
		tempState.setEAST(-103.00);
		unitedStatesMap.put(ApplicationMessagesConstants.NEW_MEXICO, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.NEW_YORK);
		tempState.setNORTH(45.00);
		tempState.setSOUTH(40.29);
		tempState.setWEST(-79.45);
		tempState.setEAST(-71.47);
		unitedStatesMap.put(ApplicationMessagesConstants.NEW_YORK, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.NEW_CAROLINA);
		tempState.setNORTH(36.21);
		tempState.setSOUTH(34.00);
		tempState.setWEST(-84.15);
		tempState.setEAST(-75.30);
		unitedStatesMap.put(ApplicationMessagesConstants.NEW_CAROLINA,
				tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.NEW_DAKOTA);
		tempState.setNORTH(49.00);
		tempState.setSOUTH(45.55);
		tempState.setWEST(-104.00);
		tempState.setEAST(-97.00);
		unitedStatesMap.put(ApplicationMessagesConstants.NEW_DAKOTA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.OHIO);
		tempState.setNORTH(41.58);
		tempState.setSOUTH(38.27);
		tempState.setWEST(-84.49);
		tempState.setEAST(-80.32);
		unitedStatesMap.put(ApplicationMessagesConstants.OHIO, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.OKLAHOMA);
		tempState.setNORTH(37.00);
		tempState.setSOUTH(33.35);
		tempState.setWEST(-103.00);
		tempState.setEAST(-94.29);
		unitedStatesMap.put(ApplicationMessagesConstants.OKLAHOMA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.OREGON);
		tempState.setNORTH(46.15);
		tempState.setSOUTH(42.00);
		tempState.setWEST(-124.30);
		tempState.setEAST(-116.45);
		unitedStatesMap.put(ApplicationMessagesConstants.OREGON, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.PENNSYLVANIA);
		tempState.setNORTH(42.00);
		tempState.setSOUTH(39.43);
		tempState.setWEST(-80.31);
		tempState.setEAST(-74.43);
		unitedStatesMap.put(ApplicationMessagesConstants.PENNSYLVANIA,
				tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.RHODE_ISLAND);
		tempState.setNORTH(42.01);
		tempState.setSOUTH(41.18);
		tempState.setWEST(-71.53);
		tempState.setEAST(-71.08);
		unitedStatesMap.put(ApplicationMessagesConstants.RHODE_ISLAND,
				tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.SOUTH_CAROLINA);
		tempState.setNORTH(35.12);
		tempState.setSOUTH(32.04);
		tempState.setWEST(-83.20);
		tempState.setEAST(-78.30);
		unitedStatesMap.put(ApplicationMessagesConstants.SOUTH_CAROLINA,
				tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.SOUTH_DAKOTA);
		tempState.setNORTH(45.56);
		tempState.setSOUTH(42.29);
		tempState.setWEST(-104.03);
		tempState.setEAST(-98.28);
		unitedStatesMap.put(ApplicationMessagesConstants.SOUTH_DAKOTA,
				tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.TENNESSEE);
		tempState.setNORTH(36.41);
		tempState.setSOUTH(35.00);
		tempState.setWEST(-90.28);
		tempState.setEAST(-81.37);
		unitedStatesMap.put(ApplicationMessagesConstants.TENNESSEE, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.TEXAS);
		tempState.setNORTH(36.30);
		tempState.setSOUTH(25.50);
		tempState.setWEST(-106.38);
		tempState.setEAST(-93.31);
		unitedStatesMap.put(ApplicationMessagesConstants.TEXAS, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.UTAH);
		tempState.setNORTH(42.00);
		tempState.setSOUTH(37.00);
		tempState.setWEST(-114.00);
		tempState.setEAST(-109.00);
		unitedStatesMap.put(ApplicationMessagesConstants.UTAH, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.VERMONT);
		tempState.setNORTH(45.00);
		tempState.setSOUTH(42.44);
		tempState.setWEST(-73.26);
		tempState.setEAST(-71.28);
		unitedStatesMap.put(ApplicationMessagesConstants.VERMONT, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.VIRGINIA);
		tempState.setNORTH(39.37);
		tempState.setSOUTH(36.31);
		tempState.setWEST(-83.37);
		tempState.setEAST(-75.13);
		unitedStatesMap.put(ApplicationMessagesConstants.VIRGINIA, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.WASHINGTON);
		tempState.setNORTH(49.00);
		tempState.setSOUTH(45.32);
		tempState.setWEST(-124.48);
		tempState.setEAST(-116.57);
		unitedStatesMap.put(ApplicationMessagesConstants.WASHINGTON, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.WEST_VIRGINIA);
		tempState.setNORTH(40.40);
		tempState.setSOUTH(37.10);
		tempState.setWEST(-82.40);
		tempState.setEAST(-77.40);
		unitedStatesMap.put(ApplicationMessagesConstants.WEST_VIRGINIA,
				tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.WISCONSIN);
		tempState.setNORTH(47.03);
		tempState.setSOUTH(42.30);
		tempState.setWEST(-92.54);
		tempState.setEAST(-77.40);
		unitedStatesMap.put(ApplicationMessagesConstants.WISCONSIN, tempState);

		tempState = new State();
		tempState.setName(ApplicationMessagesConstants.WYOMING);
		tempState.setNORTH(45.00);
		tempState.setSOUTH(41.00);
		tempState.setWEST(-111.03);
		tempState.setEAST(-104.03);
		unitedStatesMap.put(ApplicationMessagesConstants.WYOMING, tempState);

		tempCity = new City();
		tempCity.setLatitude(35.41);
		tempCity.setLongitude(139.42);
		tempCity.setName(ApplicationMessagesConstants.TOKYO);
		tempCity.setCountry(ApplicationMessagesConstants.JAPAN);
		cityMap.put(ApplicationMessagesConstants.TOKYO, tempCity);

		tempCity = new City();
		tempCity.setLatitude(-33.52);
		tempCity.setLongitude(151.12);
		tempCity.setName(ApplicationMessagesConstants.SYDNEY);
		tempCity.setCountry(ApplicationMessagesConstants.AUSTRALIA);
		cityMap.put(ApplicationMessagesConstants.SYDNEY, tempCity);

		tempCity = new City();
		tempCity.setLatitude(24.63);
		tempCity.setLongitude(46.71);
		tempCity.setName(ApplicationMessagesConstants.RIYADH);
		tempCity.setCountry(ApplicationMessagesConstants.SAUDI_ARABIA);
		cityMap.put(ApplicationMessagesConstants.RIYADH, tempCity);

		tempCity = new City();
		tempCity.setLatitude(47.36);
		tempCity.setLongitude(8.53);
		tempCity.setName(ApplicationMessagesConstants.ZURICH);
		tempCity.setCountry(ApplicationMessagesConstants.SWITZERLAND);
		cityMap.put(ApplicationMessagesConstants.ZURICH, tempCity);

		tempCity = new City();
		tempCity.setLatitude(64.13);
		tempCity.setLongitude(-21.93);
		tempCity.setName(ApplicationMessagesConstants.REYKJAVIK);
		tempCity.setCountry(ApplicationMessagesConstants.ICELAND);
		cityMap.put(ApplicationMessagesConstants.REYKJAVIK, tempCity);

		tempCity = new City();
		tempCity.setLatitude(19.43);
		tempCity.setLongitude(-99.13);
		tempCity.setName(ApplicationMessagesConstants.MEXICO_CITY);
		tempCity.setCountry(ApplicationMessagesConstants.MEXICO);
		cityMap.put(ApplicationMessagesConstants.MEXICO_CITY, tempCity);

		tempCity = new City();
		tempCity.setLatitude(-12.04);
		tempCity.setLongitude(-77.04);
		tempCity.setName(ApplicationMessagesConstants.LIMA);
		tempCity.setCountry(ApplicationMessagesConstants.PERU);
		cityMap.put(ApplicationMessagesConstants.LIMA, tempCity);

	}

	/**
	 * Check if coordinates in usa.
	 * 
	 * @param paramLatitude
	 *            the param latitude
	 * @param paramLongitude
	 *            the param longitude
	 * @return the string
	 */
	public static String checkIfCoordinatesInUSA(double paramLatitude,
			double paramLongitude) {

		State tempStateVar;

		for (String key : unitedStatesMap.keySet()) {

			tempStateVar = unitedStatesMap.get(key);

			if (paramLatitude <= tempStateVar.getNORTH()
					&& paramLatitude >= tempStateVar.getSOUTH()
					&& paramLongitude <= tempStateVar.getEAST()
					&& paramLongitude >= tempStateVar.getWEST()) {
				return tempStateVar.getName();
			}

		}

		return ApplicationMessagesConstants.NOT_IN_UNITED_STATES_OF_AMERICA;

	}

	/**
	 * Check distance to nearest city.
	 * 
	 * @param paramLatitude
	 *            the param latitude
	 * @param paramLongitude
	 *            the param longitude
	 * @return the hash map
	 */
	public static HashMap<String, String> checkDistanceToNearestCity(
			double paramLatitude, double paramLongitude) {
		City tempCityVar;
		double distance;
		HashMap<String, String> varMap = new HashMap(2);

		for (String key : cityMap.keySet()) {

			tempCityVar = cityMap.get(key);
			distance = calculateDistance(paramLatitude, paramLongitude,
					tempCityVar.getLatitude(), tempCityVar.getLongitude());
System.out.println("distance"+distance);
			if (Math.abs(distance) <= 500.00) {
				
System.out.println(distance+" < = 500");
				varMap.put(ApplicationMessagesConstants.NEAREST_CITY,
						tempCityVar.getName());
				varMap.put(ApplicationMessagesConstants.DISTANCE,
						String.valueOf(distance));
				return varMap;
			}

		}
		return varMap;
	}

	/**
	 * Calculate distance.
	 * 
	 * @param latitude1
	 *            the latitude1
	 * @param longitude1
	 *            the longitude1
	 * @param latitude2
	 *            the latitude2
	 * @param longitude2
	 *            the longitude2
	 * @return the double
	 */
	public static double calculateDistance(double latitude1, double longitude1,
			double latitude2, double longitude2) {
        
		latitude1 = Math.toRadians(latitude1);
		longitude1 = Math.toRadians(longitude1);

		latitude2 = Math.toRadians(latitude2);
		longitude2 = Math.toRadians(longitude2);

		double sec1 = Math.sin(latitude1) * Math.sin(latitude2);
		double distance1 = Math.abs(longitude1 - longitude2);
		double sec2 = Math.cos(latitude1) * Math.cos(latitude2);
		// sec1,sec2,dl are in degree, need to convert to radians
		double centralAngle = Math.acos(sec1 + sec2 * Math.cos(distance1));
		// Radius of Earth: 6378.1 kilometers
		double distance = centralAngle * 6378.1;

		// convert to miles
		distance = distance / 1.60934;
		System.out.println("The distance is " + distance + " miles.");

		return distance;

	}

}
