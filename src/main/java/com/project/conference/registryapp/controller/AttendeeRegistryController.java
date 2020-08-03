package com.project.conference.registryapp.controller;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;
import com.project.conference.registryapp.service.AttendeeRegistryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/attendee")
public class AttendeeRegistryController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AttendeeRegistryService registeryServiceImpl;

	@ApiOperation(value = "to register attendee", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping("/register")
	public String registerAttendee(@RequestBody Attendee attendee) {

		log.info("Inside Attendee register Controller...");

		Instant startTime = Instant.now();

		String response = "";

		try {
			response = registeryServiceImpl.registerAttendee(attendee);
			log.info("TIme for Execution " + Duration.between(Instant.now(), startTime).toMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@ApiOperation(value = "to register attendee", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("{attendeeId}/talks-list")
	public List<SessionTalk> getAttendeeList(@PathVariable(name = "attendeeId") Long attendeeId) {

		log.info("Inside Attendee register Controller...");
		Instant startTime = Instant.now();
		List<SessionTalk> response = new ArrayList<SessionTalk>();

		try {
			response = registeryServiceImpl.getAttendeeTalksList(attendeeId);
			log.info("TIme for Execution " + Duration.between(Instant.now(), startTime).toMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
