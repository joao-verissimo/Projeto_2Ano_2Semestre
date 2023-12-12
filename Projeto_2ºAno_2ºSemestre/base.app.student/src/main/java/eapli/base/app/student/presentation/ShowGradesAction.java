package eapli.base.app.student.presentation;

import eapli.framework.actions.Action;

public class ShowGradesAction implements Action {

    @Override
    public boolean execute() {
        return new ShowGradesUI().show();
    }
}