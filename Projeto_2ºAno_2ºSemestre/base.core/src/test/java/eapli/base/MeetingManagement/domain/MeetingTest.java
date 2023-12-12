package eapli.base.MeetingManagement.domain;

import domain.model.*;
import eapli.base.exammanagement.domain.Date;
import eapli.base.usermanagement.domain.BaseRoles;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

class MeetingTest {
    private static SystemUserAuth dummyUser(final String username, final Role... roles) {
        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy").withRoles(roles).build();
    }
    private SystemUserAuth getNewDummyUser() {
        return dummyUser("dummy@gmail.com", BaseRoles.ADMIN);
    }

    @Test
    void getters() {
        Duration duration = new Duration("01:30");
        TimeMeeting timeMeeting = new TimeMeeting("11:30");
        Date date = new Date("2023-05-06");
        Meeting a = new Meeting(1l, duration, timeMeeting, date, getNewDummyUser());
        assertEquals(1l, a.idMeeting().longValue());
        assertEquals(a.duration(), duration);
        assertEquals(a.timeMeeting(), timeMeeting);
        assertEquals(a.date(), date);

    }
}