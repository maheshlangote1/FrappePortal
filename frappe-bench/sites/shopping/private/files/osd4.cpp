#include <iostream>
#include <windows>

using namespace std;

int main(){ 
        GetFirmwareEnvironmentVariable("", "{00000000-0000-0000-0000-000000000000}", NULL, 0);
        if (GetLastError() == ERROR_INVALID_FUNCTION) {
                cout << endl << "Legacy  BIOS detected.";
        } else{
                cout << endl << "UEFI detected.";
        }
        cin.get();
        return 0;
}

