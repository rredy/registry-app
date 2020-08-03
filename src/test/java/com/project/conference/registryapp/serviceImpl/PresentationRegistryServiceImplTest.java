package com.project.conference.registryapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.conference.registryapp.dao.PresentationRegistryDao;
import com.project.conference.registryapp.model.AtendeePresenter;

@SpringBootTest
class PresentationRegistryServiceImplTest {

	@Mock
	PresentationRegistryDao presentationRegistryDaoImpl;

	@Autowired
	PresentationRegistryServiceImpl presentationRegistryServiceImpl;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testRegisterAttendee() {
		AtendeePresenter atendeePresenter = new AtendeePresenter();
		atendeePresenter.setAttendeeId(1l);
		Mockito.when(presentationRegistryDaoImpl.register(Mockito.any())).thenReturn("Success");
		assertEquals("Success", presentationRegistryServiceImpl.registerAttendee(atendeePresenter));

	}
}
