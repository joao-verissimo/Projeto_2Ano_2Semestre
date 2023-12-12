package eapli.base.MeetingManagement.domain;

import domain.model.*;
import eapli.base.exammanagement.domain.Date;
import eapli.base.usermanagement.domain.BaseRoles;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class MeetingAccessListTest {
    private static SystemUserAuth dummyUser(final String username, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy").withRoles(roles).build();
    }
    private SystemUserAuth getNewDummyUser() {
        return dummyUser("dummy@gmail.com", BaseRoles.ADMIN);
    }

    private MeetingAccessList createMal() {
        Duration duration = new Duration("02:30");
        TimeMeeting timeMeeting = new TimeMeeting("10:30");
        Date date = new Date("2023-05-05");
        InviteState inviteState = InviteState.Sent;
        Meeting meeting = new Meeting(1l, duration, timeMeeting, date, getNewDummyUser());
        return new MeetingAccessList(getNewDummyUser(),inviteState,meeting);
    }

    @Test
    void getters() {
        MeetingAccessList a = createMal();
        assertEquals(1l, a.meeting().idMeeting().longValue());
        assertEquals(a.user().email().toString(), "dummy@gmail.com");
        assertEquals(a.inviteState(), InviteState.Sent);
    }

    @Test
    void setters() {
        MeetingAccessList a = createMal();
        a.setInviteState(InviteState.Accepted);
        assertEquals(a.inviteState(), InviteState.Accepted);
    }
}