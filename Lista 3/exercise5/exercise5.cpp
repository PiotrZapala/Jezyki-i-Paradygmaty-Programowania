#include "exercise2.cpp"
#include <vector>

using namespace std;

class Hamming {

public:
    const int prime = 2;
    const int size = 7;
    Polynomial<GaloisField<int>> encoded;
    Polynomial<GaloisField<int>> message;

public:

    Hamming() {
        Polynomial<GaloisField<int>>;
    }

    Hamming(const Polynomial<GaloisField<int>> m) {
        this->message = m;
        GaloisField<int> coe(2, 0);
        for(int i = 0; i < size; i++) {
            this->encoded.c[i] = coe;
        }
    }

    Polynomial<GaloisField<int>> encode() {
        encoded.c[0] = message.c[0] + message.c[3];
        encoded.c[1] = message.c[1] + message.c[3];
        encoded.c[2] = message.c[2] + message.c[3];
        encoded.c[3] = message.c[0] + message.c[1] + message.c[3];
        encoded.c[4] = message.c[0] + message.c[2] + message.c[3];
        encoded.c[5] = message.c[1] + message.c[2] + message.c[3];
        encoded.c[6] = message.c[0] + message.c[1] + message.c[2] + message.c[3];

        return encoded; 
    }

};