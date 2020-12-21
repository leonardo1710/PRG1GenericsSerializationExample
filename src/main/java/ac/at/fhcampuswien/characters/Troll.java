package ac.at.fhcampuswien.characters;

public class Troll implements ICreature, ICanTurnIntoStone {    // classes can implement multiple interfaces
    private boolean isTurnedToStone = false;
    private String name;
    private int age;

    public Troll(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public void walk(int distance) {
        System.out.println("Troll walk " + distance);
    }

    @Override
    public void turnIntoStone() {
        this.isTurnedToStone = true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.name + " " + this.age;
    }
}
