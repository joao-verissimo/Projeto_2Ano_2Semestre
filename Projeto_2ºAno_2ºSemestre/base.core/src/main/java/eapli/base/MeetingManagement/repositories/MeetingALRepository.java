package eapli.base.MeetingManagement.repositories;

import domain.model.SystemUserAuth;
import eapli.base.MeetingManagement.domain.Meeting;
import eapli.base.MeetingManagement.domain.MeetingAccessList;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface MeetingALRepository extends DomainRepository<Long, MeetingAccessList> {
    boolean verifyAndNotify(List<SystemUserAuth> users, Meeting meeting);

    MeetingAccessList alterStateA(SystemUserAuth user);

    MeetingAccessList alterStateD(SystemUserAuth user);

    List<MeetingAccessList> usersState(Meeting meet);
}
