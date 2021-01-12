package by.gsu.epamlab.beans;

import static by.Constants.*;

public class Trial {
    private String name;
    private int mark1;
    private int mark2;
    protected static final int PASS_MARK = 120;

    public Trial() {
    }

    public Trial(String name, int mark1, int mark2) {
        this.name = name;
        setMark1(mark1);
        setMark2(mark2);
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        if (mark1 > MARK_MAX_VALUE || mark1 < MARK_MIN_VALUE){
            throw new IllegalArgumentException(EXC_ILLEGAL_MARK1);
        }
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        if (mark2 > MARK_MAX_VALUE || mark2 < MARK_MIN_VALUE){
            throw new IllegalArgumentException(EXC_ILLEGAL_MARK2);
        }
        this.mark2 = mark2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassed() {
        return mark1 + mark2 >= PASS_MARK;
    }

    public void clearAllResults(){
        mark1 = MARK_MIN_VALUE;
        mark2 = MARK_MIN_VALUE;
    }

    public Trial getCopy(){
        return new Trial(name, mark1, mark2);
    }

    protected String fieldsToString(){
        return name + DELIMITER + mark1 + DELIMITER + mark2;
    }

    @Override
    public String toString() {
        return fieldsToString() + DELIMITER + isPassed();
    }

}
