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
package eapli.base.app.teacher.presentation;

import application.AuthorizationService;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.teacher.presentation.classe.*;
import eapli.base.app.teacher.presentation.courses.ShowTeachingCoursesAction;
//import eapli.base.app.teacher.teacher.ManageExamUI;
import eapli.base.app.teacher.teacher.*;
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

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int SALES_OPTION = 7;
    private static final int EXAMS_OPTION = 3;
    private static final int TEACHER = 2;

    private static final int EXAMS = 3;
    private static final int MEETING = 4;
    private static final int QUESTIONS = 5;


    private static final int RECHARGE_USER_CARD_OPTION = 1;

    // EXAM MENU
    private static final int CREAT_EXAM_OPTION = 1;
    private static final int LIST_EXAMS_OPTION = 2;
    private static final int LIST_EXAMS_COURSE = 3;
    private static final int MANAGE_EXAMS_OPTION = 4;
    private static final int EVALUATE_EXAM= 5;
    private static final int LIST_MY_COURSES_GRADES= 6;


    // TEACHER

    private static final int SCHEDULE_CLASS = 1;
    //Board
    private static final int CREATE_BOARD = 1;
    private static final int SHOW_TEACHING_COURSES = 2;
    private static final int SHOW_ALL_CLASSES = 3;
    private static final int SHOW_TEACHER_CLASSES = 4;
    private static final int SCHEDULE_EXTRACLASS = 5;
    private static final int UPDATE_CLASS = 6 ;


    //Meeting
    private static final int CREATE_MEETING = 1 ;
    private static final int EVALUATE_MEETING = 2;
    private static final int CANCEL_MEETING = 3;
    private static final int STATES_MEETING = 4;


    //Questions
    private static  final int ADD_QUESTIONS_OPTION = 1;
    private static final int SHOW_HISTORY = 1;
    private static final int BOARD_OPTION = 6;

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

        final Menu myUserMenu = new MyUserMenu(BaseRoles.TEACHER);
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.TEACHER)) {
            final Menu examsMenu = buildExamsMenu();
            final Menu teacherMenu = buildTeacherMenu();
            final Menu questionsMenu = buildQuestionsMenu();
            final Menu boardMenu = buildBoardMenu();
            mainMenu.addSubMenu(TEACHER, teacherMenu);
            mainMenu.addSubMenu(EXAMS, examsMenu);
            mainMenu.addSubMenu(MEETING, meetingMenu());
            mainMenu.addSubMenu(QUESTIONS, questionsMenu);
            mainMenu.addSubMenu(BOARD_OPTION, boardMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildExamsMenu() {
        final Menu menu = new Menu("Exams >");
        menu.addItem(CREAT_EXAM_OPTION,"Create Exam", new CreateExamUI()::doShow);
        // troquei o listexams pelo 2 só para testar, depois é preciso meter certo
        menu.addItem(LIST_EXAMS_OPTION, "List Exams", new ListExams2UI()::doShow);
        menu.addItem(LIST_EXAMS_COURSE, "List all exams in a course", new ListExamsCourseUI()::show);
        menu.addItem(MANAGE_EXAMS_OPTION, "Manage exams", new ManageExamUI()::show);
        menu.addItem(EVALUATE_EXAM, "Evaluate Exam", new EvaluateExamAction());
        menu.addItem(LIST_MY_COURSES_GRADES,"Show my courses grades",new ListExamsGradesAction());
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return menu;
    }

    private Menu buildQuestionsMenu(){
        final Menu menu = new Menu("Questions >");
            menu.addItem(ADD_QUESTIONS_OPTION, "Add questions", new AddQuestionsAction());
            menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
            return menu;
    }

    private Menu buildTeacherMenu() {
        final Menu menu = new Menu("Teacher >");

        menu.addItem(SCHEDULE_CLASS, "Schedule a class", new ScheduleClassAction());
        menu.addItem(SHOW_TEACHING_COURSES,"Show Teaching Courses",new ShowTeachingCoursesAction());
        menu.addItem(SHOW_ALL_CLASSES,"Show All Classes",new ShowAllClassesAction());
        menu.addItem(SHOW_TEACHER_CLASSES,"My Classes",new ShowTeacherClassesAction());
        menu.addItem(SCHEDULE_EXTRACLASS, "Schedule a Extraclass", new ScheduleExtraClassAction());
        menu.addItem(UPDATE_CLASS, "Update a scheduled class", new UpdateClassAction());
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return menu;
    }

    private Menu meetingMenu() {
        final Menu menu = new Menu("Meeting >");

        menu.addItem(CREATE_MEETING, "Create Meeting", new CreateMeetingUI()::show);
        menu.addItem(EVALUATE_MEETING, "Evaluate Meeting", new EvaluateMeetingsAction());
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
