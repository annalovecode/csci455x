// Name: anna zhao
// USC NetID: annaz
// CS 455 PA5
// Fall 2021

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"

int main()
{
  char s;
  string str;
  int v;
  Node *list = NULL;
  bool Flag = true;
  while (Flag)
  {
    cout << "\nPlease enter a command [i(insert), d(delete),a(append), p(print), q(quit), n(num), f(find), u(update)]: ";
    cin >> s;
    if (cin.fail())
    {
      cout << "ERROR: input stream failed." << endl;
      Flag = false;
    }
    else
    {
      switch (s)
      {
      case 'i':
        cout << "insert key-value pair in the front of the list" << endl;
        cout << "Key to insert: (string)" << endl;
        cin >> str;
        cout << "value to insert:(int)" << endl;
        cin >> v;
        insertFront(list, str, v);
        break;
      case 'd':
        cout << "delete node" << endl;
        cout << "Key to delete:(string) " << endl;
        cin >> str;
        deleteNode(list, str);
        break;
      case 'a':
        cout << "insert key-value pair in the end of the list" << endl;
        cout << "key to insert:(string)" << endl;
        cin >> str;
        cout << "value to insert:(int)" << endl;
        cin >> v;
        listAppend(list, str, v);
        break;
      case 'p':
        cout << "print out the total list" << endl;
        cout << "the list is" << endl;
        printList(list);
        cout << endl;
        break;
      case 'q':
        cout << "quit the print" << endl;
        Flag = false;
        break;
      case 'n':
        cout << "total num of the list is" << numberOfList(list) << endl;
      case 'f':
        cout << "look up the target node" << endl;
        cout << "Key to find: (string)" << endl;
        cin >> str;
        int *m;
        m = findNode(list, str);
        if (m != NULL)
        {
          cout << "value is: " << (*m) << endl;
          cout << "key doesn't exist!";
        }
        else
        {
          cout << "key doesn't exist!";
        }
        break;
      case 'u':
        cout << "update the target node" << endl;
        cout << "Key to update: (string)" << endl;
        cin >> str;
        cout << "value to update: (int)" << endl;
        cin >> v;
        updateValue(list, str, v);
        break;
      }
      cout << "The list: " << endl;
      printList(list);
    }
  }
  return 0;
}