// Name: anna zhao
// USC NetID: annaz
// CSCI 455 PA5
// Fall 2021

// Table.cpp  Table class implementation

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

// for hash function called in private hashCode method defined below
#include <functional>

using namespace std;

// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"

//*************************************************************************

/**Constructor of table class using default table size
 */
Table::Table()
{
  hashTable = new ListType[HASH_SIZE];
  hashSize = HASH_SIZE;
  for (int i = 0; i < hashSize; i++)
  {
    hashTable[i] = NULL;
  }
}

/**Constructor of table class using hsize as table size
 */
Table::Table(unsigned int hSize)
{
  hashTable = new ListType[hSize];
  hashSize = hSize;
  for (int i = 0; i < hashSize; i++)
  {
    hashTable[i] = NULL;
  }
}

/** return the address of the value that goes with this key
 *@param key: the key of the entry
 *@return m:true if the insertion is successful
 */
int *Table::lookup(const string &key)
{
  //unsigned int hash=hashCode(key);
  ListType bucket = hashTable[hashCode(key)];

  return findNode(bucket, key);
}

/** remove key
	@ param key
	@return:boolean ,if the remove can make or not.
*/
bool Table::remove(const string &key)
{
  ListType bucket = hashTable[hashCode(key)];
  return deleteNode(bucket, key); // dummy return value for stub
}

/** insert key ,value pair into the table
* @ param key,value
	@ return boolean whether the insertion can manage or not
*/
bool Table::insert(const string &key, int value)
{
  unsigned int hash = hashCode(key);
  return insertFront(hashTable[hash], key, value);
}

/**Return the number of entries in the table
 *@return the number of entries in the table
 */
int Table::numEntries() const
{
  int sum = 0;
  for (int i = 0; i < hashSize; i++)
  {
    sum += numberOfList(hashTable[i]);
  }
  return sum;
}

/**print out total list
*/
void Table::printAll() const
{
  for (int i = 0; i < hashSize; i++)
  {
    if (hashTable[i] != NULL)
    {
      printList(hashTable[i]);
    }
  }
}

/** Print out the hash table statistics
 * The number of buckets, the number of entries, the number of non-empty buckets, and the longest chain
 */
void Table::hashStats(ostream &out) const
{
  cout << "number of buckets: " << hashSize << endl;
  cout << "number of entries: " << numEntries() << endl;
  cout << "number of non-empty buckets: " << numberOfNonEmptyBuckets() << endl;
  cout << "longest chain: " << longestChain() << endl;
}

// hash function for a string
// (we defined it for you)
// returns a value in the range [0, hashSize)
unsigned int Table::hashCode(const string &word) const
{

  // Note: calls a std library hash function for string (it uses the good hash
  //   algorithm for strings that we discussed in lecture).
  return hash<string>()(word) % hashSize;
}

// add definitions for your private methods here

/**Return the number of non-empty buckets in the table
 *@return the number of non=empty buckets in the table
 */
int Table::numberOfNonEmptyBuckets() const
{
  int num = 0;
  for (int i = 0; i < hashSize; i++)
  {
    if (hashTable[i] != NULL)
    {
      num++;
    }
  }
  return num;
}

/**Return the number of longest chain in the table
 *@return the number of longest chain in the table
 */
int Table::longestChain() const
{
  int longest = 0;
  for (int i = 0; i < hashSize; i++)
  {
    if (numberOfList(hashTable[i]) > longest)
    {
      longest = numberOfList(hashTable[i]);
    }
  }
  return longest;
}
