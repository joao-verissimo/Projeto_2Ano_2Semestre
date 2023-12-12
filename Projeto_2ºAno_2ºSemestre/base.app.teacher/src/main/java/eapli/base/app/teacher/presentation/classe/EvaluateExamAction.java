package eapli.base.app.teacher.presentation.classe;
import eapli.framework.actions.Action;

public class EvaluateExamAction implements Action {
    @Override
    public boolean execute() {
        return new EvaluateUI().show();
    }

}
