package main.java.oop;

import main.java.oop.demo.Per;

//mostu
public class Oop{
   // public native long malloc(int size);
    //public native byte[] bytes(long addr);
  //  public native void free(long addr);

    public static void main(String[] args) {
        String OS = System.getProperty("os.name").toLowerCase();
        Bus bus = new Bus();
        if(OS.contains("win"))
            System.load("C:\\Users\\Step\\IdeaProjects\\java-lesson\\jni\\build\\Debug\\mylib.dll");
        else
            System.load("/Users/compandreimd/java-lesson/jni/libmylib.dylib");
        Oop oop = new Oop();
        System.out.println(oop);
      //  long test = oop.malloc(100);
      //  System.out.println(Long.toString(test, 16));
      //  oop.free(test);
       Person person[] = {
               new Person("P", 29, "MMM"),
               new Employee("L", 20, "AA"),
               new Manager("M", 30, "AAA")
       };
       Animal animal[] = {
               new Cat(),
               new Caine()
       };
        for(Animal a : animal){
            a.makeSound();
        }
        for (int i = 0; i < person.length; i++) {
            if(person[i] instanceof Medic){
                Medic p = (Medic) person[i];
                System.out.println("Medic:" + p.toString());
            } else if(person[i] instanceof LicPerson){
                LicPerson p = (LicPerson) person[i];
                System.out.println("Lic Persona:" + p.toString());
            }
            else {
                Person p = person[i];
                System.out.println("Persona:" + p.toString());
            }
        }
        Per pp = new Per(30);
        Per p2 = new Per(20);
        Per.bonus = 45;
        System.out.println(pp.getSalariuWithBonus());
        System.out.println(p2.getSalariuWithBonus());
    }
}
