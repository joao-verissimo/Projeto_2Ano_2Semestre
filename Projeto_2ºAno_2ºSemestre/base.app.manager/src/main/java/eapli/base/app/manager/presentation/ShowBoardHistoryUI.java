package eapli.base.app.manager.presentation;


import domain.model.SystemUserAuth;
import eapli.base.BoardManagement.application.ShowBoardHistoryController;
import eapli.base.BoardManagement.domain.PostIts;
import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.List;

public class ShowBoardHistoryUI extends AbstractUI {
    private final ShowBoardHistoryController controller = new ShowBoardHistoryController();
    @Override
    protected boolean doShow() {
        final List<SharedBoard> boards = new ArrayList<>();
        boolean show;
        do {
            show = showBoards(boards);
        } while (!show);
        try {
            System.out.printf("%-10s%-30s%-30s%-20s%n", "Data", "Row", "Column", "Author");
            for (final PostIts post : controller.showHistoryBoardPostIt(boards.get(0))) {
                System.out.printf("%-10s%-30s%-30s%-20s%n",post.data(),post.numRows().numRows(),post.numColumns().numColumns(),post.author().email().toString());
            }
            System.out.println("+==============================================================================+");
            System.out.printf("%-30s%-30s%-30s%n", "Username", "Firstname", "Lastname");
            for (final SystemUserAuth user : controller.showHistoryBoardUsers(boards.get(0))) {
                System.out.printf("%-30s%-30s%-30s%n",user.email().toString(), user.name().fullName(), user.name().shortName());
            }
        } catch (Exception e) {
        }
        return false;

    }
    private boolean showBoards(final List<SharedBoard> boards) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu courseMenu = buildBoardsMenu(boards);
        final MenuRenderer renderer = new VerticalMenuRenderer(courseMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }
    private Menu buildBoardsMenu(final List<SharedBoard> boards) {
        final Menu rolesMenu = new Menu();
        int counter = 1;
        for (final SharedBoard board : controller.findBoardOwned()){
            rolesMenu.addItem(MenuItem.of(counter++, board.getIdBoard().toString(), () -> boards.add(board)));
        }
        return rolesMenu;
    }
    @Override
    public String headline() {
        return "Show board history";
    }
}
