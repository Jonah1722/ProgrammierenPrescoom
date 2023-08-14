package FinalProjekt.riddles;

public abstract class RiddleType {
    private int inChapterNr;
    protected String question;
    protected String hint;
    protected boolean solved;
    protected int nrOfTries;

    public RiddleType(int inChapterNr, String question, String hint) {
        this.inChapterNr = inChapterNr;
        this.question = question;
        this.hint = hint;
        this.solved = false;
        this.nrOfTries = 0;
    }

    public abstract void startRiddle();

    public void solvedRiddle() {
        System.out.println("Das war wohl die richtige Antwort");
        this.solved = true;
    }

    public boolean isSolved() {
        return solved;
    }

    public void giveHint() {

    }
}
