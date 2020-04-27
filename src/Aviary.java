import java.util.ArrayList;

public class Aviary {

    public ArrayList<Animal> animals = new ArrayList();

    public void fill(int count) {

        System.out.println("Вы создали вольер вместимостью " + count);

    }

    public void shoot(String animal) {
        switch (animal) {
            case "Хищники":
                System.out.println("Вы сфотографировали вольер с хищниками!");
                break;
            case "Травоядные":
                System.out.println("Вы сфотографировали вольер с травоядными");
                break;
        }
    }

    public void feed(String animal) {

        switch (animal) {
            case "Хищники":
                AnimalFood aFood = new AnimalFood();
                aFood.exist();
                System.out.println("Хищники едят мясо");
                break;
            case "Травоядные":
                PlantFood pFood = new PlantFood();
                pFood.exist();
                System.out.println("Травоядные едят траву и листья");
                break;
        }
    }

}
