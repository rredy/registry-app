package com.project.conference.registryapp.dao;

import org.springframework.stereotype.Repository;

import com.project.conference.registryapp.model.AtendeePresenter;

@Repository
public interface PresentationRegistryDao {

	String register(AtendeePresenter attendeePresenter);

}
