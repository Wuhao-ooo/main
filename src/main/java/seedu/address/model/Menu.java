//@@author ZacZequn
package seedu.address.model;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
//import java.util.Scanner;

import seedu.address.model.dish.Dish;
import seedu.address.model.dish.Name;
import seedu.address.model.dish.Price;
import seedu.address.model.person.Person;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.task.exceptions.DuplicateTaskException;

import static java.util.Objects.requireNonNull;


/**
 * Wraps all data at the menu level
 */
public class Menu implements ReadOnlyMenu {

    private HashMap<String, Dish> dishes;

    /*
     * The 'unusual' code block below is an non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        dishes = new HashMap<>();
        //only for testing
        /*
        dishes.put("Chicken Rice", new Dish(new Name("Chicken Rice"), new Price("3")));
        dishes.put("Curry Chicken", new Dish(new Name("Curry Chicken"), new Price("4")));
        dishes.put("Chicken Chop", new Dish(new Name("Chicken Chop"), new Price("5")));
        dishes.put("Ban Mian", new Dish(new Name("Ban Mian"), new Price("4")));
        dishes.put("Ice Milo", new Dish(new Name("Ice Milo"), new Price("2")));
        dishes.put("Coffee", new Dish(new Name("Coffee"), new Price("2")));
        */
    }

    public Menu() {}

    /**
     * Creates an Menu using the Dishes {@code toBeCopied}
     */
    public Menu(ReadOnlyMenu toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    public void setMenu(HashMap<String, Dish> theDishes) {

        dishes = theDishes;
    }

    public void setMenu(Menu theMenu) {
        dishes = theMenu.getDishes();
    }

    /**
     * Resets the existing data of this {@code Menu} with {@code newData}.
     */
    public void resetData(ReadOnlyMenu newData) {
        requireNonNull(newData);
        setMenu(newData.getDishes());
    }

    /**
     * Returns the dish in Menu if available.
     * Otherwise return null.
     */
    public Dish get(String dish) {
        return dishes.get(dish);
    }

    /**
     * Adds a dish to the menu.
     */
    public void addDish(Dish dish) {
        dishes.put(dish.getName().toString(),dish);
    }


    /**
     * Returns a copy of the data in Menu.
     * Modifications on this copy will not affect the original Menu data
     */
    @Override
    public HashMap<String, Dish> getDishes() {
        return new HashMap<>(dishes);
    }

    @Override
    public String toString() {
        String menu = "";
        for (String name : dishes.keySet()) {
            menu += (name + " ");
        }
        menu = menu.trim();
        return menu;
    }
}
