public class Weapon {

    private final String name;
    private final Coordinates position;

    Weapon(String name, Room room) {
        this.name = name;
        position = room.addItem ();
    }

    public String getName() {
        return name;
    }

    public Coordinates getPosition() {
        return position;
    }
}
