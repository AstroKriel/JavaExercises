package patt.Coffee;

import patt.Coffee.CoffeeFactory.*;
import java.util.ArrayList;

public class Coffee {
    Type type;
    double cost;
    ArrayList<Ingredient> ingredients;

    public Coffee(ArrayList<Ingredient> ingredients, Type type) {
        this.type = type;
        this.ingredients = ingredients;
        double sum = 0;

        for (Ingredient ingredient : ingredients) {
            if (ingredient.equals(Ingredient.ESPRESSO)) {
                sum += Ingredient.ESPRESSO.getCost();
            } else if (ingredient.equals(Ingredient.MILK)) {
                sum += Ingredient.MILK.getCost();
            } else if (ingredient.equals(Ingredient.CHOCOLATE)) {
                sum += Ingredient.CHOCOLATE.getCost();
            } else {
                sum += 0;
            }
        }
        this.cost = sum;
    }

    public double getCost() {
        return cost;
    }

    public double getPrice() {
        if (this.type.equals(Type.LONG_BLACK)) {
            return Type.LONG_BLACK.getPrice();
        } else if (this.type.equals(Type.FLAT_WHITE)) {
            return Type.FLAT_WHITE.getPrice();
        } else if (this.type.equals(Type.MOCHA)) {
            return Type.MOCHA.getPrice();
        }
        return 0;
    }

    public String listIngredients() {
        String string = "";
        for (Ingredient ingredient : ingredients) {
            string += ingredient;
            string += "\n";
        }
        return string;
    }
}