package FinalProjekt.riddles;

import FinalProjekt.item_stuff.*;

public class ItemRiddle extends RiddleType{
Item answer;

public ItemRiddle(int inChapterNr, String question, String hint, Item answer){
	super(inChapterNr, question, hint);
	this.answer=answer;
}

@Override
public void startRiddle() {
	// TODO Auto-generated method stub
	
}
}
