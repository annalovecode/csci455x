
/*  Name:Anna Zhao
 *  USC NetID:annaz
 *  CS 455 Fall 2021
 *  Extra credit assignment
 *
 *  ectest.cpp
 *
 *  a non-interactive test program to test the functions described in ecListFuncs.h
 *
 *    to run it use the command:   ectest
 *
 *  Note: this uses separate compilation.  You put your list code ecListFuncs.cpp
 *  Code in this file should call those functions.
 */


#include <iostream>
#include <string>

#include "ecListFuncs.h"

using namespace std;


int main ()
{
   // test listToString by creating some examples
    Node *node1 = new Node(1);
    Node *node2 = new Node(2, node1);
    Node *node3 = new Node(3, node2);
    string actualNode3 = listToString(node3);
    string expctedNode3 = "(3 2 1)";
    string Node3Matched = actualNode3 == expctedNode3 ? "YES" : "FAILED";
    cout << "Test if 'listToString' can convert a list to a string successfully. Input list 3->2->1, listToString result should be '(3 2 1)'" << endl;
    cout << "Expected result: " + expctedNode3 << endl;
    cout << "Actual result: " + actualNode3 << endl;
    cout << "Does the actual result match the expected result? " + Node3Matched << endl;
    cout << "-----------------------------------------------" << endl;

    // test empty list
    Node *emptyNode = NULL;
    string actualEmptyNode = listToString(emptyNode);
    string expctedEmptyNode = "()";
    string emptyNodeMatched = actualEmptyNode == expctedEmptyNode ? "YES" : "FAILED";
    cout << "Test if 'listToString' can convert an empty list to a string successfully. Input list NULL, listToString result should be '()'" << endl;
    cout << "Expected result: " + expctedEmptyNode << endl;
    cout << "Actual result: " + actualEmptyNode << endl;
    cout << "Does the actual result match the expected result? " + emptyNodeMatched << endl;
    cout << "-----------------------------------------------" << endl;

    // test buildList
    string listString = "7 4 3 4 9";
    Node *list = buildList(listString);
    string buildListActual = listToString(list);
    string buildListExpected = "(7 4 3 4 9)";
    string buildListmatched = buildListActual == buildListExpected ? "YES" : "FAILED";
    cout << "Test if 'buildList' can build a list successfully. Input '7 4 3 4 9', listToString result should be '(7 4 3 4 9)'" << endl;
    cout << "Expected result: " + buildListExpected << endl;
    cout << "Actual result: " + buildListActual << endl;
    cout << "Does the actual result match the expected result? " + buildListmatched << endl;
    cout << "-----------------------------------------------" << endl;
     // test insertAt with list 7->4->3->4->9 (it has been built)
    insertAt(list, 2, 3);
    string actualList = listToString(list);
    string expectedList = "(7 4 3 3 4 9)";
  //  string matchedList = actualList == expectedList ? "YES" : "FAILED";
    string matchedList = actualList == expectedList ? "YES" : "FAILED";
    cout << "Test if 'insertAt' can insert the list at index 2 successfully. Input list 7->4->3->4->9 and index 2, value 3, a should be '(7 4 3 3 4 9)'"<<endl;
    cout << "Expected result of list: " + expectedList << endl;
    cout << "Actual result of list: " + actualList << endl;
     cout << "Does the actual result of list match the expected result of list? " + matchedList << endl;
    cout << "-----------------------------------------------" << endl;
     // test insertAt with list 7->4->3->3->4->9 (it has been built)
    insertAt(list, 3, 7);
    string actualList1 = listToString(list);
    string expectedList1 = "(7 4 3 7 3 4 9)";
  //  string matchedList = actualList == expectedList ? "YES" : "FAILED";
    string matchedList1 = actualList1 == expectedList1 ? "YES" : "FAILED";
    cout << "Test if 'insertAt' can insert the list a1t index 3 successfully. Input list 7->4->3->3->4->9 and index 3, value 7,  should be '(7 4 3 7 3 4 9)'"<<endl;
    cout << "Expected result of list: " + expectedList1<< endl;
    cout << "Actual result of list: " + actualList1 << endl;
     cout << "Does the actual result of list match the expected result of list? " + matchedList1 << endl;
    cout << "-----------------------------------------------" << endl;
     // test insertAt with list 7->4->3->7->3->4->9 (it has been built)
    insertAt(list, 0, 3);
    actualList1 = listToString(list);
    expectedList1 = "(3 7 4 3 7 3 4 9)";
  //  string matchedList = actualList == expectedList ? "YES" : "FAILED";
    matchedList1 = actualList1 == expectedList1 ? "YES" : "FAILED";
    cout << "Test if 'insertAt' can insert the list a1t index 3 successfully. Input list 7->4->3->7->3->4->9 and index 0, value 3,  should be '(3 7 4 3 7 3 4 9)'"<<endl;
    cout << "Expected result of list: " + expectedList1<< endl;
    cout << "Actual result of list: " + actualList1 << endl;
     cout << "Does the actual result of list match the expected result of list? " + matchedList1 << endl;
    cout << "-----------------------------------------------" << endl;
   //test empty cases
   insertAt(emptyNode, 0, 3);
    string actualList2 = listToString(emptyNode);
    string expectedList2 = "(3)";
  //  string matchedList = actualList == expectedList ? "YES" : "FAILED";
    string matchedList2 = actualList2 == expectedList2 ? "YES" : "FAILED";
    cout << "Test if 'insertAt' can insert the list at index 0 successfully. Input list is empty and index 0, value 3, should be '(3)'"<<endl;
    cout << "Expected result of list: " + expectedList2 << endl;
    cout << "Actual result of list: " + actualList2 << endl;
     cout << "Does the actual result of list match the expected result of list? " + matchedList2 << endl;
    cout << "-----------------------------------------------" << endl;
   //test partitionBy
   string listString2 = "7 4 4 3 9";
   Node *listS = buildList(listString2);
   Node *m =partitionBy(listS,5);
   actualList2 = listToString(listS);
   expectedList2 = "(7 9)";
   matchedList2 = actualList2 == expectedList2 ? "YES" : "FAILED";
    cout << "Test if 'partitionBy' can partition the list at index 0 successfully. Input list is 7->4->3 and value 4, return value m should be '(4 4 3)' and list2 should be (7 9)"<<endl;
    cout << "Expected result of list: " + expectedList2 << endl;
    cout << "Actual result of list: " + actualList2 << endl;
    string actualReturn = listToString(m);
    cout << "Actual return of function:" << actualReturn << endl;
   
    string expectedReturn ="(4 4 3)";
    cout << "expected return of the function: " << expectedReturn << endl;
    string matchReturn = actualReturn == expectedReturn ? "YES" :"FAILED";
     cout << "Does the actual result of list match the expected result of list? " + matchedList2 << endl;
     cout << "Does the actual return of value bigger than number the expected resultt? " + matchReturn<< endl;
    cout << "-----------------------------------------------" << endl;
   listString2 = "7 4 4 3 9";
   listS = buildList(listString2);
   m =partitionBy(listS,4);
   actualList2 = listToString(listS);
   expectedList2 = "(7 4 4 9)";
   matchedList2 = actualList2 == expectedList2 ? "YES" : "FAILED";
    cout << "Test if 'partitionBy' can partition the list at index 0 successfully. Input list is 7->4->3 and value 4, return value m should be '(3)' and list2 should be (7 4 4 9)"<<endl;
    cout << "Expected result of list: " + expectedList2 << endl;
    cout << "Actual result of list: " + actualList2 << endl;
    actualReturn = listToString(m);
    cout << "Actual return of function:" << actualReturn << endl;
   
    expectedReturn ="(3)";
    cout << "expected return of the function :" << expectedReturn << endl;
    matchReturn = actualReturn == expectedReturn ? "YES" :"FAILED";
     cout << "Does the actual result of list match the expected result of list? " + matchedList2 << endl;
     cout << "Does the actual return of value bigger than number the expected resultt? " + matchReturn<< endl;
    cout << "-----------------------------------------------" << endl;
     listString2 = "7 4 4 3 9";
   listS = buildList(listString2);
   m =partitionBy(listS,0);
   actualList2 = listToString(listS);
   expectedList2 = "(7 4 4 3 9)";
   matchedList2 = actualList2 == expectedList2 ? "YES" : "FAILED";
    cout << "Test if 'partitionBy' can partition the list at index 0 successfully. Input list is 7->4->3 and value 4, return value m should be '(3)' and list2 should be (7 4 4 9)"<<endl;
    cout << "Expected result of list: " + expectedList2 << endl;
    cout << "Actual result of list: " + actualList2 << endl;
    actualReturn = listToString(m);
    cout << "Actual return of function:" << actualReturn << endl;
   
    expectedReturn ="()";
    cout << "expected return of the function :" << expectedReturn << endl;
    matchReturn = actualReturn == expectedReturn ? "YES" :"FAILED";
     cout << "Does the actual result of list match the expected result of list? " + matchedList2 << endl;
     cout << "Does the actual return of value bigger than number the expected resultt? " + matchReturn<< endl;
    cout << "-----------------------------------------------" << endl ; 
   listString2 = "";
   listS = buildList(listString2);
   m =partitionBy(listS,3);
   actualList2 = listToString(listS);
   expectedList2 = "()";
   matchedList2 = actualList2 == expectedList2 ? "YES" : "FAILED";
    cout << "Test if 'partitionBy' can partition the list at index 0 successfully. Input list is 7->4->3 and value 4, return value m should be '(3)' and list2 should be (7 4 4 9)"<<endl;
    cout << "Expected result of list: " + expectedList2 << endl;
    cout << "Actual result of list: " + actualList2 << endl;
    actualReturn = listToString(m);
    cout << "Actual return of function:" << actualReturn << endl;
   
    expectedReturn ="()";
    cout << "expected return of the function :" << expectedReturn << endl;
    matchReturn = actualReturn == expectedReturn ? "YES" :"FAILED";
     cout << "Does the actual result of list match the expected result of list? " + matchedList2 << endl;
     cout << "Does the actual return of value bigger than number the expected resultt? " + matchReturn<< endl;
    cout << "-----------------------------------------------" << endl;;
   
   return 0;
}

