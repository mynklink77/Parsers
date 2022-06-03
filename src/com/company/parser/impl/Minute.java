package com.company.parser.impl;

import com.company.parser.ExpressionParser;


public class Minute implements ExpressionParser {

  public static int MIN = 0;
  public static int MAX = 59;

  @Override
  public String parse(String expression) throws RuntimeException{

    StringBuilder minuteBuilder = new StringBuilder();

    if(expression.charAt(0) == '*'){
      if(expression.length() == 1){
        for(int i=MIN; i<=MAX; i++){
          minuteBuilder.append(i + " ");
        }
      } else if(expression.charAt(1) == '/' && expression.length() > 2){
          int frequency = Integer.parseInt(expression.split("/")[1]);
          getValuesForMinute(minuteBuilder, MIN, frequency);
      }
    } else if(expression.contains("/")){
      String[] minuteFrequency = expression.split("/");
      int start = Integer.parseInt(minuteFrequency[0]);
      int frequency = Integer.parseInt(minuteFrequency[1]);
      getValuesForMinute(minuteBuilder, start, frequency);
    } else if(expression.contains("-")){
      String[] minuteRange = expression.split("-");
      if(minuteRange.length != 2){
        throw new RuntimeException("Invalid range for minute: " + expression);
      }
      int start = Integer.parseInt(minuteRange[0]);
      int end = Integer.parseInt(minuteRange[1]);

      if(start<MIN || end>MAX  || start > end){
        throw new RuntimeException("Invalid range for minute: " + expression);
      }

      while(start<=end){
        minuteBuilder.append(start + " ");
        start++;
      }
    } else if(expression.contains(",")){
      String[] allValues = expression.split(",");
      for(String value : allValues){
        minuteBuilder.append(Integer.parseInt(value) + " ");
      }
    } else if (MIN<=Integer.parseInt(expression) && MAX>=Integer.parseInt(expression)){
        minuteBuilder.append(Integer.parseInt(expression));
    }

    if(minuteBuilder.length() == 0){
      throw new RuntimeException("Expression not supported for minute: " + expression);
    }
    return minuteBuilder.toString();
  }

  private StringBuilder getValuesForMinute(StringBuilder minuteBuilder, int start, int frequency){
    if(start<MIN || start>MAX || frequency<=MIN || frequency>MAX){
      return minuteBuilder;
    }
    while(start<=MAX){
      minuteBuilder.append(start + " ");
      start+=frequency;
    }
    return  minuteBuilder;
  }
}
