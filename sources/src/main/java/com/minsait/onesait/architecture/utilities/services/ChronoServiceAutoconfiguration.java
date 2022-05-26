package com.minsait.onesait.architecture.utilities.services;

import org.springframework.context.annotation.Import;

import com.minsait.onesait.architecture.utilities.services.aop.ChronometedAspect;
import com.minsait.onesait.architecture.utilities.services.impl.ChronoServiceImpl;

@Import({ ChronoServiceImpl.class, ChronometedAspect.class })
public class ChronoServiceAutoconfiguration {

}
