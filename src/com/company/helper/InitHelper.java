package com.company.helper;

import java.util.ArrayList;
import java.util.List;


public class InitHelper {

  public static List<Integer> getMonthsForLeapYear(){
    List<Integer> monthsList = new ArrayList<>();
    monthsList.add(2);
    return monthsList;
  }

  public static List<Integer> getMonthsWith30Days(){
    List<Integer> monthsList = new ArrayList<>();
    monthsList.add(4);
    monthsList.add(6);
    monthsList.add(9);
    monthsList.add(11);
    return monthsList;
  }

  public static List<Integer> getMonthsWith31Days(){
    List<Integer> monthsList = new ArrayList<>();
    monthsList.add(1);
    monthsList.add(3);
    monthsList.add(5);
    monthsList.add(7);
    monthsList.add(8);
    monthsList.add(10);
    monthsList.add(12);
    return monthsList;
  }
}
