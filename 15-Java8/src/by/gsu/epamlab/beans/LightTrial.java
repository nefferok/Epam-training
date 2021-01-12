package by.gsu.epamlab.beans;

public class LightTrial extends Trial{
    private static final int FIRST_EXAM_PASS_MARK = 40;
    private static final int SECOND_EXAM_PASS_MARK = 60;

    public LightTrial() {
    }

    public LightTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    @Override
    public Trial getCopy(){
        return new LightTrial(getName(), getMark1(), getMark2());
    }

    @Override
    public boolean isPassed() {
        return getMark1() >= FIRST_EXAM_PASS_MARK && getMark2() >= SECOND_EXAM_PASS_MARK;
    }
}
