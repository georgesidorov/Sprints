final public class Names {

    public final static String[] SUSPECT_NAMES = {"Plum", "White", "Scarlett", "Green", "Mustard", "Peacock"};
    public final static String[] WEAPON_NAMES = {"Rope", "Dagger", "Wrench", "Pistol", "Candlestick", "Lead Pipe"};
    public final static String[] ROOM_NAMES = {"Kitchen", "Ballroom", "Conservatory", "Billiard Room", "Library",
            "Study", "Hall", "Lounge", "Dining Room", "Cellar"};
    public final static String[] ROOM_CARD_NAMES = new String[ROOM_NAMES.length-1];  // exclude Cellar

    static {
        System.arraycopy(ROOM_NAMES, 0, ROOM_CARD_NAMES, 0, ROOM_CARD_NAMES.length);
    }

}
