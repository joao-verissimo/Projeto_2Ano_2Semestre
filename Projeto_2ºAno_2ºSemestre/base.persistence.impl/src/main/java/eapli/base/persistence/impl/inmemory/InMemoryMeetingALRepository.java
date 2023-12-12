package eapli.base.persistence.impl.inmemory;

import domain.model.SystemUserAuth;
import eapli.base.MeetingManagement.domain.Meeting;
import eapli.base.MeetingManagement.domain.MeetingAccessList;
import eapli.base.MeetingManagement.repositories.MeetingALRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryMeetingALRepository extends InMemoryDomainRepository<MeetingAccessList,Long> implements MeetingALRepository {
    static {
        InMemoryInitializer.init();
    }
    @Override
    public boolean verifyAndNotify(List<SystemUserAuth> users, Meeting meeting) { return false; }
    @Override
    public MeetingAccessList alterStateA(SystemUserAuth user) {return  null;}

    @Override
    public MeetingAccessList alterStateD(SystemUserAuth user) {return  null;}

    @Override
    public List<MeetingAccessList> usersState(Meeting meet){return null;}
}
