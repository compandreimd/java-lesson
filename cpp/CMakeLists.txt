cmake_minimum_required(VERSION 3.20)
project("j_lesson")
include_directories(".")
add_executable(main  Macros.hpp
        cicle/Whl.cpp
        cicle/Whl.hpp
        start/Main.cpp
        start/Main.hpp
        start/Andrei.hpp
        start/DemoStart.hpp
        oper/Operation.cpp
        oper/Operation.hpp
        vars/DemoVars.cpp
        vars/DemoVars.hpp
        homework/HW1.cpp
        homework/HW1.hpp

        )
add_executable(demoStart start/DemoStart.cpp)
add_executable(andrei start/Andrei.cpp)