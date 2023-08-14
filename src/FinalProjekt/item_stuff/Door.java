package FinalProjekt.item_stuff;

public class Door {
private String name;
private int inChapterNr;
boolean opened;

public Door(int inChapterNr, String name) {
	this.inChapterNr=inChapterNr;
	this.name=name;
	this.opened=false;
}
public void open() {
	this.opened=true;
}
public boolean isOpen() {
	return this.opened;
}
public String getName() {
	return name;
}
}
