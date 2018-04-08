
public class Questions {

	private UI ui; 
	private Players players;
	private Tokens tokens;
	private Deck deck;

	public Questions(UI ui, Players players, Tokens tokens, Deck deck) 
	{
		
		this.ui = ui;
		this.players = players;
		this.tokens = tokens;
		this.deck = deck;
	}
	
	
	public void makeQuestion(Room room, Weapons weapons, Player currPlayer)
	{
		String suspect = null, weapon = null;
		boolean isValidSuspect = false;
		boolean isValidWeapon = false;
		
		do{
			suspect = ui.inputQuestion("Enter your suspect name:");
			assert(suspect != null); //To make sure that suspect is no longer equal to null
			
		/*	if(validCharacter(suspect))
			{
				isValidSuspect = true;
			}
		*/
			if(players.containsToken(suspect))
			{
				isValidSuspect = true;
			}
			
			else
			{
				ui.displayString("Invalid suspect, try again");
			}
		}
		while(!isValidSuspect);
		
		do{
			weapon = ui.inputQuestion("Enter your weapon name:");
			assert(weapon != null); //To make sure that weapon is no longer equal to null
			
			if(validWeapon(weapon))
			{
				isValidWeapon = true;
			}
			
			else
			{
				ui.displayString("Invalid weapon, try again");
			}
			
		}
		while (!isValidWeapon);
		
		
		for(Player p : players)
		{
			if( p.hasToken(suspect)) {
				p.getToken().enterRoom(room);
			}
		}
		
		Weapon temp = weapons.getWeapon(weapon);
		assert(weapon != null);
		temp.moveWeapon(room);
		
//		ui.displayString("question is " + room + ", the weapon is " + weapon + " and the suspect is" + suspect);
		boolean othersAnswer = askOthers(weapon, suspect, currPlayer, room);
		ui.displayString("A player said yes");
		
	}
	
	private boolean askOthers(String weapon, String suspect, Player currPlayer, Room room)
	{
		for(Player p : players)
		{
			if(p.hasToken(suspect) || p.hasName(currPlayer.getName())) continue;
			ui.clearText();
			boolean validAnswer= false, validAnswer2 = false;
			do{
				String answer = ui.inputQuestion("Please confirm that " + p.getName() + "(" + p.getToken().getName() + ")" + " is currently playing?");
				assert(answer != null); //To make sure that weapon is no longer equal to null
				
				if(answer.toLowerCase().trim().equals("yes".toLowerCase().trim()))
				{
					validAnswer = true;
				}
				
				else
				{
					ui.displayString("Say yes when player is present");
				}
				
			}
			while (!validAnswer);
			
			String answer2;
			
			ui.displayString("Question is " + room + ", the weapon is " + weapon + " and the suspect is " + suspect);
			ui.displayString("These are your notes below:");
			ui.displayNotes(currPlayer, deck);
			
			do{
				answer2 = ui.inputQuestion("Reply yes if the room, weapon or suspect are here.\nReply done if not.");
				assert(answer2 != null); //To make sure that weapon is no longer equal to null
				
				if(answer2.toLowerCase().trim().equals("yes".toLowerCase().trim()) || answer2.toLowerCase().trim().equals("done".toLowerCase().trim()))
				{
					validAnswer2 = true;
				}
				
				else
				{
					ui.displayString("Invalid input. Please type yes or done");
				}
				
			}
			while (!validAnswer2);
			
			if(answer2.toLowerCase().trim().equals("yes".toLowerCase().trim()))
			{
				ui.clearText();
				return true;
			}
				
			else continue;
		}
		
		return false;
	}
	   
	private boolean validCharacter(String name) 
	{
	        for (String c : Names.SUSPECT_NAMES) 
	        {
	            if (c.equals(name)) 
	            {
	                return true;
	            }
	        }
	        
	        return false;
	}
	
	private boolean validWeapon(String name) 
	{
	        for (String c : Names.WEAPON_NAMES) 
	        {
	            if (c.toLowerCase().trim().equals(name.toLowerCase().trim())) 
	            {
	                return true;
	            }
	        }
	        
	        return false;
	}

}
