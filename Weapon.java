public class Weapon {

    private final String name;
    private Coordinates position;
    private Room currRoom;
    
    Weapon(String name, Room room) {
        this.name = name;
        position = room.addItem ();
        this.currRoom = room;
    }

    public String getName() {
        return name;
    }
    
    public boolean hasName(String name) {
        return this.name.toLowerCase().trim().equals(name.toLowerCase().trim());
    }
    
    public void moveWeapon(Room room){
    	currRoom.removeItem(position);
    	position = room.addItem();
    	currRoom = room;
    }

    public Coordinates getPosition() {
        return position;
    }
}
