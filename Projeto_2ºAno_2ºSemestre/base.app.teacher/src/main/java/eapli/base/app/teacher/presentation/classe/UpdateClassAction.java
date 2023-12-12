package eapli.base.app.teacher.presentation.classe;

import eapli.framework.actions.Action;

public class UpdateClassAction implements Action {
    @Override
    public boolean execute(){
        return new UpadateClassUI().doShow();
    }
}
