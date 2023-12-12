package eapli.base.app.sharedboardapp.sharedboard;

import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.ArrayList;
import java.util.List;

public class ShareABoardUI  {

    public String board(String listBoard) {
        final List<String> boards = new ArrayList<>();
        System.out.println("Choose a board:");
        boolean show;
        do {
            show = showBoards(boards,listBoard);
        } while (!show);
        return boards.get(0);
    }
    private boolean showBoards(final List<String> boards,final String listBoard) {
        final Menu boardsMenu = buildBoardsMenu(boards,listBoard);
        final MenuRenderer renderer = new VerticalMenuRenderer(boardsMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildBoardsMenu(final List<String> boards,String listBoard) {
        final Menu rolesMenu = new Menu();
        int counter = 1;
        String[] list = listBoard.split(":");
        for (int i = 0; i< list.length; i++){
            int finalI = i;
            rolesMenu.addItem(MenuItem.of(counter++, list[i], () -> boards.add(list[finalI])));
        }
        return rolesMenu;
    }

    public String users(String listUsers) {
        final List<String> users = new ArrayList<>();
        System.out.println("Choose a user:");
        boolean show;
        do {
            show = showUsers(users,listUsers);
        } while (!show);
        return users.get(0);
    }
    private boolean showUsers(final List<String> users,final String userList) {
        final Menu usersMenu = buildUsersMenu(users,userList);
        final MenuRenderer renderer = new VerticalMenuRenderer(usersMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildUsersMenu(final List<String> users,String userList) {
        final Menu rolesMenu = new Menu();
        int counter = 1;
        String[] list = userList.split(":");
        for (int i = 0; i< list.length; i++){
            int finalI = i;
            rolesMenu.addItem(MenuItem.of(counter++, list[i], () -> users.add(list[finalI])));
        }
        return rolesMenu;
    }

    public String state(){
        String state = Console.readLine("Enter number to choose the action:\n1. WRITE\n2. READ");
        switch (state){
            case "1":
                state = "0";
                break;
            case "2":
                state = "1";
                break;
            default:
                System.out.println("Invalid option!");
        }
        return state;
    }
}

