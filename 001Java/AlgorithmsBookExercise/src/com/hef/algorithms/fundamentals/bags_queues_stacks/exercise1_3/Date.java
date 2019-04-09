package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3;

public class Date {

    private int month;
    private int day;
    private int year;
    public Date(String date) {
        String[] fields = date.split("/");
        month = Integer.parseInt(fields[0]);
        day   = Integer.parseInt(fields[1]);
        year  = Integer.parseInt(fields[2]);
    }
}
