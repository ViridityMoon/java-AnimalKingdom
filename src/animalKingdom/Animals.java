package animalKingdom;

abstract class Animals
{
    // STATE

    private static int maxId = 0;
    private int id;
    private String name;
    private int yearDiscovered;

    // CONSTRUCTOR

    public Animals(String name, int yearDiscovered)
    {

        id = maxId++;
        this.name = name;
        this.yearDiscovered = yearDiscovered;

    }

    // GETTERS

    public String getName()
    {
        return name;
    }

    public int getYearDiscovered()
    {
        return yearDiscovered;
    }

    // METHODS

    public String eat()
    {
        return "om nom";
    }

    public String move()
    {
        return "stomp stomp";
    }

    public String breathe()
    {
        return "gasp";
    }

    public String reproduce()
    {
        return "BIRTH";
    }
}