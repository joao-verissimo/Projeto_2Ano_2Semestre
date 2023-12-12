package eapli.base.app.manager.presentation.teacher;
import eapli.framework.actions.Action;


public class SetTeacherAction implements Action {
    @Override
    public boolean execute() {
        return new SetTeachersUI().show();
    }

}
