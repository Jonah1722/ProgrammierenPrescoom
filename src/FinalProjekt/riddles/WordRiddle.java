package FinalProjekt.riddles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordRiddle extends RiddleType{
String answer;

public WordRiddle(int inChapterNr, String question, String hint, String answer){
	super(inChapterNr, question, hint);
	this.answer=answer;
}

@Override
public void startRiddle() {
	this.nrOfTries+=1;
	System.out.println(this.question);
	if(this.nrOfTries>4) { //sollte der Spieler bereits 4-mal gescheitert sein, erhält er einen Hinweis
		System.out.println("("+this.hint+")");
	}
	BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
	String ans=null;
	try {
		ans = din.readLine();
	} catch (IOException e) {
		System.out.println("Die Eingabe ist nicht möglich. Vielleicht solltes du etwas anderes versuchen.");
	}
	if(ans.equalsIgnoreCase(answer)) {
		this.solvedRiddle();
	}
	}	
}


