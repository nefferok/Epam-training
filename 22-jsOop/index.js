
const Trial = require("./beans/Trial.js");
const LightTrial = require("./beans/LightTrial.js");
const StrongTrial = require("./beans/StrongTrial");
const ExtraTrial = require("./beans/ExtraTrial");

try {
    //1. Create an Array for 9 entities
    let trials = [new Trial("Petrov", 80, 70),
        new Trial("Pechkin", 71, 75),
        new Trial("Putin", 75, 85),
        new LightTrial("Vasin", 25, 84),
        new LightTrial("Ivanov", 34, 96),
        new StrongTrial("Sidorov", 84, 70),
        new StrongTrial("Kravtsov", 81, 94),
        new ExtraTrial("Bloh", 75, 45, 25),
        new ExtraTrial("Litvinenko", 99, 99,99)];

    //2. Print the collection content (one element per line).
    let print = trial => console.log(trial.toString());

    trials.forEach(print);
    console.log("--------------------");

    //3. Print the number of passed trials.
    console.log("Number of passed trial: " + trials.filter(trial=> trial.isPassed()).length);
    console.log("--------------------");

    //4. Sort the collection by the sum of first and second marks.
    let sumMark = trial => trial.mark1 + trial.mark2

    trials.sort((a, b) => sumMark(a) - sumMark(b));

    //5. Print the array content (one element per line).
    trials.forEach(print);
    console.log("--------------------");

    //6. Create new array from unpassed trials, check whether all trials are
    // failed, clear all marks and print this array.
    let nonPassed = trial => !trial.isPassed()

    let unpassed = trials.filter(nonPassed)
        .map(trial=>trial.getCopy())
        .map(trial => trial.clearAllResults);

    console.log("All trials are failed: " + unpassed.every(nonPassed));
    console.log("--------------------");

    unpassed.forEach(print);
    console.log("--------------------");

    //7. Create numeric array from sums of first and second marks of sorted array (see item 4).
    let sums = trials.map(trial=>sumMark(trial));
    console.log(sums.join(', '));

} catch (e) {
    console.log("Incorrect data: " +  e.message);
}

