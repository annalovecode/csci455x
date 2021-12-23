#include <iostream>
#include <vector>
using namespace std;
vector<int> readVals();
void printVals(vector<int> v);
int main(){
  vector<int> nums = readVals();
  printVals(nums);
  return 0;
}
vector<int> readVals(){
   int vals;
   vector<int> nums;
   cout << "Enter numbers:";
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