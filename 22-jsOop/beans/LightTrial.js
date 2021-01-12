const Trial = require("./Trial.js");

class LightTrial extends Trial{
    static FIRST_EXAM_PASS_MARK = 40;
    static SECOND_EXAM_PASS_MARK = 60;

    getCopy(){
        return new LightTrial(this._account, this._mark1, this._mark2);
    }

    isPassed() {
        return this._mark1 >= LightTrial.FIRST_EXAM_PASS_MARK && this._mark2 >= LightTrial.SECOND_EXAM_PASS_MARK;
    }

}
module.exports = LightTrial;