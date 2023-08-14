package FinalProjekt.item_stuff;


public class Item {
    private static int itemNr;
    protected String name;
    private boolean taken = false;
    private Inventory playerInventory;


    public Item(int itemNr, String name, Inventory playerInventory) {
        this.itemNr = itemNr;
        this.name = name;
        this.taken = false;
        this.playerInventory = playerInventory;
    }


    public static int getItemNr() {
        return itemNr;
    }

    public void setItemNr(int itemNr) {
        this.itemNr = itemNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }


}
