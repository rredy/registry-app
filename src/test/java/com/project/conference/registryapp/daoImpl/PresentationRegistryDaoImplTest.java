package com.project.conference.registryapp.daoImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.conference.registryapp.model.AtendeePresenter;

@SpringBootTest
class PresentationRegistryDaoImplTest {

	@Autowired
	PresentationRegistryDaoImpl presentationRegistryDaoImpl;

	@Test
	void testAttendeeRegister() {
		AtendeePresenter presenter = new AtendeePresenter();

		presenter.setAttendeeId(1l);
		presenter.setLocation("New York");

		String response = presentationRegistryDaoImpl.register(presenter);
		assertEquals("Success", response);

	}

}
