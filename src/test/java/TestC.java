import java.util.ArrayList;
import java.util.List;

public class TestC {
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        final ArrayList<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterAppleByColor(List<Apple> inventory, String color){
        final ArrayList<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getColor().equals(color))
                result.add(apple);
        }
        return result;
    }

    public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate p){
        final ArrayList<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final ArrayList<Apple> inventory = new ArrayList<>();
        filterApple(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        });
        filterApple(inventory,(Apple apple)->"red".equals(apple.getColor()));
    }


}
