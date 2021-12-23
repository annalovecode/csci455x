// Name:anna zhao
// USC NetID: annaz
// CSCI 455 PA5
// Fall 2021

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 *
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

using namespace std;
//using in help
void printCommand();             // print all names and scores
void programRun(Table *&grades); // the function takes user input and find which step to take for the next
int main(int argc, char *argv[])
{

  // gets the hash table size from the command line

  int hashSize = Table::HASH_SIZE;

  Table *grades; // Table is dynamically allocated below, so we can call
  // different constructors depending on input from the user.

  if (argc > 1)
  {
    hashSize = atoi(argv[1]); // atoi converts c-string to int

    if (hashSize < 1)
    {
      cout << "Command line argument (hashSize) must be a positive number"
           << endl;
      return 1;
    }

    grades = new Table(hashSize);
  }
  else
  { // no command line args given -- use default table size
    grades = new Table();
  }
  grades->hashStats(cout);

  // add more code here
  programRun(grades);
  return 0;
}
// Reminder: use -> when calling Table methods, since grades is type Table*
//init all possible values including string command as s, string name as str, int score as v. boolean flag
void programRun(Table *&grades)
{
  string s = "";
  string str = "";
  int v = -1;
  bool Flag = true;
  while (Flag)
  {
    cout << "cmd> ";
    //cout << "\nPlease enter a command [insert,change,lookup,remove,print,size,stats,help,quit]: ";
    cin >> s;
    //Insert this name and score in the grade table. If this name was already present,
    //print a message to that effect, and don't do the insert
    if (s == "insert")
    {
      //cout << "Key to insert: (string)" << endl;
      cin >> str;
      //int v= atoi(v.c_str());
      //cout << "value to insert:(int)" << endl;
      cin >> v;
      //int v= atoi(v.c_str());
      bool done = grades->insert(str, v);
      if (done == false)
      {
        cout << "Item already exist." << endl;
      }
    }
    //Change the score for name. Print an appropriate message if this name isn't present.
    else if (s == "change")
    {
      //cout << "Key to change: (string)" << endl;
      cin >> str;
      //cout << "value after change:(int)" << endl;
      cin >> v; //read in the value

      if (grades->lookup(str) == NULL)
      {
        cout << "Name doesn't exist." << endl;
      }
      else
      {
        *(grades->lookup(str)) = v;
        cout << str << "'s score changed to " << v << endl;
      }
    }
    //Lookup the name, and print out his or her score, or a message indicating that student is not in the table.
    else if (s == "lookup")
    {
      //cout << "Key to find: (string)" << endl;
      cin >> str;
      if (grades->lookup(str) != NULL)
      {
        cout << "value is: " << *(grades->lookup(str)) << endl;
      }
      else
      {
        cout << "key doesn't exist!";
      }
    }
    //Remove this student. If this student wasn't in the grade table, print a message to that effect.
    else if (s == "remove")
    {
      cout << "key to remove: " << endl;
      cin >> str; //read in the key
      grades->remove(str);
    }
    //Prints out all names and scores in the table.
    else if (s == "print")
    {
      grades->printAll();

    } //print out the number of students.
    else if (s == "size")
    {
      cout << grades->numEntries() << endl;
    } //print out the hashStats
    else if (s == "stats")
    {
      grades->hashStats(cout);
    } //print out help command
    else if (s == "help")
    {

      printCommand();
    } //quit the program
    else if (s == "quit")
    { //Exit
      Flag = false;
      return;
    }
    else
    {
      cout << "ERROR: invalid command" << endl;
      printCommand();
    }
  }
}

//Print out the command summary
void printCommand()
{

  cout << "The valid command are as follows: " << endl;
  cout << "insert name score: Insert this name and score in the grade table." << endl;
  cout << "change name newscore: Change the score for name." << endl;
  cout << "lookup name: Lookup the name, and print out his or her score, or a message indicating that student is not in the table." << endl;
  cout << "remove name: Remove this student." << endl;
  cout << "print: Prints out all names and scores in the table." << endl;
  cout << "size: Prints out the number of entries in the table." << endl;
  cout << "stats: Prints out statistics about the hash table at this point. (Calls hashStats() method)" << endl;
  cout << "help: Prints out a brief command summary." << endl;
  cout << "quit: Exits the program." << endl;
}