package by.gsu.epamlab.beans;

import static by.Constants.*;

public class ExtraTrial extends Trial{
    private int mark3;
    private static final int THIRD_EXAM_PASS_MARK = 60;

    public ExtraTrial() {
    }

    public ExtraTrial(String name, int mark1, int mark2, int mark3) {
        super(name, mark1, mark2);
        setMark3(mark3);
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        if (mark3 > MARK_MAX_VALUE || mark3 < MARK_MIN_VALUE){
            throw new IllegalArgumentException(EXC_ILLEGAL_MARK3);
        }
        this.mark3 = mark3;
    }

    @Override
    public void clearAllResults(){
        super.clearAllResults();
        mark3 = MARK_MIN_VALUE;
    }

    @Override
    public boolean isPassed() {
        return super.isPassed() && getMark3() >= THIRD_EXAM_PASS_MARK;
    }

    @Override
    public Trial getCopy(){
        return new ExtraTrial(getName(), getMark1(), getMark2(), mark3);
    }

    @Override
    protected String fieldsToString(){
        return super.fieldsToString() + DELIMITER + mark3;
    }

}
