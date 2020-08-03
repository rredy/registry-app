package com.project.conference.registryapp.daoImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;

@SpringBootTest
class AttendeeDaoImplTest {

	@Autowired
	AttendeeDaoImpl attendeeDaoImpl;

	List<SessionTalk> talks = new ArrayList<SessionTalk>();

	@BeforeEach
	void setup() {
		SessionTalk talk = new SessionTalk();
		talk.setId(1l);
		talks.add(talk);

	}

	@Test
	void testAttendeeRegister() {
		Attendee attendee = new Attendee();
		attendee.setId(1L);
		attendee.setName("test");
		attendee.setTalks(talks);
		String response = attendeeDaoImpl.register(attendee);
		assertEquals("Success", response);

	}

	@Test
	void testAttendeeTalks() {
		List<SessionTalk> response = attendeeDaoImpl.getTalksList(1L);
		assertEquals(talks.get(0).getId(), response.get(0).getId());

	}

}
