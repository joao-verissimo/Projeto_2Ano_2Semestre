package eapli.base.app.student.presentation;

import eapli.framework.actions.Action;

public class EvaluateMeetingsAction implements Action {

    @Override
    public boolean execute() {
        return new EvaluateMeetingsUI().doShow();
    }

}
