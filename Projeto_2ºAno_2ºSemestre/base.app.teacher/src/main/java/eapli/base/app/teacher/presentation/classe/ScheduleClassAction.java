package eapli.base.app.teacher.presentation.classe;

import eapli.framework.actions.Action;

/**
 * Menu action for adding a new user to the application. Created by nuno on
 * 22/03/16.
 */
public class ScheduleClassAction implements Action {

    @Override
    public boolean execute() {
        return new ScheduleClassUI().show();
    }
}