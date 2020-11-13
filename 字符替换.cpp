#include <string>
#include <iostream>
using namespace std;

string modifyString(string s) {
    int p=1;
    if(s[0]=='?')
        s[0]=s[1]=='a'?'b':'a';
    while (p<s.length()-1){
        if(s[p]!='?'){
            p++;
            continue;
        }
        char tmp='a';
        while (!(tmp!=s[p-1] && tmp!=s[p+1])){
            tmp++;
        }
        s[p]=tmp;
        p++;
    }
    if(s[s.length()-1]=='?'){
        s[s.length()-1]=s[s.length()-2]=='a'?'b':'a';
    }
    return s;
}

int main(int argc, char const *argv[]){
    string s=modifyString("??");
    std::cout << s << std::endl;
    return 0;
}
