package eapli.base.MeetingManagement.domain;

import domain.model.SystemUserAuth;
import eapli.base.exammanagement.domain.Date;
import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.*;

/**
 * @author Jorge Lima
 */

@Entity
public class Meeting implements AggregateRoot<Long> {

    @Id
    private Long idMeeting;
    private Duration duration;
    private TimeMeeting hour;
    private Date date;

    @ManyToOne
    private SystemUserAuth creator;

    public Meeting(Long idMeeting, Duration duration, TimeMeeting hour, Date date, SystemUserAuth creator) {
        this.idMeeting = idMeeting;
        this.duration = duration;
        this.hour = hour;
        this.date = date;
        this.creator = creator;
    }

    public Long idMeeting() {
        return idMeeting;
    }

    public Duration duration() {
        return duration;
    }

    public TimeMeeting timeMeeting() {
        return hour;
    }

    public Date date() {
        return date;
    }

    protected Meeting() {
        // for ORM only
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}