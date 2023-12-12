package eapli.base.app.teacher.presentation;

import eapli.framework.actions.Action;

public class ShowBoardHistoryAction implements Action {
    @Override
    public boolean execute() {
        return new ShowBoardHistoryUI().doShow();
    }

}
