package eapli.base.app.teacher.presentation.classe;
import eapli.base.classmanagement.application.ScheduleExtraClassController;
import eapli.base.classmanagement.application.ShowAllClassesControler;
import eapli.base.classmanagement.application.ShowTeacherClassesController;
import eapli.base.classmanagement.application.ShowTeacherExtraClassesController;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.ExtraClass;

public class ShowTeacherClassesUI {

    ShowTeacherClassesController controler = new ShowTeacherClassesController();
    ShowTeacherExtraClassesController extraClassController = new ShowTeacherExtraClassesController();

    public boolean  show() {
        System.out.println("Regular Classes:");
        Iterable<Class> classes = controler.listTeacherClasses();
        if(classes.iterator().hasNext()) {
            for (Class c : classes) {
                System.out.println(c.toString());

            }
        }else{

            System.out.println("No Classes Scheduled");
        }
        System.out.println("Extra Classes: ");
        Iterable<ExtraClass> ExtraClass = extraClassController.listTeacherClasses();
        for (ExtraClass c: ExtraClass) {
            System.out.println(c.toString());
        }
        return true;
    }
}
