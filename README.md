# Welcome to Cron Expression Parser CLI App

## What is Cron Expression Parser?
A command line application which parses a cron string and expands each field to 
show the times at which it will run. It is written in Java programming language.

It only considers the standard cron format with five time fields 
(minute, hour, day of month, month, and day of week) plus a command, 
and it does not handle the special time strings such as "@yearly". 
The input is accepted as a single line.

The output is formatted as a table with the field names taking the first 14 columns 
and the times as a space-separated list following it. 

####For example, the following input argument:

*/15 0 1,15 * 1-5 /usr/bin/find

####yields the following output:

minute 0 15 30 45

hour  0

day of month 1 15

month 1 2 3 4 5 6 7 8 9 10 11 12 

day of week 1 2 3 4 5

command /usr/bin/find

##Current Scope: 
It covers a subset of the requirements, and is still a Work In Progress.

## How to run the application?
####Github Repository (Web): https://github.com/mynklink77/Parsers/tree/main

Via HTTPS: https://github.com/mynklink77/Parsers.git

Via SSH: git@github.com:mynklink77/Parsers.git

Via Github CLLI: gh repo clone mynklink77/Parsers

1. Clone above repo or download the project in local drive.
2. Open code in any IDE.
3. Navigate to main class: src/com/company/cron/CronExprParser.java
4. Right click on the file and select "Run ..."
5. When application starts running, user is asked to provide cron expression as console input.
6. In case of invalid input, user can retry up to 3 times before program exits automatically.

## Supported features
1. All or * : It specifies that event should happen for every time unit.
2. Range or - : It determines the value range.
3. Values or , : It specifies multiple values.
4. Increements or / : It specifies the incremental values.

#
...EOF...

