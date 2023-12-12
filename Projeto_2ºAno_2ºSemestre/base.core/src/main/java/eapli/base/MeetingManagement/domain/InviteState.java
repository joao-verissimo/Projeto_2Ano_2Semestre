package eapli.base.MeetingManagement.domain;

import eapli.framework.domain.model.ValueObject;

public enum InviteState implements ValueObject {
    /**
     * Waiting state.
     */
    Occupied,
    /**
     * Accepted state.
     */
    Sent,
    /**
     * Denied state.
     */
    Denied,
    /**
     * Accepted state.
     */
    Accepted

}
