package FinalProjekt.chapters;

import FinalProjekt.GUI.MainGUI;
import FinalProjekt.chapterTexts.ChapterTexts;
import javafx.scene.paint.Color;

public abstract class Chapter2 {
    private static int countInsideChapter = 0;
    public static boolean chapterSolved = false;

    public static void start() {
        if (countInsideChapter == 0) {
            MainGUI.setBackgroundImageNum(3);
            MainGUI.setTypingText(ChapterTexts.chapter2part1, Color.WHITE);
            countInsideChapter++;
        } else if (countInsideChapter == 1) {
            MainGUI.setTypingText("Starte mit der Zahl 8. Addiere 5, multipliziere das Ergebnis mit 3 und subtrahiere 10.", Color.WHITE);
            countInsideChapter++;
        } else if (countInsideChapter == 2) {
            if (MainGUI.textField.getText().equals("29")) {
                MainGUI.setTypingText("Richtig", Color.WHITE);
                MainGUI.textField.setVisible(false);
                countInsideChapter++;
                chapterSolved = true;
                Story.countChapter++;
            } else {
                MainGUI.setTypingText("Falsch", Color.WHITE);
                countInsideChapter = 1;
            }
        }
    }
}
