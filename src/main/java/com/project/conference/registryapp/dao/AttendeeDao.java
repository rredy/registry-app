package com.project.conference.registryapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;

@Repository
public interface AttendeeDao {

	String register(Attendee attendee);

	List<SessionTalk> getTalksList(Long attendeeId);
	
	

}
