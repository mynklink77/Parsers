package com.company.parser.impl;

import com.company.parser.ExpressionParser;


public class Command implements ExpressionParser {
  @Override
  public String parse(String expression) {
    return expression;
  }
}
