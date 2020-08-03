package com.project.conference.registryapp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.conference.registryapp.dao.PresentationRegistryDao;
import com.project.conference.registryapp.model.AtendeePresenter;
import com.project.conference.registryapp.service.PresentationRegistryService;

@Service
public class PresentationRegistryServiceImpl implements PresentationRegistryService {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PresentationRegistryDao presentationRegistryDaoImpl;

	@Override
	public String registerAttendee(AtendeePresenter atendeePresenter) {

		String response = "";

		try {
			response = presentationRegistryDaoImpl.register(atendeePresenter);
		} catch (Exception e) {
			log.error("Failed to Register Attendee for Session Presentation" + e.getMessage());
			throw e;
		}
		return response;
	}
}
