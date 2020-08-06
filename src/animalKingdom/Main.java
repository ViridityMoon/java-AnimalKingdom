package animalKingdom;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static List<Animals> filterAnimals(List<Animals> animal, CheckAnimal tester)
    {
        List<Animals> tempList = new ArrayList<>();

        for (Animals a : animal)
        {
            if (tester.test(a))
            {
                tempList.add(a);
            }
        }
        return tempList;
    }
    public static void main(String[] args)
    {
        ArrayList<Animals> animalList = new ArrayList<>();

        //MAMMALS
        animalList.add(new Mammals("Panda", 1869));
        animalList.add(new Mammals("Zebra", 1778));
        animalList.add(new Mammals("Koala", 1816));
        animalList.add(new Mammals("Sloth", 1804));
        animalList.add(new Mammals("Armadillo", 1758));
        animalList.add(new Mammals("Raccoon", 1758));
        animalList.add(new Mammals("Bigfoot", 2021));

        // BIRDS
        animalList.add(new Bird("Pigeon", 1837));
        animalList.add(new Bird("Peacock", 1821));
        animalList.add(new Bird("Toucan", 1758));
        animalList.add(new Bird("Parrot", 1824));
        animalList.add(new Bird("Swan", 1758));

        // FISH
        animalList.add(new Fish("Salmon", 1758));
        animalList.add(new Fish("Catfish", 1817));
        animalList.add(new Fish("Perch", 1758));

        


        List<Animals> filteredList = filterAnimals(animalList, v -> v.getYearDiscovered() > 0);

        System.out.println("*** MVP ***");
        System.out.println("\n*** List all the animals in descending order by year named ***");

        animalList.sort((v1, v2) -> v2.getYearDiscovered() - v1.getYearDiscovered());
        animalList.forEach((v) -> System.out.println(v.getName() + " : " + v.getYearDiscovered()));

        System.out.println("\n*** List all the animals alphabetically ***");
        animalList.sort((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
        animalList.forEach((v) -> System.out.println(v.getName()));

        System.out.println("\n*** List all the animals order by how they move ***");
        animalList.sort((v1, v2) -> v1.move().compareToIgnoreCase(v2.move()));
        animalList.forEach((v) -> System.out.println(v.getName() + " : " + v.move()));

        System.out.println("\n*** List only those animals that breath with lungs ***");

        filteredList = filterAnimals(animalList, animal -> animal.breathe().equals("lungs"));
        filteredList.forEach((v) -> System.out.println(v.getName() + " : " + v.breathe()));

        System.out.println("\n*** List only those animals that breath with lungs and were named in 1758 ***");
        filteredList = filterAnimals(animalList, animal -> (animal.breathe().equals("lungs")) && (animal.getYearDiscovered() == 1758));
        filteredList.forEach((v) -> System.out.println(v.getName() + " : " + v.breathe() + " Year Discovered: " + v.getYearDiscovered()));

        System.out.println("\n*** List only those animals that lay eggs and breath with lungs ***");
        filteredList = filterAnimals(animalList, animal -> animal.breathe().equals("lungs") && animal.reproduce().equals("eggs"));
        filteredList.forEach((v) -> System.out.println(v.getName() + " : " + v.breathe() + " Reproduction: " + v.reproduce()));

        System.out.println("\n*** List alphabetically only those animals that were named in 1758 ***");
        // animalList.sort((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
        filteredList.sort((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
        filteredList = filterAnimals(animalList, animal -> animal.getYearDiscovered() == 1758);
        filteredList.forEach((v) -> System.out.println(v.getName() + " : " + v.getYearDiscovered()));


    }
}