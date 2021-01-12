package by.gsu.epamlab.model;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.function.Function;

import static by.gsu.epamlab.utilit.RoundMethod.ROUND;

public enum Operation {
    SUM(DoubleSummaryStatistics::getSum),
    MAX(DoubleSummaryStatistics::getMax),
    MIN(DoubleSummaryStatistics::getMin),
    AVG(DoubleSummaryStatistics::getAverage);

    private Function<DoubleSummaryStatistics, Double> terminalOperation;

    private Operation (Function<DoubleSummaryStatistics, Double> terminalOperation) {
        this.terminalOperation = terminalOperation;
    }

    public double getResult(double[] numbers) {
        return ROUND.round(terminalOperation.apply(Arrays.stream(numbers)
                .summaryStatistics()), 2);
    }
}
