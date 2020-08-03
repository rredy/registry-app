package com.project.conference.registryapp.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
@Api(value = "Session Presentation Details")
public class SessionPresenter {

	private Long id;

	private Timestamp time;

	private List<Attendee> attendeeList = new ArrayList<Attendee>();;

	private String location;

	@ApiModelProperty(notes = "The Time of the Talk")
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@ApiModelProperty(notes = "The Location of the talk")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@ApiModelProperty(notes = "The Attendeelist of the presentation")
	public List<Attendee> getAttendeeList() {
		return attendeeList;
	}

	public void setAttendeeList(List<Attendee> attendeeList) {
		this.attendeeList = attendeeList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
