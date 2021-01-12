import by.gsu.epamlab.core.RunnerLogic;
import by.gsu.epamlab.factories.HalfResultFactory;

public class RunnerTaskThree {
    public static void main(String[] args) {
        final String path = "src/resourses/task3/results.csv";
        HalfResultFactory factory = new HalfResultFactory();
        RunnerLogic.performTask(factory, path);
    }
}
