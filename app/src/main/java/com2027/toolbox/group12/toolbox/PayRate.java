package com2027.toolbox.group12.toolbox;

/**
 * Author: Dennis Ocaka
 *
 * Created at: 05/04/2019
 * Updated at: 05/04/2019
 *
 * The Enum represents the Pay rate for which the user chargers the rentee.
 * Options are as follows: Hour, Day, Week
 */
public enum PayRate {

    HOUR("hour"), DAY("day"), WEEK("week");

    private final String timespan;

    private PayRate(String timespan){
        this.timespan = timespan;
    }

    public String toString(){
        return this.timespan;
    }
}
