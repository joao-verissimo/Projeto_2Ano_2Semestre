package eapli.base.app.teacher.presentation;

import eapli.framework.actions.Action;

public class AddQuestionsAction implements Action {
    @Override
    public boolean execute() {
        return new AddQuestionsUI().show();
    }
}
