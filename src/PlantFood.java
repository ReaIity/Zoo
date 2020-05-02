import java.util.ArrayList;

public class PlantFood extends Food{

    @Override
    public void exist(ArrayList<Animal> animals) {

        System.out.println("Вы покормили: " + animals.toString());

    }
}
