package com.minsait.onesait.architecture.utilities.services.impl;

import org.springframework.stereotype.Service;

import com.minsait.onesait.architecture.utilities.services.ChronoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChronoServiceImpl implements ChronoService {

	@Override
	public Long startTime() {
		return System.currentTimeMillis();
	}

	@Override
	public Long endTime(Long startTime) {
		long endTime = System.currentTimeMillis() - startTime;
		log.debug("Execution time: {} ms", endTime);
		return endTime;
	}

	@Override
	public Long endTime(Long startTime, String name) {
		long endTime = System.currentTimeMillis() - startTime;
		log.debug(name + ": {} ms", endTime);
		return endTime;
	}
}

