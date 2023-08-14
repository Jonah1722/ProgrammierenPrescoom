package FinalProjekt.riddles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import FinalProjekt.item_stuff.*;

public class NumberRiddle extends RiddleType {
    double answer;

    public NumberRiddle(int inChapterNr, String question, String hint, double answer) {
        super(inChapterNr, question, hint);
        this.answer = answer;
    }

    @Override
    public void startRiddle() {
        this.nrOfTries += 1;
        System.out.println(this.question);
        if (this.nrOfTries > 4) { //sollte der Spieler bereits 4-mal gescheitert sein, erhält er einen Hinweis
            System.out.println("(" + this.hint + ")");
        }
        BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
        double ans = 0;
        try {
            ans = Double.parseDouble(din.readLine());
        } catch (Exception IOException) {
            System.out.println("Das scheint keine möglich Antwort zu sein. Das Ergebnis müsste eine Zahl sein.");
        }
        if (ans == this.answer) {
            this.solvedRiddle();
        }
    }
}
