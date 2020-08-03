package com.project.conference.registryapp.daoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.conference.registryapp.dao.AttendeeDao;
import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;

@Repository
public class AttendeeDaoImpl implements AttendeeDao {

	Logger log = LoggerFactory.getLogger(this.getClass());

	public static Set<Attendee> attendeeList = new HashSet<Attendee>();

	@Override
	public String register(Attendee attendee) {

		log.info("Registering Attendee for Conference");
		attendeeList.add(attendee);
		return "Success";
	}

	@Override
	public List<SessionTalk> getTalksList(Long attendeeId) {
		log.info("Getting Attendee Talks List schedule");
		List<SessionTalk> talks = new ArrayList<SessionTalk>();
		try {
			attendeeList.stream().forEach(a -> {
				if (a.getId().equals(attendeeId))
					talks.addAll(a.getTalks());
			});
		} catch (Exception e) {
			log.error("Failed to fetch Attendee List for Session Talk" + e.getMessage());
			e.printStackTrace();
		}

		return talks;
	}

}
