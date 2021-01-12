class Trial{
    static PASS_MARK = 120;
    static MARK_MIN_VALUE =0;
    static MARK_MAX_VALUE =100;


    constructor(account, mark1, mark2) {
        this._account = account;
        if(mark1 > Trial.MARK_MAX_VALUE || mark1 < Trial.MARK_MIN_VALUE){
            throw new RangeError("Illegal argument in mark1");
        }
        this._mark1 = mark1;
        if(mark2 > Trial.MARK_MAX_VALUE || mark2 < Trial.MARK_MIN_VALUE){
            throw new RangeError("Illegal argument in mark2");
        }
        this._mark2 = mark2;
    }
    get account(){
        return this._account;
    }

    get mark1(){
        return this._mark1;
    }

    get mark2(){
        return this._mark2;
    }

    isPassed(){
        return this._mark1 + this._mark2 >= Trial.PASS_MARK;
    }

    get clearAllResults(){
        this._mark1 = 0;
        this._mark2 = 0;
        return this;
    }

    getCopy(){
        return new Trial(this._account, this._mark1, this._mark2);
    }

    fieldsToString(){
        return `${this._account};${this._mark1};${this._mark2}`;
    }

    toString(){
        return `${this.fieldsToString()};${this.isPassed()}`;
    }
}

module.exports = Trial;