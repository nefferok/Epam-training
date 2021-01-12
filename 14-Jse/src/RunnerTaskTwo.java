import by.gsu.epamlab.core.RunnerLogic;
import by.gsu.epamlab.factories.DecimalResultFactory;

public class RunnerTaskTwo {
    public static void main(String[] args) {
        final String path = "src/resourses/task2/results.xml";
        DecimalResultFactory factory = new DecimalResultFactory();
        RunnerLogic.performTask(factory, path);
    }
}
