const Trial = require("./Trial.js");

class StrongTrial extends Trial{
    static DIVIDER = 2;

    isPassed() {
        return this._mark1 / StrongTrial.DIVIDER + this._mark2 >= Trial.PASS_MARK;
    }

    getCopy(){
        return new StrongTrial(this._account, this._mark1, this._mark2);
    }
}
module.exports = StrongTrial;