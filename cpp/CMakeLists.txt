project("j_lesson")
add_executable(main  Macros.hpp
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