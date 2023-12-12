package eapli.base.app.manager.presentation.student;

import eapli.framework.actions.Action;

/**
 * Menu action for adding a new user to the application. Created by nuno on
 * 22/03/16.
 */
public class EnrollStudentAction implements Action {

    @Override
    public boolean execute() {
        return new EnrollStudentUI().show();
    }
}