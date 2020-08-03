package com.project.conference.registryapp.model;

import java.sql.Timestamp;

public class AtendeeTalk {

	private Long attendeeId;

	private Long talkId;

	private Timestamp time = new Timestamp(System.currentTimeMillis());

	private String location;

	public Long getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(Long attendeeId) {
		this.attendeeId = attendeeId;
	}

	public Long getTalkId() {
		return talkId;
	}

	public void setTalkId(Long talkId) {
		this.talkId = talkId;
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

}
