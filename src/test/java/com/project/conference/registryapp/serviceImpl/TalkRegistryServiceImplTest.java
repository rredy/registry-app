package com.project.conference.registryapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.conference.registryapp.daoImpl.TalkRegistryDaoImpl;
import com.project.conference.registryapp.model.AtendeeTalk;
import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;

@SpringBootTest
class TalkRegistryServiceImplTest {

	TalkRegistryDaoImpl talkRegistryDaoImpl;

	@Autowired
	TalkRegistryServiceImpl talkRegistryServiceImpl;

	@BeforeEach
	void setup() {

		talkRegistryDaoImpl = mock(TalkRegistryDaoImpl.class);

	}

	@Test
	void testRegisterAttendee() {
		AtendeeTalk attendeeTalk = new AtendeeTalk();
		attendeeTalk.setAttendeeId(1l);
		attendeeTalk.setTalkId(1l);
		Mockito.when(talkRegistryDaoImpl.register(Mockito.any())).thenReturn("Success");
		assertEquals("Success", talkRegistryServiceImpl.registerAttendee(attendeeTalk));

	}

	@Test
	void testAttendeeList() {
		Attendee attendee = new Attendee();
		attendee.setId(1l);
		List<Attendee> attendees = new ArrayList<Attendee>();
		SessionTalk talk = new SessionTalk();
		talk.setId(1l);
		attendees.add(attendee);
		Mockito.when(talkRegistryDaoImpl.getAttendeeList(1l)).thenReturn(attendees);
		System.out.println(talkRegistryDaoImpl.getAttendeeList(1l));
		assertEquals(Collections.EMPTY_LIST, talkRegistryServiceImpl.getAttendeeList(1l));

	}

}
