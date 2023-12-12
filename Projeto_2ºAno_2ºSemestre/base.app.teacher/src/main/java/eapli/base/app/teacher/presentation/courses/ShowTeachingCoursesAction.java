package eapli.base.app.teacher.presentation.courses;

import eapli.base.app.teacher.presentation.classe.ScheduleClassUI;
import eapli.framework.actions.Action;

import javax.swing.*;

public class ShowTeachingCoursesAction implements Action {
    @Override
    public boolean execute() {
        return new ShowTeachingCoursesUI().doShow();
    }
}
