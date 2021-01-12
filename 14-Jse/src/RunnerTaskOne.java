import by.gsu.epamlab.core.RunnerLogic;
import by.gsu.epamlab.factories.ResultFactory;

public class RunnerTaskOne {
    public static void main(String[] args) {
        final String path = "src/resourses/task1/results.csv";
        ResultFactory factory = new ResultFactory();
        RunnerLogic.performTask(factory, path);
    }
}

