//
// Created by compandreimd on 17.07.2024.
//

#ifndef J_LESSON_CLAZZ_APP_HPP
#define J_LESSON_CLAZZ_APP_HPP
namespace clazz {
    class App {
    public:
        static void main();
    };

    class Car {
        int price;
        char *color;
        int kms;
    public:
        int getPrice();
        char *getColor();
        int getKMS();
        void setColor(const char *color);
        void setKMS(int kms);
        void setPrice(int price);
    };

    class DemoEx {
    public:
        static void main();
    };

    class DemoThis {
        char *name;
        int salariu;
    public:
        DemoThis();
        DemoThis(const char *name, int salariu);
        void setName(const char *name);
        void setSalariu(int salariu);
        char* getName();
        int getSalariu();
    };
}

#endif //J_LESSON_CLAZZ_APP_HPP
