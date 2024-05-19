//
// Created by compandreimd on 19.05.2024.
//

#include "HW1.hpp"
#include <iostream>
#include "../Macros.hpp"

using namespace std;

void homework::HW1::Media() {
    double MAX;
    cout << "Introduceti maximum pe salariu? ";
    cin >> MAX;

    int l1, l2, l3;
    cout << "Introduceti salariele a 3 luni?" << std::endl;
    cout << "Prima luna? ";
    cin >> l1;
    cout << "A doua luna? ";
    cin >> l2;
    cout << "A treia luna? ";
    cin >> l3;

    long sum = l1 + l2 + l3;
    cout << "Suma: " << sum << std::endl;
    cout << "Media: " << (sum / 3.0) << std::endl;
    cout << ANSI_YELLOW << "Suma depasit de " << MAX << ": " << (sum > MAX) << std::endl;
    cout << "Media depasita de " << MAX << ": " << ((sum / 3.0) > MAX) << std::endl;
    cout << ANSI_RESET;

}