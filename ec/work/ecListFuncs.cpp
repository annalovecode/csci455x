
/*  Name:Anna Zhao
 *  USC NetID: annaz
 *  CS 455 Fall 2021
 *
 *  See ecListFuncs.h for specification of each function.
 *
 */

#include <string>
#include <cassert>

// for istringstream
#include <sstream>

#include "ecListFuncs.h"

using namespace std;

// *********************************************************
// Node constructors: do not change
Node::Node(int item) { 
   data = item;
   next = NULL;
}

Node::Node(int item, Node *n) {
   data = item;
   next = n;
}
// *********************************************************


ListType buildList(const string & listString) {

    istringstream iss(listString);
    string num;
    Node *node = NULL;
    Node * newList = NULL;
    Node *nodeNext =NULL;
    while (iss >> num) {
          node = new Node(stoi(num), node);
          nodeNext = node->next;
          node->next = newList;
          newList = node;
          node = nodeNext;
    }
    Node * prev = NULL;
    while(newList != NULL) {
            Node * nxt = newList->next;
            newList->next = prev; 
            prev = newList; 
            newList = nxt; 
        }
   return prev;
  }
   

string listToString(ListType list) {
   
   if (list == NULL) {
        return "()";
    }

    Node *p = list;
    if(p->next ==NULL){
       string str="(";
       str = str + to_string(p->data) + ")";  
       return str;
    }
   else{
     string str="(";
    while (p->next != NULL) {
        str = str + to_string(p->data) + " ";
        p = p->next;
    }
    str = str + to_string(p->data) + ")";
      return str;
   }
}


void insertAt(ListType & list, int index, int value) {
   ListType node= new Node(value);
   Node *p = list;
   if(list== NULL){
      if(index>0){
         return;
      }
      if(index == 0){
         //Node *s=list;
         node->next=list;
         list=node;
        
      }
   }
   else{
      if(index == 0){
         node->next = list;
         list=node;
      }
      else{
      for (int i = 0; i < index - 1; i++) {
            p = p->next;
        }
        Node *nextNode =p->next;
        p->next = node;
         node->next= nextNode;
       }
     }
   }
   


ListType partitionBy(ListType & list, int number) {
   ListType m = NULL;
  // ListType s = m;
   if(list==NULL){
      return m;
   }
   else{
      Node *q=list;
      Node *p=list->next;
      Node *pre;
      while(p!= NULL){
         if((p->data) < number){
            q->next =p->next;
            pre= p;
            p=q->next;
            insertAt(m,0,pre->data);
            delete pre;
         }
         else{
            q=p;
            p=p->next;
         }
      }
      Node * prev = NULL;
      while(m!=NULL){
          Node * nxt = m->next;
            m->next = prev; 
            prev = m; 
            m = nxt; 
        }
      return prev;
         
      }
   
   return m;
   
}


