package eapli.base.app.teacher.presentation.classe;

import eapli.framework.actions.Action;

public class ShowAllClassesAction implements Action {

    @Override
    public boolean execute() {
        return new ShowAllClassesUI().show();
    }
}
