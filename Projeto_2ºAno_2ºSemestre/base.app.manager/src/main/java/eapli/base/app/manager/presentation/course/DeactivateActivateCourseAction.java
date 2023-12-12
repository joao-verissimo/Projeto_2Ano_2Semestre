package eapli.base.app.manager.presentation.course;
import eapli.framework.actions.Action;
import eapli.base.app.manager.presentation.authz.DeactivateActivateUserUI;

import javax.swing.*;

public class DeactivateActivateCourseAction implements Action {

    @Override
    public boolean execute() {
        return new DeactivateActivateCourseUI().show();
    }

}
