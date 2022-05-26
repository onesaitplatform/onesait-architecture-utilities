package com.minsait.onesait.architecture.utilities.services;

public interface ChronoService {

	/**
	 * Method to initialize the counter
	 * 
	 * @return Time in which the method was initialized
	 */
	public Long startTime();

	/**
	 * Method to end the counter
	 * 
	 * @param startTime - Time in which the method was initialized
	 * @return Time in which the method was finished
	 */
	public Long endTime(Long startTime);

	/**
	 * Method to end the counter
	 * 
	 * @param startTime - Time in which the method was initialized
	 * @param name      - name that want to put in trace
	 * @return Time in which the method was finished
	 */
	public Long endTime(Long startTime, String name);
}

