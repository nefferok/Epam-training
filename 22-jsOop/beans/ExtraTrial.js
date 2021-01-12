const Trial = require("./Trial.js");

class ExtraTrial extends Trial{
    static THIRD_EXAM_PASS_MARK = 60;

    constructor(name, mark1, mark2, mark3) {
        super(name, mark1, mark2);
        if(mark3 > Trial.MARK_MAX_VALUE || mark3 < Trial.MARK_MIN_VALUE){
            throw new RangeError("Illegal argument in mark3");
        }
        this._mark3 = mark3;
    }

    get mark3(){
        return this._mark3;
    }

    get clearAllResults() {
        this._mark1 = 0;
        this._mark2 = 0;
        this._mark3 = 0;
        return this;
    }

    isPassed() {
        return super.isPassed() && this._mark3 >= ExtraTrial.THIRD_EXAM_PASS_MARK;
    }

    getCopy(){
        return new ExtraTrial(this._account, this._mark1, this._mark2, this._mark3);
    }

    fieldsToString() {
        return `${super.fieldsToString()};${this._mark3}`;
    }
}
module.exports = ExtraTrial;