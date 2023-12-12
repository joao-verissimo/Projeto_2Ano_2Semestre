package eapli.base.persistence.impl.jpa;

import domain.model.SystemUserAuth;
import eapli.base.Application;
import eapli.base.MeetingManagement.domain.InviteState;
import eapli.base.MeetingManagement.domain.Meeting;
import eapli.base.MeetingManagement.domain.MeetingAccessList;
import eapli.base.MeetingManagement.repositories.MeetingALRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JpaMeetingALRepository extends JpaAutoTxRepository<MeetingAccessList, Long, Long> implements MeetingALRepository {
    public JpaMeetingALRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaMeetingALRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public boolean verifyAndNotify(List<SystemUserAuth> users, Meeting meeting) {
        try {
            LocalTime sumA, sumB, hourA, hourB, durationA, durationB;
            List<Meeting> list;
            MeetingAccessList mal;
            for (SystemUserAuth user : users) {
                list = createQuery("SELECT m FROM MeetingAccessList mal, Meeting m WHERE m.idMeeting = mal.meeting AND mal.user = '" + user.email() + "' AND m.date = '" + meeting.date() + "'", Meeting.class).getResultList();
                if(!list.isEmpty()){
                    for (Meeting l : list) {
                        hourA = LocalTime.parse(meeting.timeMeeting().timeMeeting(), DateTimeFormatter.ofPattern("HH:mm"));
                        hourB = LocalTime.parse(l.timeMeeting().timeMeeting(), DateTimeFormatter.ofPattern("HH:mm"));

                        durationA = LocalTime.parse(meeting.duration().duration(), DateTimeFormatter.ofPattern("HH:mm"));
                        durationB = LocalTime.parse(l.duration().duration(), DateTimeFormatter.ofPattern("HH:mm"));

                        sumA = hourA.plusHours(durationA.getHour()).plusMinutes(durationA.getMinute());
                        sumB = hourB.plusHours(durationB.getHour()).plusMinutes(durationB.getMinute());

                        if (hourA.compareTo(hourB) == 0 || (sumA.compareTo(hourB) > 0 && sumA.compareTo(sumB) < 0) || (hourA.compareTo(hourB) < 0 && sumA.compareTo(sumB) > 0) || (hourA.compareTo(hourB) > 0 && hourA.compareTo(sumB) < 0)) {
                            mal = new MeetingAccessList(user, InviteState.Occupied, meeting);
                            this.repo.save(mal);
                        } else {
                            mal = new MeetingAccessList(user, InviteState.Sent, meeting);
                            this.repo.save(mal);
                        }
                    }
                }else {
                    mal = new MeetingAccessList(user, InviteState.Sent, meeting);
                    this.repo.save(mal);
                }
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public List<MeetingAccessList> findAll() {
        return createQuery("SELECT m FROM MeetingAccessList m", MeetingAccessList.class).getResultList();
    }

    @Override
    public MeetingAccessList alterStateA(SystemUserAuth user) {
        List<MeetingAccessList> list = findAll();
        for (MeetingAccessList meetingAL : list) {
            if (meetingAL.user().email().equals(user.email())) {
                meetingAL.setInviteState(InviteState.Accepted);
                return meetingAL;
            }
        }
        return null;
    }

    @Override
    public MeetingAccessList alterStateD(SystemUserAuth user) {
        List<MeetingAccessList> list = findAll();
        for (MeetingAccessList meetingAL : list) {
            if (meetingAL.user().email().equals(user.email())) {
                meetingAL.setInviteState(InviteState.Denied);
                return meetingAL;
            }
        }
        return null;
    }

    @Override
    public List<MeetingAccessList> usersState(Meeting meet){
        String query = "SELECT m FROM MeetingAccessList m WHERE m.meeting = " + meet.idMeeting();
        List<MeetingAccessList> result = entityManager().createQuery(query, MeetingAccessList.class).getResultList();
        return result;
    }
}