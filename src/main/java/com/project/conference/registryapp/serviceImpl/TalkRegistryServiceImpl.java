package com.project.conference.registryapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.conference.registryapp.dao.TalkRegistryDao;
import com.project.conference.registryapp.model.AtendeeTalk;
import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.service.TalkRegistryService;

@Service
public class TalkRegistryServiceImpl implements TalkRegistryService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TalkRegistryDao talkRegistryDaoImpl;

	@Override
	public String registerAttendee(AtendeeTalk attendeeTalk) {

		String response = "";

		try {
			response = talkRegistryDaoImpl.register(attendeeTalk);
		} catch (Exception e) {
			log.error("Failed to Register Attendee for Session Talk" + e.getMessage());
			throw e;
		}
		return response;
	}

	@Override
	public List<Attendee> getAttendeeList(Long talkId) {
		List<Attendee> response = new ArrayList<Attendee>();

		try {
			response = talkRegistryDaoImpl.getAttendeeList(talkId);
		} catch (Exception e) {
			log.error("Failed to fetch Attendee List for Session Talk" + e.getMessage());
			throw e;
		}
		return response;
	}

}
