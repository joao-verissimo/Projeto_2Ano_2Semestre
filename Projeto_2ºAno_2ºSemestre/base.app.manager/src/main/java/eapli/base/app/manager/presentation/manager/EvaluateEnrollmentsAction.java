package eapli.base.app.manager.presentation.manager;

import eapli.framework.actions.Action;

/**
 * The type Evaluate enrollments action.
 *
 * @author joaomorais
 */
public class EvaluateEnrollmentsAction implements Action {

    @Override
    public boolean execute() {
        return new EvaluateEnrollmentsUI().doShow();
    }
}
