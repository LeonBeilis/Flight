public class Time1 {

    private int _hours, _minutes;

    private static final int MINIMUM_MINUTE_RANGE = 0;
    private static final int MAXIMUM_MINUTE_RANGE = 59;
    private static final int MINIMUM_HOUR_RANGE = 0;
    private static final int MAXIMUM_HOUR_RANGE = 23;
    private static final int MINUTES_IN_HOUR = 60;

    /**
     * class constructor
     */
    public Time1(int h, int m) {
        //check for time validation before construct
        if(!isTimeValid(h,m)){
            //throw err here..
        } else {
            _minutes = m;
            _hours = h;
        }
    }

    /**
     * clone constructor
     */
    public Time1(Time1 t) {
        _minutes = t._minutes;
        _hours = t._hours;
    }

    /**
     * validate if time is valid
     * @return boolean
     */
    private boolean isTimeValid(int hours, int minutes) {
        return (isHourValid(hours) && isMinuteValid(minutes));
    }

    /**
     * check if hour is valid
     * @return boolean
     */
    private boolean isHourValid(int h) {
        return (h >= MINIMUM_HOUR_RANGE && h <= MAXIMUM_HOUR_RANGE);
    }

    /**
     * check if minute is valid
     * @return boolean
     */
    private boolean isMinuteValid(int m) {
        return (m >= MINIMUM_MINUTE_RANGE && m <= MAXIMUM_MINUTE_RANGE);
    }

    public int getHour(){
        return _hours;
    }

    public int getMinute(){
        return _minutes;
    }

    /**
     * @param num [hour]
     * check if hour is in its range, if so update hour else don't change
     */
    public void setHour(int num){
        _hours = (isHourValid(num)) ? num : _hours;
    }

    /**
     * @param num [minute]
     * check if minute is in its range, if so update minute else don't change
     */
    public void setMinute(int num){
        _minutes = (isMinuteValid(num)) ? num : _minutes;
    }

    /**
     * [formatInt - fix num to 2 int like: 7 to 07]
     * @param  num [hour/minute] Int
     * @return String
     */
    public String formatInt(int num){
        if(num == 0){
            return "00";
        } else if(num < 10){
            return ("0" + num);
        } else {
            return "" + num;
        }
    }

    public String toString() {
        return formatInt(_hours) + ":" + formatInt(_minutes);
    }

    public int minFromMidnight(){
        return _hours * MINUTES_IN_HOUR + _minutes;
    }

    public boolean equals(Time1 other){
        return (_hours == other._hours && _minutes == other._minutes);
    }

    public boolean before(Time1 other){
        return (_hours * MINUTES_IN_HOUR + _minutes) < (other._hours  * MINUTES_IN_HOUR + other._minutes);
    }

    public boolean after(Time1 other){
        return !before(other);
    }

    public int difference(Time1 other) {
        return (Math.abs(_hours - other._hours) * MINUTES_IN_HOUR) + Math.abs(_minutes - other._minutes);
    }
}