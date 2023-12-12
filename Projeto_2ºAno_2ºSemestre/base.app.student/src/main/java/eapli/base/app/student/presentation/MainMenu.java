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
package eapli.base.app.student.presentation;

import application.AuthorizationService;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
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

    private static final int EXIT_OPTION = 0;

    private static final int ENROLL_OPTION = 1;

    private static final int SHOWCOURSE_OPTION = 2;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int STUDENT = 2;
    private static final int EXAMS = 3;
    private static final int MEETING = 4;
    private static final int RECHARGE_USER_CARD_OPTION = 1;

    //EXAMS
    private static final int NEXT_EXAMS_OPTION = 1;
    private static final int SHOW_GRADES_OPTION = 2;
    private static final int TAKE_EXAM_OPTION =3;

    //MEETING
    private static final int CREATE_MEETING = 1;
    private static final int EVALUATE_MEETING = 2;
    private static final int CANCEL_MEETING = 3;
    private static final int STATES_MEETING = 4;
    private static final int SHOW_HISTORY = 1;
    private static final int BOARD_OPTION = 5;

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

        final Menu myUserMenu = new MyUserMenu(BaseRoles.STUDENT);
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.STUDENT)) {
            final Menu studentMenu = buildStudentMenu();
            final Menu examsMenu = buildExamsMenu();
            final Menu boardMenu = buildBoardMenu();
            mainMenu.addSubMenu(STUDENT, studentMenu);
            mainMenu.addSubMenu(EXAMS, examsMenu);
            mainMenu.addSubMenu(MEETING, meetingMenu());
            mainMenu.addSubMenu(BOARD_OPTION, boardMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildStudentMenu() {
        final Menu menu = new Menu("Student >");

        menu.addItem(ENROLL_OPTION, "Request Enrollment",new RequestEnrollmentAction());
        menu.addItem(SHOWCOURSE_OPTION, "Show courses available",new ShowCourseAvailableAction());
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return menu;
    }

    private Menu buildExamsMenu(){
        final Menu menu = new Menu("Exams >");
        menu.addItem(NEXT_EXAMS_OPTION, "Show next exams", new NextExamsAction());
        menu.addItem(SHOW_GRADES_OPTION, "Show grades", new ShowGradesAction());
        menu.addItem(TAKE_EXAM_OPTION,"Take exam", new TakeExamAction());
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return menu;
    }

    private Menu meetingMenu() {
        final Menu menu = new Menu("Meeting >");
        menu.addItem(CREATE_MEETING, "Create a meeting", new CreateMeetingUI()::show);
        menu.addItem(EVALUATE_MEETING, "Evaluate meeting", new EvaluateMeetingsAction());
        menu.addItem(CANCEL_MEETING, "Cancel Meeting", new CancelMeetingUI()::show);
        menu.addItem(STATES_MEETING, "Meeting Users Status", new StatusParticipantsMeetingUI()::show);
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return menu;
    }
    private Menu buildBoardMenu() {
        final Menu menu = new Menu("Board >");
        menu.addItem(SHOW_HISTORY, "Show History of a board", new ShowBoardHistoryAction());
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return menu;
    }
}