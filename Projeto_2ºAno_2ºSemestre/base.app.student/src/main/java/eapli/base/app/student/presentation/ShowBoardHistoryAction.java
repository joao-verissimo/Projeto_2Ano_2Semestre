package eapli.base.app.student.presentation;

import eapli.framework.actions.Action;

public class ShowBoardHistoryAction implements Action {
    @Override
    public boolean execute() {
        return new ShowBoardHistoryUI().doShow();
    }

}
