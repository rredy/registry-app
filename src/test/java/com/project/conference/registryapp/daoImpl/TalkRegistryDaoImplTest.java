package com.project.conference.registryapp.daoImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.conference.registryapp.model.AtendeeTalk;
import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;

@SpringBootTest
class TalkRegistryDaoImplTest {

	@Autowired
	TalkRegistryDaoImpl talkRegistryDaoImpl;

	List<Attendee> attendees = new ArrayList<Attendee>();

	@BeforeEach
	void setup() {
		Attendee attendee = new Attendee();
		attendee.setId(1L);
		attendee.setName("test");

		attendees.add(attendee);
	}

	@Test
	void testAttendeeRegister() {
		AtendeeTalk talk = new AtendeeTalk();
		talk.setAttendeeId(1l);
		talk.setTalkId(1l);
		String response = talkRegistryDaoImpl.register(talk);
		assertEquals("Success", response);

	}

	@Test
	void testAttendeeTalks() {
		for (SessionTalk talk : talkRegistryDaoImpl.talkList) {
			talk.setAttendeeList(attendees);
		}
		List<Attendee> response = talkRegistryDaoImpl.getAttendeeList(1l);

		assertEquals(attendees.get(0).getId(), response.get(0).getId());

	}

}
