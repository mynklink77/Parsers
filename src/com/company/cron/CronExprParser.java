package com.company.cron;

import com.company.parser.impl.Command;
import com.company.parser.impl.DayOfMonth;
import com.company.parser.impl.DayOfWeek;
import com.company.parser.impl.Hour;
import com.company.parser.impl.Minute;
import com.company.parser.impl.Month;
import java.util.Scanner;


public class CronExprParser {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("*******************************************");
      System.out.println(" Welcome to Cron Expression Parser CLI App");
      System.out.println("*******************************************");
      System.out.println("Please enter your input : ");
      String inputLine = sc.nextLine();
      String[] inputExpression = inputLine.split(" ");
      int maxRetries = 3;
      int retryAttempts = 0;
      while(inputExpression.length != 6){
        System.out.println("Invalid Input entered! Retries remaining: " + (maxRetries-retryAttempts));
        System.out.println("Please enter your input again : ");
        inputLine = sc.nextLine();
        inputExpression = inputLine.split(" ");
        retryAttempts++;
        if(retryAttempts == maxRetries){
          System.out.println("Exiting due to invalid input!");
          return;
        }
      }

      System.out.println("minute        " + new Minute().parse(inputExpression[0]));
      System.out.println("hour          " + new Hour().parse(inputExpression[1]));
      System.out.println("day of month  " + new DayOfMonth().parse(inputExpression[2]));
      System.out.println("month         " + new Month().parse(inputExpression[3]));
      System.out.println("day of week   " + new DayOfWeek().parse(inputExpression[4]));
      System.out.println("command       " + new Command().parse(inputExpression[5]));

    }
}
