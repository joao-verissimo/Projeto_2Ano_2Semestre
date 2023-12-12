package eapli.base.app.student.presentation;

import eapli.framework.actions.Action;

/**
 * The type Request enrollment action.
 *
 * @author joaomorais
 */
public class RequestEnrollmentAction implements Action {

    @Override
    public boolean execute() {
        return new RequestEnrollmentUI().doShow();
    }
}
