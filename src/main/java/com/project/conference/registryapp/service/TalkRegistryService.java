package com.project.conference.registryapp.service;

import java.util.List;

import com.project.conference.registryapp.model.AtendeeTalk;
import com.project.conference.registryapp.model.Attendee;

public interface TalkRegistryService {

	String registerAttendee(AtendeeTalk attendeeTalk);

	List<Attendee> getAttendeeList(Long talkId);

}
