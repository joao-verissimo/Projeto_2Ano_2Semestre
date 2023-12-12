package eapli.base.app.teacher.presentation.classe;

import eapli.framework.actions.Action;

public class ShowTeacherClassesAction implements Action {
    @Override
    public boolean execute() {
        return new ShowTeacherClassesUI().show();
    }
}

