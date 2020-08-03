package com.project.conference.registryapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.conference.registryapp.dao.AttendeeDao;
import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;
import com.project.conference.registryapp.service.AttendeeRegistryService;

@Service
public class AttendeeRegistryServiceImpl implements AttendeeRegistryService {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	AttendeeDao attendeeDaoImpl;

	@Override
	public String registerAttendee(Attendee attendee) {

		String response = "";

		try {
			response = attendeeDaoImpl.register(attendee);
		} catch (Exception e) {
			log.error("Failed Registering Attendee for Conference" + e.getMessage());
			throw e;
		}
		return response;
	}

	@Override
	public List<SessionTalk> getAttendeeTalksList(Long attendeeId) {

		List<SessionTalk> response = new ArrayList<SessionTalk>();

		try {
			response = attendeeDaoImpl.getTalksList(attendeeId);
		} catch (Exception e) {
			log.error("Failed to fetch Attendee List for Session Talk" + e.getMessage());
			throw e;
		}
		return response;
	}

}
