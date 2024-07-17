cmake_minimum_required(VERSION 3.20)
project("j_lesson")
include_directories(".")
add_executable(main start/Main.cpp

        access/Ac.hpp
        access/Ac.cpp
        cicle/Whl.hpp
        cicle/Whl.cpp
        helper/impl/JObject.hpp
        helper/impl/JString.hpp
        helper/impl/JObject.cpp
        helper/impl/JString.cpp
        helper/Macros.hpp
        homework/HW1.cpp
        homework/HW1.hpp
        oop/access/A.cpp
        oop/access/D.cpp
        oop/access/A.hpp
        oop/access/lvl
        oop/access/lvl/N.hpp
        oop/access/lvl/N.cpp
        oop/access/D.hpp
        start/Main.hpp
        start/Main.cpp
        oper/Operation.cpp
        oper/Operation.hpp
        vars/DemoVars.hpp
        vars/DemoVars.cpp

        )
add_executable(demoStart start/DemoStart.cpp)
add_executable(andrei start/Andrei.cpp)