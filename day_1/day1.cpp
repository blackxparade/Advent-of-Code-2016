#include <iostream>
#include <fstream>
#include <string>
#include <cstring>
using namespace std;

int main() {
  string line;
  string input = "";
  ifstream myfile ("day1.txt");
  if (myfile.is_open()) {
    while ( getline (myfile,line) ){
      //cout << line << '\n';
      input += line;
    }
    myfile.close();
  }
  else cout << "Unable to open file";
  cout << input << endl;


  char input_c[input.size()+1];//as 1 char space for null is also required
  strcpy(input_c, input.c_str());



  return 0;
}
