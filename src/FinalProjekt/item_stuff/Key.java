package FinalProjekt.item_stuff;

import java.awt.*;
import java.util.Hashtable;

public class Key extends Item{
	public Key(int itemNr, String name, Inventory playerInventory) {
	super(itemNr, name, playerInventory);
}	
public void useKey(Door door, Hashtable dkht) {
	System.out.println("Du versuchst, den Schlüssel ins Schloss der "+door.getName()+" zu stecken.");
	if(dkht.get(this)==door) {
		System.out.println("Die Tür öffnet sich quietschend.");
		door.open();
		this.name+=" [öffnete die "+door.getName()+"]";
	}else {
		System.out.println("Der Schlüssel passt nicht ins Schloss.");
	}
}
	}


