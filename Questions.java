
public class Questions {

	public void Questions(UI ui, Players players, Room room, Player player, Weapons weapons) {
		
		String Suspect = null;
		boolean isCharacter = false;
		ui.displayString("Enter a suspect:");
		ui.getCommand();
		ui.input = Suspect;
		assert(Suspect != null); //To make sure that suspect is no longer equal to null
		
		if(players.contains(Suspect))
		{
			isCharacter = true;
		}
		
		for(Player p : players)
		{
			if( p.hasName(Suspect)) {
				p.getToken().enterRoom(room);
			}
		}
		
		String Weapon = null;
		boolean isWeapon = false;
		ui.displayString("Enter a weapon:");
		ui.getCommand();
		ui.input = Weapon;
		assert(Weapon != null);
		
		if(players.contains(Weapon))
		{
			isWeapon = true;
		}
		
		for(Weapon w : weapons)
		{
			//if(w.)
		}
		
	}

}
