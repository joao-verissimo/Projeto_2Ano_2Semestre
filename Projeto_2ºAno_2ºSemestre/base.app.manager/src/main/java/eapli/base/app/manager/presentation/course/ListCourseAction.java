
package eapli.base.app.manager.presentation.course;

import eapli.framework.actions.Action;

public class ListCourseAction implements Action {

    @Override
    public boolean execute() {
        return new ShowAllCoursesUI().show();
    }
}
