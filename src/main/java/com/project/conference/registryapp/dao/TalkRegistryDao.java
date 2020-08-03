package com.project.conference.registryapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.conference.registryapp.model.AtendeeTalk;
import com.project.conference.registryapp.model.Attendee;

@Repository
public interface TalkRegistryDao {

	String register(AtendeeTalk attendeeTalk);

	List<Attendee> getAttendeeList(Long talkId);

}
