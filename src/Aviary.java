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

    public void feed(String animal, ArrayList<Animal> animals) {

        switch (animal) {
            case "Хищники":
                AnimalFood aFood = new AnimalFood();
                aFood.exist(animals);
                System.out.println("Вы покормили хищников");
                break;
            case "Травоядные":
                PlantFood pFood = new PlantFood();
                pFood.exist(animals);
                System.out.println("Вы покормили травоядных");
                break;
        }
    }

}
