package FinalProjekt.chapters;

import FinalProjekt.GUI.MainGUI;
import FinalProjekt.chapterTexts.ChapterTexts;
import javafx.scene.paint.Color;

public class Chapter0 {
    private static int countInsideChapter = 0;
    public static boolean chapterSolved = false;

    public static void start() {
        if (countInsideChapter == 0) {
            MainGUI.setTypingText("Es ist dunkel. Man kann kaum die eigene Hand vor den Augen sehen.", Color.WHITE);
            countInsideChapter++;
        } else if (countInsideChapter == 1) {
            MainGUI.setTypingText(ChapterTexts.chapter0part1 , Color.WHITE);
            countInsideChapter++;
            Story.countChapter++;
        } else if (countInsideChapter == 2) {
            chapterSolved = true;
        }
    }
}
