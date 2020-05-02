import java.util.Scanner;

public class Zoo {

    Scanner scanner = new Scanner(System.in);

    public void work() {

        System.out.println("Зоопарк открыт!");

        upbuildZoo();

    }

    public void upbuildZoo() {

        Aviary[] aviaries = new Aviary[2];
        System.out.println("Построим вольер для травоядных");
        aviaries[0] = new Aviary();
        System.out.println("Какой вместительности будет этот вольер?");
        int count1 = readInt(scanner);
        aviaries[0].fill(count1);

        System.out.println("Построим вольер для хищников");
        aviaries[1] = new Aviary();
        System.out.println("Какой вместительности будет этот вольер?");
        int count2 = readInt(scanner);
        aviaries[1].fill(count2);

        addAnimal(aviaries, count1, count2);

        interaction(aviaries);
    }

    public void addAnimal(Aviary[] aviaries, int count1, int count2) {

        System.out.println("Добавим животных в вольеры? Y - да, N - нет");

        String choiсe = scanner.nextLine();
        while (choiсe.equals("Y")) {
            pushAnimal(aviaries, count1, count2);
            System.out.println("Добавим еще животных? Y - да, N - нет");
            choiсe = scanner.nextLine();
        }
        if (choiсe.equals("N")) {
           System.out.println("Мы закончили селить животных в вольеры, либо Вы выбрали вариант не селить их вовсе");
        }

    }

    public void pushAnimal(Aviary[] aviaries, int count1, int count2) {
        System.out.println("Какого животного мы добавим?");
        String animal = scanner.nextLine();
        if(!animal.equals("Лев") && !animal.equals("Тигр") && !animal.equals("Лемур") && !animal.equals("Жираф")) {
            System.out.println("Мы не можем селить таких животных");
        } else {
            switch (animal) {
                case "Лев":
                    if (aviaries[1].animals.size() < count2){
                        Lion leo = new Lion();
                        aviaries[1].animals.add(leo);
                    } else {
                        System.out.println("Вольер заполен");
                    }
                    break;
                case "Тигр":
                    if (aviaries[1].animals.size() < count2){
                        Tiger tiger = new Tiger();
                        aviaries[1].animals.add(tiger);
                    } else {
                        System.out.println("Вольер заполен");
                    }
                    break;
                case "Жираф":
                    if (aviaries[0].animals.size() < count1){
                        Giraffe giraffe = new Giraffe();
                        aviaries[0].animals.add(giraffe);
                    } else {
                        System.out.println("Вольер заполен");
                    }
                    break;
                case "Лемур":
                    if (aviaries[0].animals.size() < count1){
                        Lemur lemur = new Lemur();
                        aviaries[0].animals.add(lemur);
                    } else {
                        System.out.println("Вольер заполен");
                    }
                    break;
            }
        }
    }

    public void interaction(Aviary[] aviaries){
        if((aviaries[0].animals.size() == 0) && (aviaries[1].animals.size() == 0)) {
            System.out.println("Один или все вольеры пусты, скучный зоопарк, придётся придти в другое время");
            return;
        } else {
            System.out.println("Вы можете покинуть зоопарк или покормить/сфотографировать животных!");
            String fatefulChoice = scanner.nextLine();
            while (!fatefulChoice.equals("Покинуть")) {
                if (fatefulChoice.equals("Покормить")) {
                    feedAnimal(scanner, aviaries);
                    System.out.println("Выберите следующий вариант");
                    fatefulChoice = scanner.nextLine();
                } else if (fatefulChoice.equals("Сфотографировать")) {
                    photo(scanner, aviaries);
                    System.out.println("Выберите следующий вариант");
                    fatefulChoice = scanner.nextLine();
                }
            }
        }
    }

    public void photo(Scanner scanner, Aviary[] aviaries) {

        System.out.println("Животных из какого вольера будем фотографировать? Травоядные/Хищники");
        String animal = scanner.nextLine();


        if (animal.equals("Хищники")) {
            aviaries[1].shoot(animal);
        } else if (animal.equals("Травоядные")) {
            aviaries[0].shoot(animal);
        }
    }

    private void feedAnimal(Scanner scanner, Aviary[] aviaries) {

        System.out.println("Животных из какого вольера будем кормить? Травоядные/Хищники");
        String animal = scanner.nextLine();

        if (animal.equals("Хищники")) {

            System.out.println("Чем вы хотите накормить хищников?");
            String food = scanner.nextLine();

            while(!food.equals("Мясо")) {
                System.out.println("Хищники это не едят, выберите другой вариант!");
                food = scanner.nextLine();
            }

            aviaries[1].feed(animal, aviaries[1].animals);


        } else if (animal.equals("Травоядные")) {

            System.out.println("Чем вы хотите накормить травоядных?");
            String food = scanner.nextLine();

            while(!food.equals("Трава")) {
                System.out.println("Травоядные это не едят, выберите другой вариант!");
                food = scanner.nextLine();
            }

            aviaries[0].feed(animal, aviaries[0].animals);

        }

    }

    private static int readInt (Scanner scanner) {

        int result = 0;

        try {
            result = Integer.parseInt(scanner.nextLine());
            while(result <= 0) {
                System.out.println("Недопустимая вместительность вольера");
                System.out.println("Введите другое число");
                result = Integer.parseInt(scanner.nextLine());
            }

        } catch (NumberFormatException e) {
            System.out.println("Введенная строка не является числом");
            System.out.println("Введите другое число");
            result = Integer.parseInt(scanner.nextLine());
        }
        return result;
    }

}
