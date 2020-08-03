package com.project.conference.registryapp.daoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.conference.registryapp.dao.TalkRegistryDao;
import com.project.conference.registryapp.model.AtendeeTalk;
import com.project.conference.registryapp.model.Attendee;
import com.project.conference.registryapp.model.SessionTalk;

@Repository
public class TalkRegistryDaoImpl implements TalkRegistryDao {

	Logger log = LoggerFactory.getLogger(this.getClass());
	public static Set<SessionTalk> talkList = new HashSet<SessionTalk>();

	@Override
	public String register(AtendeeTalk attendeeTalk) {

		log.info("Registering Attendee for Session Talk");

		try {
			SessionTalk talk = new SessionTalk();

			talk.setId(attendeeTalk.getTalkId());
			talk.setLocation(attendeeTalk.getLocation());
			talk.setTime(attendeeTalk.getTime());

			AttendeeDaoImpl.attendeeList.stream().forEach(a -> {
				if (a.getId().equals(attendeeTalk.getAttendeeId())) {
					a.getTalks().add(talk);
					talk.getAttendeeList().add(a);
				}

			});
			talkList.add(talk);
		} catch (Exception e) {
			log.error("Failed to Register Attendee for Session Talk" + e.getMessage());
			return "Failure";
		}
		return "Success";
	}

	@Override
	public List<Attendee> getAttendeeList(Long talkId) {

		log.info("Getting Attendee List for Session Talk");
		List<Attendee> attendees = new ArrayList<Attendee>();
		try {
			talkList.stream().forEach(a -> {
				if (a.getId().equals(talkId))
					attendees.addAll(a.getAttendeeList());
			});
		} catch (Exception e) {
			log.error("Failed to fetch Attendee List for Session Talk" + e.getMessage());
			e.printStackTrace();
		}
		return attendees;

	}

}
