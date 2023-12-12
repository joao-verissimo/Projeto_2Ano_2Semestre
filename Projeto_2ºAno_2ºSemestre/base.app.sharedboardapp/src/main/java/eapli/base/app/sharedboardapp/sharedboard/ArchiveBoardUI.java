package eapli.base.app.sharedboardapp.sharedboard;

import eapli.base.BoardManagement.domain.SharedBoard;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ArchiveBoardUI {
    public String chooseIdBoard(String boardList){
        final List<String> boards = new ArrayList<>();
        boolean show;
        do {
            show = showBoards(boards,boardList);
        } while (!show);
        return boards.get(0);
    }

    private boolean showBoards(final List<String> boards,final String boardList) {
        final Menu boardsMenu = buildBoardsMenu(boards,boardList);
        final MenuRenderer renderer = new VerticalMenuRenderer(boardsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildBoardsMenu(final List<String> boards,String boardList) {
        final Menu rolesMenu = new Menu();
        int counter = 1;
        String[] list = boardList.split(":");
        for (int i = 0; i< list.length; i++){
            int finalI = i;
            rolesMenu.addItem(MenuItem.of(counter++, list[i], () -> boards.add(list[finalI])));
        }
        return rolesMenu;
    }
}