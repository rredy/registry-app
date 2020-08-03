package com.project.conference.registryapp.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
@Api(value = "Attendee Details")
public class Attendee {

	private Long id;

	private String name;

	private String title;

	private String company;

	private List<SessionTalk> talks = new ArrayList<SessionTalk>();

	private List<SessionPresenter> presentations = new ArrayList<SessionPresenter>();

	@ApiModelProperty(notes = "Attendee Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ApiModelProperty(notes = "Attendee Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ApiModelProperty(notes = "Attendee Company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@ApiModelProperty(notes = "Attendee talks")
	public List<SessionTalk> getTalks() {
		return talks;
	}

	public void setTalks(List<SessionTalk> talks) {
		this.talks = talks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ApiModelProperty(notes = "Attendee presentations")
	public List<SessionPresenter> getPresentations() {
		return presentations;
	}

	public void setPresentations(List<SessionPresenter> presentations) {
		this.presentations = presentations;
	}

}
