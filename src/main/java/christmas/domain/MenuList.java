package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuList {
    List<String> menuList;
    public MenuList(){}

    public List<String> getAllMenuList() {
        menuList= new ArrayList<>();
        addAppetizer(Appetizer.values());
        addMain(Main.values());
        addDessert(Dessert.values());
        addDrink(Drink.values());
        return menuList;
    }
    public List<String> getOrderableMenuList(){
        menuList= new ArrayList<>();
        addAppetizer(Appetizer.values());
        addMain(Main.values());
        addDessert(Dessert.values());
        return menuList;
    }

    private void addAppetizer(Appetizer[] appetizers){
        for (Appetizer appetizer: appetizers){
            menuList.add(appetizer.getMenu());
        }
    }
    private void addMain(Main[] mains){
        for(Main main: mains){
            menuList.add(main.getMenu());
        }
    }
    private void addDessert(Dessert[] desserts){
        for (Dessert dessert: desserts){
            menuList.add(dessert.getMenu());
        }
    }
    private void addDrink(Drink[] drinks){
        for (Drink drink: drinks){
            menuList.add(drink.getMenu());
        }
    }
}
