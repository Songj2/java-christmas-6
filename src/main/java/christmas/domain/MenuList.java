package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class MenuList {
    Map<String, String> menuList;

    public MenuList() {
    }

    public Map<String, String> getAllMenuList() {
        menuList = new HashMap<>();
        Menu[] menus = Menu.values();
        for (Menu menu : menus) {
            menuList.put(menu.getMenu(), menu.name());
        }
        return menuList;
    }

    public Map<String, String> getOrderableMenuList() {
        menuList = new HashMap<>();
        Menu[] menus = Menu.values();
        for (Menu menu : menus) {
            if (!menu.getType().equals("Drink")) {
                menuList.put(menu.getMenu(), menu.name());
            }
        }
        return menuList;
    }
    public Map<String, String> getDessertMenuList() {
        menuList = new HashMap<>();
        Menu[] menus = Menu.values();
        for (Menu menu : menus) {
            if (menu.getType().equals("Dessert")) {
                menuList.put(menu.getMenu(), menu.name());
            }
        }
        return menuList;
    }
    public Map<String, String> getMainMenuList() {
        menuList = new HashMap<>();
        Menu[] menus = Menu.values();
        for (Menu menu : menus) {
            if (menu.getType().equals("Main")) {
                menuList.put(menu.getMenu(), menu.name());
            }
        }
        return menuList;
    }

}
