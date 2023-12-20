package FinalProjekt.chapters;

import FinalProjekt.item_stuff.Inventory;

public abstract class Story {

	public static Inventory inventory = new Inventory();
	public static int countChapter = 0;
	public static boolean allChaptersSolved = false;
	public static void main(String[] args) {
		storyWay();
	}

	public static void storyWay() {
		if (countChapter == 0) {
			Chapter0.start();
			checkIfAllChaptersAreSolved();
		} else if (countChapter == 1) {
			Chapter1.start();
			checkIfAllChaptersAreSolved();
		} else if (countChapter == 2) {
			Chapter2.start();
			checkIfAllChaptersAreSolved();
		} else if (countChapter == 3) {
			Chapter3.start();
			checkIfAllChaptersAreSolved();
		}
	}

	private static void checkIfAllChaptersAreSolved() {
		if (Chapter0.chapterSolved &&
				Chapter1.chapterSolved &&
					Chapter3.chapterSolved) {
			allChaptersSolved = true;
		}
	}
}
