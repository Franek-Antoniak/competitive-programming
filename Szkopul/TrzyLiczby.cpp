#include <iostream>
 
int main()
{
  int max = -2147483648;
  int input;
  for(int i=0; i<3; i++){
    std:: cin >> input;
    if(input>max){
      max = input;
    }
  }
  std:: cout << max;
  return(0);
}