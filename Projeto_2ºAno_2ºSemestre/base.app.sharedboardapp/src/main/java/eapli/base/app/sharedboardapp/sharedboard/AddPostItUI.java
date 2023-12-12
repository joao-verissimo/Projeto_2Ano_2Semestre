package eapli.base.app.sharedboardapp.sharedboard;

import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.List;

public class AddPostItUI {

    public String addPostIt(String boardList) {
        String result;
        final List<String> boards = new ArrayList<>();
        boolean show;
        do {
            show = showBoards(boards,boardList);
        } while (!show);
        final String data = Console.readLine("Post-It data (Text or image path):");
        final String row = Console.readLine("Row:");
        final String column = Console.readLine("Column:");
        result = data+"::"+row+"::"+column+"::"+boards.get(0);
        return result;

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