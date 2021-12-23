// Name: anna zhao
// USC NetID: annaz
// CSCI 455 PA5
// Fall 2021

#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue)
{
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n)
{
  key = theKey;
  value = theValue;
  next = n;
}

//*************************************************************************
// put the function definitions for your list functions below

/**Check whether the key exist in the list
 *@param list: the list to be checked
 *@param target: the key of the entry
 *@return true if the key exist
 */

bool contains(ListType &list, const string &target)
{
  ListType node = list;
  while (node != NULL)
  {
    if (node->key == target)
    {
      return true;
    }
    node = node->next;
  }

  return false;
}
/**Insert the key and value in front of the list, if the key-value pair already exists, then nothing changes.
 *@param list: the list to insert the entry
 *@param key: the key of the entry
 *@param value: the value of the entry
 *@return true if the insertion is successful
 */
bool insertFront(ListType &list, const string &target, int value)
{
  if (contains(list, target))
  {
    cout << "error: already have target value" << endl;
    return false;
  }
  list = new Node(target, value, list);
  return true;
}

/**Print every entry in the list
 *@param list: the list to print the entry
 */
void printList(ListType &list)
{

  if (list == NULL)
  {
    cout << "<empty>" << endl;
  }

  for (Node *p = list; p != NULL; p = p->next)
  {
    cout << p->key << "  " << p->value << endl;
  }
}

/**Search the key-associated value in the list
 *@param list: the list to search the value
 *@param target: the key of the entry
 *@return the value, if the key doesn't exist, return NULL
 */

int *findNode(ListType list, const string &target)
{
  ListType p = list; // 0 element
  if (list == NULL)
  {
    return NULL;
  }

  while (p != NULL)
  {
    string str = p->key;
    if (str == target)
    {
      return &(p->value);
    }
    p = p->next;
  }
  return NULL;
}

/**Remove the key-associated entry in the list
 *@param list: the list to remove the entry
 *@param target: the key of the entry
 *@return true if the removement is successful
 */
bool deleteNode(ListType &list, const string &target)
{

  if (list == NULL)
  {
    cout << "It's an empty list!" << endl;
    return false;
  }

  ListType node = list;
  ListType pre = NULL;
  while (node != NULL)
  {
    if (node->key == target)
    {
      if (pre == NULL)
      {
        list = list->next; // when the first node gets removed
      }
      else
      {
        pre->next = node->next;
        delete node;
      }
      return true;
    }
    pre = node;
    node = node->next;
  }

  return false;
}

/**Return the number of entries in the list
 *@param list: the list to return the number
 *@return the number of entries in the list
 */
int numberOfList(ListType &list)
{
  ListType node = list;
  int num = 0;

  while (node != NULL)
  {
    num++;
    node = node->next;
  }
  return num;
}
/**Append a key-value pair at the end of the list
 *@param list: the list to append the entry
 *@param target: the key of the entry
 *@param value: the value of the entry
 *@return true if the append is successful
 */
bool listAppend(ListType &list, const string &target, int value)
{
  if (contains(list, target))
  {
    cout << "Key already exist, append failed.";
    return false;
  }
  ListType node = list;
  ListType newNode = new Node(target, value);
  if (node == NULL)
  {
    list = newNode;
    return true;
  }
  while (node->next != NULL)
  {
    node = node->next;
  }
  node->next = newNode;
  return true;
}

/**Append a key-value pair at the end of the list
 *@param list: the list to append the entry
 *@param target: the key of the entry
 *@param value: the value of the entry
 *@return true if the append is successful
 */
bool updateValue(ListType &list, const string &target, int value)
{

  int *oldValue = findNode(list, target);
  if (oldValue != NULL)
  {
    *oldValue = value;
    return true;
  }
  else
  {
    cout << "Key doesn't exist, update failed!" << endl;
    return false;
  }
}
