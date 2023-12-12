/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import application.AuthorizationService;
import eapli.base.app.backoffice.console.presentation.course.*;
//import eapli.base.app.backoffice.console.presentation.student.RequestEnrollmentUI;


import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

//import eapli.base.app.backoffice.console.presentation.Course.ListCourseAction;
//import eapli.base.app.backoffice.console.presentation.course.ManageCourseUI;
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;


    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int COURSE_OPTION = 3;
    private static final int SETTINGS_OPTION = 4;

    private static final int MANAGE_STUDENT_OPTION = 5;

    // STUDENT MENU

    private static final int STUDENT_OPTION = 2;
    private static final int ENROLL_OPTION = 1;

    // TEACHER MENU

    private static final int TEACHER_OPTION = 2;
    private static final int SCHEDULE_OPTION = 1;

    // MANAGER MENU

    private static final int BULK_ENROLL = 1;
    private static final int CREATE_COURSE = 1;
    private static final int SHOW_ALL_COURSES = 2;
    private static final int DEACTIVATE_COURSE = 3;
    private static final int ACTIVATE_COURSE = 4;
    private static final int MANAGE_COURSE = 5;

    private static final int SET_TEACHERS = 3;


    private static final String SEPARATOR_LABEL = "--------------";

  

    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu managerMenu = buildManagerMenu();
            mainMenu.addSubMenu(COURSE_OPTION, managerMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.STUDENT)){
            final Menu studentMenu = buildStudentMenu();
            mainMenu.addSubMenu(STUDENT_OPTION,studentMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.TEACHER)){
            final Menu teacherMenu = buildTeacherMenu();
            mainMenu.addSubMenu(TEACHER_OPTION,teacherMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildStudentMenu() {
        final Menu menu = new Menu("Students >");
        //menu.addItem(ENROLL_OPTION, "Request Enrollment",new RequestEnrollmentUI()::doShow);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildTeacherMenu() {
        final Menu menu = new Menu("Teachers >");
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }
    
    private Menu buildManagerMenu() {
        final Menu menu = new Menu("Courses >");
        menu.addItem(CREATE_COURSE, "Create Course", new CreateCourseUI()::show);
        menu.addItem(SHOW_ALL_COURSES, "Show all Courses", new ListCourseAction());
        menu.addItem(DEACTIVATE_COURSE, "Deactivate Course", new DeactivateCourseUI()::show);
        menu.addItem(ACTIVATE_COURSE, "Activate Course", new ActivateCourseUI()::show);
        //menu.addItem(MANAGE_COURSE, "Manage Course", new ManageCourseUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }
    private Menu buildSetTeacherMenu() {
        final Menu menu = new Menu("Set Teacher >");
        //menu.addItem(SET_TEACHERS, "Set Teacher", new SetTeachersUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }




}
