package com.project.conference.registryapp.model;

import java.sql.Timestamp;

public class AtendeePresenter {

	private Long attendeeId;

	private Long presenterId;

	private Timestamp time = new Timestamp(System.currentTimeMillis());

	private String location;

	public Long getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(Long attendeeId) {
		this.attendeeId = attendeeId;
	}


	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getPresenterId() {
		return presenterId;
	}

	public void setPresenterId(Long presenterId) {
		this.presenterId = presenterId;
	}

}
