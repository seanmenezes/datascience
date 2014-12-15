package com.sean.data.persistence.repository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sean.data.persistence.jpa.model.LatitudeLongitude;
import com.sean.data.persistence.jpa.model.LatitudeLongitude;

// TODO: Auto-generated Javadoc
/**
 * The Class LatitudeLongitudeRepository.
 * 
 * @author Sean_Menezes
 */
@Repository
public class LatitudeLongitudeRepository {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("locationservices");

	/**
	 * Find by latitude and longitude.
	 * 
	 * @param latitude
	 *            the latitude
	 * @param longtitude
	 *            the longtitude
	 * @return LatitudeLongitude
	 */
	public LatitudeLongitude findLatitudeLongitude(double latitude,
			double longitude) {

		EntityManager entityManager = null;
		Query query;

		try {

			entityManager = entityManagerFactory.createEntityManager();
			query = entityManager
					.createQuery(
							" select latitudeLongitude from LatitudeLongtitude latitudeLongitude "
									+ "where  latitudeLongitude.latitude = :latitude and  latitudeLongitude.longitude =:longitude",
							LatitudeLongitude.class);
			query.setMaxResults(1);
			query.setParameter("latitude", latitude);
			query.setParameter("longitude", longitude);
			entityManager.close();

		} catch (javax.persistence.NoResultException nre) {
			if (entityManager != null)
				entityManager.close();
			return null;
		}
		return (LatitudeLongitude) query.getSingleResult();
	}

	/**
	 * Find latitude longitude exists.
	 * 
	 * @param latitude
	 *            the latitude
	 * @param longtitude
	 *            the longtitude
	 * @return true, if successful
	 */
	public boolean findLatitudeLongitudeExists(double latitude, double longitude) {

		Query query;

		EntityManager entityManager = null;
		try {

			entityManager = entityManagerFactory.createEntityManager();
			System.out.println(" In REPO " + latitude + "In Repo " + longitude
					+ entityManager);
			System.out.println(" Entity Manager is ---> " + entityManager);

			query = entityManager
					.createQuery(
							" from LatitudeLongitude latitudeLongitude  "
									+ "where  latitudeLongitude.latitude = :latitude and latitudeLongitude.longitude =:longitude",
							LatitudeLongitude.class);

			query.setMaxResults(1);
			query.setParameter("latitude", latitude);
			query.setParameter("longitude", longitude);
			System.out.println(" Query is -->" + query.toString());
			query.getSingleResult();
			entityManager.close();

		} catch (javax.persistence.NoResultException nre) {
			if (entityManager != null)
				entityManager.close();

			return false;
		}

		return true;

	}

	public LatitudeLongitude insertLatitudeLongitude(double latitude,
			double longitude) {

		System.out.println("insertLatitude  ------> " + latitude + longitude);
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entr = entityManager.getTransaction();
			entr.begin();
			LatitudeLongitude latitudeLongitude = new LatitudeLongitude();
			latitudeLongitude.setLatitude(latitude);
			latitudeLongitude.setLongitude(longitude);
			entityManager.persist(latitudeLongitude);
			entr.commit();

			return latitudeLongitude;
		} catch (javax.persistence.PersistenceException Sqe) {
			if (entityManager != null)
				entityManager.close();
			throw Sqe;
		} finally {
			if (entityManager != null)
				entityManager.close();
		}

	}

	public List<LatitudeLongitude> findAllLatitudeLongitudeObjects() {

		EntityManager entityManager = null;
		try {

			entityManager = entityManagerFactory.createEntityManager();
			String queryString = " from LatitudeLongitude latitudeLongitude";
			Query query = entityManager.createQuery(queryString);
			List<LatitudeLongitude> resultList = Collections.EMPTY_LIST;
			if (query != null)
				resultList = query.getResultList();
			entityManager.close();

			if (resultList == null)
				return Collections.EMPTY_LIST;
			else
				return resultList;

		} catch (javax.persistence.NoResultException nre) {
			if (entityManager != null)
				entityManager.close();
			throw nre;

		}
	}

}