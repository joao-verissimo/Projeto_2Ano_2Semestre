package eapli.base.app.manager.presentation;

import eapli.framework.actions.Action;

public class EvaluateMeetingsAction implements Action {

    @Override
    public boolean execute() {
        return new EvaluateMeetingsUI().doShow();
    }

}
