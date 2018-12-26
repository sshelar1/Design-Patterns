## Assumptions made: 
Default current state would be north.
All the four direction signals (north, south, east, west) are red at the beginning.

Assuming you are in the directory containing this README:

Validation Provided:
1. To check number of arguments
2. To check if input file exists or not
3. To check if input file is empty or not
4. To check if debugvalue passed via command line is integer or not
5. To check if debugvalue passed via command line is within range or not
6. To check if the direction mentioned in input file is valid or not
7. To check if the number of cars being added is integer or not
8. To skip empty lines

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=debugLevel

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: 6/28/2018] -- Please add the date here

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)


-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).



