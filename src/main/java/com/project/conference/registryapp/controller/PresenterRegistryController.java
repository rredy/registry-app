package com.project.conference.registryapp.controller;

import java.time.Duration;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.conference.registryapp.model.AtendeePresenter;
import com.project.conference.registryapp.service.PresentationRegistryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/presentation")
public class PresenterRegistryController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PresentationRegistryService presentationRegistryServiceImpl;

	@ApiOperation(value = "to register attendee", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/register")
	public String registerAttendee(@RequestBody AtendeePresenter atendeePresenter) {

		log.info("Inside PresenterRegistryController...");

		Instant startTime = Instant.now();
		String response = "";

		try {
			response = presentationRegistryServiceImpl.registerAttendee(atendeePresenter);
			log.info("TIme for Execution " + Duration.between(Instant.now(), startTime).toMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}
}