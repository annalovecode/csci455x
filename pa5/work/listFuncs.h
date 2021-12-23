// Name: anna zhao
// USC NetID: annaz
// CSCI 455 PA5
// Fall 2021

//*************************************************************************
// Node class definition
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in *header* files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H

#include <string>

struct Node
{
  std::string key;
  int value;

  Node *next;

  Node(const std::string &theKey, int theValue);

  Node(const std::string &theKey, int theValue, Node *n);
};

typedef Node *ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

//check if the list contains target
bool contains(ListType &list, const std::string &target);

//Insert the key and value in front of the list
bool insertFront(ListType &list, const std::string &target, int value);

// makes list into an empty list
//   reclaiming memory used by nodes
// PRE: list is a well-formed list
// POST: list is NULL
bool deleteNode(ListType &list, const std::string &target);

// prints list elements, space separated, ending with '\n'
// prints emty list as "<empty>"
// PRE: list is a well-formed list
void printList(ListType &list);

//Search the key-associated value in the list
int *findNode(ListType list, const std::string &target);

//Return the number of entries in the list
int numberOfList(ListType &list);

//update key value pair
bool updateValue(ListType &list, const std::string &target, int value);
//insert key value pair in the end of the list
bool listAppend(ListType &list, const std::string &target, int value);

// keep the following line at the end of the file
#endif