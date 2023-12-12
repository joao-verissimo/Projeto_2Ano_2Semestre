package eapli.base.app.student.presentation;

import javax.swing.*;
import eapli.framework.actions.Action;

public class NextExamsAction implements Action {

    @Override
    public boolean execute() {
        return new NextExamsUI().show();
    }
}
