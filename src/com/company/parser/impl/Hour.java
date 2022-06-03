package com.company.parser.impl;

import com.company.parser.ExpressionParser;


public class Hour implements ExpressionParser {

  public static int MIN = 0;
  public static int MAX = 23;

  @Override
  public String parse(String expression) throws RuntimeException{

    StringBuilder hourBuilder = new StringBuilder();

    if(expression.charAt(0) == '*'){
      if(expression.length() == 1){
        for(int i=MIN; i<=MAX; i++){
          hourBuilder.append(i + " ");
        }
      } else if(expression.charAt(1) == '/' && expression.length() > 2){
        int frequency = Integer.parseInt(expression.split("/")[1]);
        getValuesForHour(hourBuilder, MIN, frequency);
      }
    } else if(expression.contains("/")){
      String[] hourFrequency = expression.split("/");
      int start = Integer.parseInt(hourFrequency[0]);
      int frequency = Integer.parseInt(hourFrequency[1]);
      getValuesForHour(hourBuilder, start, frequency);
    } else if(expression.contains("-")){
      String[] hourRange = expression.split("-");
      if(hourRange.length != 2){
        throw new RuntimeException("Invalid range for hour: " + expression);
      }
      int start = Integer.parseInt(hourRange[0]);
      int end = Integer.parseInt(hourRange[1]);

      if(start<MIN || end>MAX  || start > end){
        throw new RuntimeException("Invalid range for hour: " + expression);
      }

      while(start<=end){
        hourBuilder.append(start + " ");
        start++;
      }
    } else if(expression.contains(",")){
      String[] allValues = expression.split(",");
      for(String value : allValues){
        hourBuilder.append(Integer.parseInt(value) + " ");
      }
    } else if (MIN<=Integer.parseInt(expression) && MAX>=Integer.parseInt(expression)){
      hourBuilder.append(Integer.parseInt(expression));
    }

    if(hourBuilder.length() == 0){
      throw new RuntimeException("Expression not supported for hour: " + expression);
    }
    return hourBuilder.toString();
  }

  private StringBuilder getValuesForHour(StringBuilder hourBuilder, int start, int frequency){
    if(start<MIN || start>MAX || frequency<=MIN || frequency>MAX){
      return hourBuilder;
    }
    while(start<=MAX){
      hourBuilder.append(start + " ");
      start+=frequency;
    }
    return  hourBuilder;
  }
}
