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
package eapli.base.app.manager.presentation;

import application.AuthorizationService;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.manager.presentation.authz.AddUserAction;
import eapli.base.app.manager.presentation.authz.DeactivateActivateUserAction;
import eapli.base.app.manager.presentation.authz.ListUsersAction;
import eapli.base.app.manager.presentation.course.*;
import eapli.base.app.manager.presentation.manager.EvaluateEnrollmentsUI;
import eapli.base.app.manager.presentation.teacher.SetTeachersUI;
import eapli.base.app.manager.presentation.student.EnrollStudentAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN_LABEL = "Return ";
    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;

    private static final int USERS_OPTION = 2;
    private static final int COURSES_OPTION = 3;
    private static final int MANAGE_STUDENT_OPTION = 4;
    private static final int MEETING_OPTION = 5;

    private static final int BOARD_OPTION = 6;

    private static final int SHOW_HISTORY = 1;


    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;

    // COURSE

    private static final int BULK_ENROLL = 1;
    private static final int EVALUATE_ENROLL = 2;
    private static final int CREATE_COURSE = 1;
    private static final int SHOW_ALL_COURSES = 2;
    private static final int DEACTIVATE_COURSE = 3;
    private static final int ACTIVATE_COURSE = 4;
    private static final int MANAGE_COURSE = 5;

    private static final int SET_TEACHERS = 6;

    //Meeting
    private static final int CREATE_MEETING = 1;
    private static final int EVALUATE_MEETING = 2;
    private static final int CANCEL_MEETING = 3;
    private static final int STATES_MEETING = 4;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final Menu menu;
    private final MenuRenderer renderer;

    public MainMenu() {
        menu = buildMainMenu();
        renderer = getRenderer(menu);
    }

    private MenuRenderer getRenderer(final Menu menu) {
        final MenuRenderer theRenderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            theRenderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            theRenderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return theRenderer;
    }

    @Override
    public boolean doShow() {
        return renderer.render();
    }

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu(BaseRoles.ADMIN);
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            final Menu courseMenu = buildCourseMenu();
            final Menu boardMenu = buildBoardMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            mainMenu.addSubMenu(COURSES_OPTION, courseMenu);
            final Menu managestudentmenu = buildStudentMenu();
            mainMenu.addSubMenu(MANAGE_STUDENT_OPTION, managestudentmenu);
            mainMenu.addSubMenu(MEETING_OPTION, meetingMenu());
            mainMenu.addSubMenu(BOARD_OPTION, boardMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserAction());
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate/Activate User", new DeactivateActivateUserAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCourseMenu() {
        final Menu menu = new Menu("Courses >");
        menu.addItem(CREATE_COURSE, "Create Course", new CreateCourseUI()::show);
        menu.addItem(SHOW_ALL_COURSES, "Show all Courses", new ListCourseAction());
        menu.addItem(DEACTIVATE_COURSE, "Deactivate/Activate Course", new DeactivateActivateCourseAction());
      //  menu.addItem(ACTIVATE_COURSE, "Activate Course", new ActivateCourseUI()::show);
        menu.addItem(MANAGE_COURSE, "Manage Course", new ManageCourseUI()::show);
        menu.addItem(SET_TEACHERS, "Set Teacher", new SetTeachersUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }


    private Menu buildStudentMenu(){
        final Menu menu = new Menu("Students >");
        menu.addItem(BULK_ENROLL,"Bulk Enrollment of Students",new EnrollStudentAction());
        menu.addItem(EVALUATE_ENROLL,"Evaluate students enrollment request ",new EvaluateEnrollmentsUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu meetingMenu() {
        final Menu menu = new Menu("Meeting >");
        menu.addItem(CREATE_MEETING, "Create a meeting", new CreateMeetingUI()::show);
        menu.addItem(EVALUATE_MEETING, "Evaluate meeting", new EvaluateMeetingsAction());
        menu.addItem(CANCEL_MEETING, "Cancel Meeting", new CancelMeetingUI()::show);
        menu.addItem(STATES_MEETING, "Meeting Users Status", new StatusParticipantsMeetingUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildBoardMenu() {
        final Menu menu = new Menu("Board >");
        menu.addItem(SHOW_HISTORY, "Show History of a board", new ShowBoardHistoryAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }
}
