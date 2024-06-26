cmake_minimum_required(VERSION 3.27)
project("j_lesson")
include_directories(
C:\\Program\ Files\\Java\\jdk-17\\include
C:\\Program\ Files\\Java\\jdk-17\\include\\win32
C:\\Program\ Files\\Java\\jdk-17\\include\\win32\\bridge
/Library/Java/JavaVirtualMachines/jdk-1.8.jdk/Contents/Home/include/
/Library/Java/JavaVirtualMachines/jdk-1.8.jdk/Contents/Home/include/darwin
)

add_library(mylib SHARED lib.c)
