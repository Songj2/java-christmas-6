package christmas.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuList {
    Map<String, String> menuList;
    public MenuList(){}

    public Map<String, String> getAllMenuList() {
        menuList= new HashMap<>();
        addAppetizer(Appetizer.values());
        addMain(Main.values());
        addDessert(Dessert.values());
        addDrink(Drink.values());
        return menuList;
    }
    public Map<String, String> getOrderableMenuList(){
        menuList= new HashMap<>();
        addAppetizer(Appetizer.values());
        addMain(Main.values());
        addDessert(Dessert.values());
        return menuList;
    }

    private void addAppetizer(Appetizer[] appetizers){
        for (Appetizer appetizer: appetizers){
            menuList.put(appetizer.getMenu(), appetizer.name());
        }
    }
    private void addMain(Main[] mains){
        for(Main main: mains){
            menuList.put(main.getMenu(), main.name());
        }
    }
    private void addDessert(Dessert[] desserts){
        for (Dessert dessert: desserts){
            menuList.put(dessert.getMenu(), dessert.name());
        }
    }
    private void addDrink(Drink[] drinks){
        for (Drink drink: drinks){
            menuList.put(drink.getMenu(), drink.name());
        }
    }
}
