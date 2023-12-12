package eapli.base.app.teacher.presentation.classe;

import eapli.base.classmanagement.application.ShowAllClassesControler;
import eapli.base.classmanagement.domain.Class;

public class ShowAllClassesUI {

    ShowAllClassesControler controler = new ShowAllClassesControler();


    public boolean  show() {
        System.out.println("Classes:");
        Iterable<Class> classes = controler.listAllClasses();
        for (Class c: classes) {
            System.out.println(c.toString());

        }
        return true;
    }
}
