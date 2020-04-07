package com.londonappbrewery.quizzler;

public class TrueFalse {
    private int mQuestionID;
    private boolean mAnswer;

    public TrueFalse(int mQuestionID, boolean mAnswer) {
        this.mQuestionID = mQuestionID;
        this.mAnswer = mAnswer;
    }

    public int getQuestionID() {
        return mQuestionID;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setQuestionID(int mQuestionID) {
        this.mQuestionID = mQuestionID;
    }

    public void setAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
