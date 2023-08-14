package FinalProjekt.chapters;

import FinalProjekt.GUI.MainGUI;
import FinalProjekt.chapterTexts.ChapterTexts;
import FinalProjekt.item_stuff.Item;
import javafx.scene.paint.Color;

public abstract class Chapter3 {
    public static int countInsideChapter = 0;
    public static boolean chapterSolved = false;

    public static void start() {
        if (countInsideChapter == 0) {
            MainGUI.setBackgroundImageNum(3);
            MainGUI.setKeyboardImageNumber(0);
            MainGUI.setTypingText(ChapterTexts.chapter3part1, Color.WHITE);
            countInsideChapter++;
        } else if (countInsideChapter == 1) {
            Story.inventory.addItem(new Item(1, "Schlüssel", Story.inventory));
            MainGUI.setTypingText("Schlüssel aufgenommen", Color.WHITE);
            countInsideChapter++;
        } else if (countInsideChapter == 2) {
            MainGUI.setTypingText("Tür aufgeschlossen", Color.WHITE);
            countInsideChapter++;
        } else if (countInsideChapter == 3) {
            MainGUI.setTypingText(ChapterTexts.chapter6part1, Color.WHITE);
            countInsideChapter++;
        } else if (countInsideChapter == 4) {
            MainGUI.setBackgroundImageNum(0);
            MainGUI.setTypingText("FERTIG", Color.WHITE);
        }
    }
}
