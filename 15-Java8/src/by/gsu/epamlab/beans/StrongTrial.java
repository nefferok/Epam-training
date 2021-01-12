package by.gsu.epamlab.beans;

public class StrongTrial extends Trial{
    private final static int DIVIDER = 2;

    public StrongTrial() {
    }

    public StrongTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    @Override
    public Trial getCopy(){
        return new StrongTrial(getName(), getMark1(), getMark2());
    }

    @Override
    public boolean isPassed() {
        return getMark1() / DIVIDER + getMark2() >= Trial.PASS_MARK;
    }
}
