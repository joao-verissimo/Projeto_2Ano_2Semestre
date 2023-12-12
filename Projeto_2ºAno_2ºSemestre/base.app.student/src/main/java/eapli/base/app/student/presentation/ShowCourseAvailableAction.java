package eapli.base.app.student.presentation;

import eapli.framework.actions.Action;

public class ShowCourseAvailableAction implements Action {

    @Override
    public boolean execute() {
        return new ShowCoursesAvailableUI().doShow();
    }
}
