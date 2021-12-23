#include <iostream>
#include <vector>
using namespace std;
vector<int> readVals();
void printVals(vector<int> v);
// returns a vector of values from v that are greater than 0
// these values are in the same relative order as they are in v.
vector<int> valsGT0(vector<int> v);
/**
 * returns location of last instance of target in v or -1 if not found
 */ 
int findLast(vector<int> v, int target);
int main(){
  vector<int> nums = readVals();
  //cout << "% filt < somevals";
  //cout <<endl;
  //vector<int> nums = readVals();
  cout<< "Vector: ";
  printVals(nums);
  vector<int> filt = valsGT0(nums);
  cout<< "Filtered vector: ";
  printVals(filt);
  //cout<< "The last instance of "<< "7 "<< "is at position" <<findLast(filt,7); 
  //cout<< "The last instance of "<< "10 "<< "is at position" <<findLast(filt,10); 
  cout << "Original vector: ";
  printVals(nums);
  return 0;
}
vector<int> readVals(){
   int vals;
   vector<int> nums;
   //cout << "Enter numbers:";
   while(cin >> vals){
    nums.push_back(vals);
  }
  return nums;
}
void printVals(vector<int> nums){
   for(int i=0;i<nums.size();i++){
      cout << nums[i] << " ";
   }
   cout <<endl;
   
}
// returns a vector of values from v that are greater than 0
// these values are in the same relative order as they are in v.
vector<int> valsGT0(vector<int> nums){
  vector<int> filt;
  for(int i = 0; i < nums.size(); i++){
    if(nums[i] > 0){
      filt.push_back(nums[i]);
    }
  }
  return filt;
   
}
/**
 * returns location of last instance of target in v or -1 if not found
 */ 
int findLast(vector<int> nums, int target){
   for(int i=nums.size()-1;i>=0;i--){
      if(nums[i]==target){
         return i;
      }
   }
   return -1;
   
}