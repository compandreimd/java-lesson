package oop;

//mostu
public class Oop{
    public native long malloc(int size);
    public native void 

    public static void main(String[] args) {
        System.load("C:\\Users\\Step\\IdeaProjects\\java-lesson\\jni\\build\\Debug\\mylib.dll");
        Oop oop = new Oop();
        System.out.println(oop);
        long test = oop.test();
        System.out.println(Long.toString(test, 16));
       Person person[] = {
               new Person("P", 29),
               new LicPerson("L", 20),
               new Medic("M", 30)
       };
       Animal animal[] = {
               new Animal(),
               new Pisica(),
               new Caine()
       };
        for(Animal a : animal){
            a.voice();
        }
        for (int i = 0; i < person.length; i++) {
            if(person[i] instanceof Medic){
                Medic p = (Medic) person[i];
                System.out.println("Medic:" + p);
            } else if(person[i] instanceof LicPerson){
                LicPerson p = (LicPerson) person[i];
                System.out.println("Lic Persona:" + p);
            }
            else {
                Person p = person[i];
                System.out.println("Persona:" + p);
            }
        }
    }
}
