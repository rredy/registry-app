package com.project.conference.registryapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;

@Service
public interface AttendeeRegistryService {

	public String registerAttendee(Attendee attendee);

	public List<SessionTalk> getAttendeeTalksList(Long attendeeId);

}
