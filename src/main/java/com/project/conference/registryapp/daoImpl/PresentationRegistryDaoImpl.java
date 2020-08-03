package com.project.conference.registryapp.daoImpl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.conference.registryapp.dao.PresentationRegistryDao;
import com.project.conference.registryapp.model.AtendeePresenter;
import com.project.conference.registryapp.model.SessionPresenter;

@Repository
public class PresentationRegistryDaoImpl implements PresentationRegistryDao {

	Logger log = LoggerFactory.getLogger(this.getClass());

	private static Set<SessionPresenter> presenterList = new HashSet<SessionPresenter>();

	@Override
	public String register(AtendeePresenter atendeePresenter) {
		
		log.info("Registering Attendee for Session Presentation");

		try {
			SessionPresenter presenter = new SessionPresenter();

			presenter.setId(atendeePresenter.getPresenterId());
			presenter.setLocation(atendeePresenter.getLocation());
			presenter.setTime(atendeePresenter.getTime());

			AttendeeDaoImpl.attendeeList.stream().forEach(a -> {
				if (a.getId().equals(atendeePresenter.getAttendeeId())) {
					presenter.getAttendeeList().add(a);
					a.getPresentations().add(presenter);
				}

			});
			presenterList.add(presenter);
		} catch (Exception e) {
			log.error("Failed to Register Attendee for Session Presentation" + e.getMessage());
			return "Failure";
		}
		return "Success";
	}

}
