package FinalProjekt.item_stuff;

import java.util.Iterator;
import java.util.Vector;

public class Inventory {
    private Vector<Item> playerInventory = new Vector<Item>();

    public Vector<Item> getPlayerInventory() {
        return playerInventory;
    }


    public void addItem(Item item) {
        playerInventory.add(item);
        item.setTaken(true);
        //this.sort();
    }

    public void deleteItem(Item item) {
        playerInventory.remove(item);
        item.setTaken(false);
    }
/*public void sort() {
	Vector<Item> keys = new Vector<Item>();
	Iterator<Item> it=playerInventory.iterator();
	while(it.hasNext()) {
		Item x = it.next();
		if(x instanceof Key) {
			keys.add(x);
			playerInventory.remove(x);
		}
	}
	/*Iterator<Item> itKeys=keys.iterator();
	while (it.hasNext()) {
		playerInventory.add(itKeys.next());
	}
}*/

    public void showItems() {
        Iterator<Item> it = playerInventory.iterator();
        String s = "Das hast du momentan bei dir:\n\n";
        while (it.hasNext()) {
            s += "\t" + it.next().getName() + "\n";
        }
        System.out.println(s);
    }

    public boolean hasItem(int itemNr) {
        boolean flag = false;
        Iterator<Item> it = playerInventory.iterator();
        while (it.hasNext()) {
            if (it.next().getItemNr() == itemNr) {
                flag = true;
            }
        }
        return flag;
    }


}