package eapli.base.app.teacher.presentation;

import eapli.framework.actions.Action;

public class ListExamsGradesAction implements Action {
    @Override
    public boolean execute() {
        return new ListExamsGradesUI().doShow();
    }
}
