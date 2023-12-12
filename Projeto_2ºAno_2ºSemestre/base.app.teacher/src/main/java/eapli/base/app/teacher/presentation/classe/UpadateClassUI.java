package eapli.base.app.teacher.presentation.classe;

import eapli.base.classmanagement.application.ScheduleClassController;
import eapli.base.classmanagement.application.UpdateClassController;
import eapli.base.classmanagement.domain.Class;
import eapli.base.classmanagement.domain.Duration;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.List;

public class UpadateClassUI extends AbstractUI {

    private final UpdateClassController controller = new UpdateClassController();
    @Override
    protected boolean doShow() {
        final List<String> days = new ArrayList<>();
        myClassMenu();
        final Long id = Console.readLong("Class ID:");
        final String newInitialTime = Console.readLine("New Initial time of class:");
        final String NewFinishTime = Console.readLine("New Final time of class:");
        boolean show;
        do {
            show = showDays(days);
        } while (!show);
        try {
            this.controller.updateClass(id,newInitialTime,NewFinishTime,days.get(0));
        } catch (RuntimeException e) {
            System.out.println("Schedule can't be created");
        }
        return true;
    }

    private boolean showDays(final List<String> daysWeek) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu daysMenu = buildDaysMenu(daysWeek);
        final MenuRenderer renderer = new VerticalMenuRenderer(daysMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildDaysMenu(final List<String> daysWeek) {
        final Menu daysMenu = new Menu();
        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
        int counter = 0;
        for (final String day : days){
            daysMenu.addItem(MenuItem.of(counter++, day, () -> daysWeek.add(day)));
        }
        return daysMenu;
    }

    private void myClassMenu(){
        for (Class cl : controller.showMyClasses()){
            System.out.println(cl);
        }
    }


    @Override
    public String headline() {
        return "Schedule class";
    }
}
