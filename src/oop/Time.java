package oop;

public class Time {
    //Model a time instance
    //Instance variable
    private int hour;
    private int minute;
    private int second;
    //Constructor
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public int getHour() {
        return this.hour;
    }
    public int getMinute() {
        return this.minute;
    }
    public int getSecond() {
        return this.second;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public void setSecond(int second) {
        this.second = second;
    }
    public void setTime(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }
    public String toString() {
        //return a string display information about this object
        String hour = getHour() >= 10 ? "" + getHour() : "0" + getHour();
        String minute = getMinute() >= 10 ? "" + getMinute() : "0" + getMinute();
        String second = getSecond() >= 10 ? "" + getSecond() : "0" + getSecond();
        String result =   hour + ":" + minute + ":" + second;
        return result;
    }
    public Time nextSecond() {
        if(getSecond() == 59)  {
            setSecond(0);
            if(getMinute() == 59) {
                setMinute(0);
                if(getHour() == 23) {
                    setHour(0);
                } else {
                    setHour(this.hour + 1);
                }
            } else {
                setMinute(this.minute + 1);
            }
        } else {
            setSecond(this.second + 1);
        }
        return this;
    }
    public Time previousSecond() {
        if(getSecond() == 0)  {
            setSecond(59);
            if(getMinute() == 0) {
                setMinute(59);
                if(getHour() == 0) {
                    setHour(23);
                } else {
                    setHour(this.hour - 1);
                }
            } else {
                setMinute(this.minute - 1);
            }
        } else {
            setSecond(this.second - 1);
        }
        return this;
    }
    public static void main(String[] args) {
        Time t1 = new Time(1, 2, 3);
        System.out.println(t1);  // toString()

        // Test Setters and Getters
        t1.setHour(4);
        t1.setMinute(5);
        t1.setSecond(6);
        System.out.println(t1);  // toString()
        System.out.println("Hour: " + t1.getHour());
        System.out.println("Minute: " + t1.getMinute());
        System.out.println("Second: " + t1.getSecond());

        // Test setTime()
        t1.setTime(23, 59, 58);
        System.out.println(t1);  // toString()

        // Test nextSecond();
        System.out.println(t1.nextSecond());
        System.out.println(t1.nextSecond().nextSecond());

        // Test previousSecond()
        System.out.println(t1.previousSecond());
        System.out.println(t1.previousSecond().previousSecond());
    }

}
