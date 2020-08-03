package com.project.conference.registryapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.conference.registryapp.daoImpl.AttendeeDaoImpl;
import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;

@SpringBootTest
class AttendeeRegistryServiceImplTest {

	@Mock
	AttendeeDaoImpl attendeeDaoImpl;

	@Autowired
	AttendeeRegistryServiceImpl attendeeRegistryServiceImpl;

	@BeforeEach
	void setup() {

		attendeeDaoImpl = mock(AttendeeDaoImpl.class);

	}

	@Test
	void testRegisterAttendee() {
		Attendee attendee = new Attendee();
		attendee.setId(1l);
		Mockito.when(attendeeDaoImpl.register(Mockito.any())).thenReturn("Success");
		assertEquals("Success", attendeeRegistryServiceImpl.registerAttendee(attendee));

	}

	@Test
	void testattendeetalksList() {
		Attendee attendee = new Attendee();
		attendee.setId(1l);
		List<SessionTalk> response = new ArrayList<SessionTalk>();
		SessionTalk talk = new SessionTalk();
		talk.setId(1l);
		response.add(talk);
		Mockito.when(attendeeDaoImpl.getTalksList(1l)).thenReturn(response);

		assertEquals(Collections.EMPTY_LIST, attendeeRegistryServiceImpl.getAttendeeTalksList(1l));

	}

}
