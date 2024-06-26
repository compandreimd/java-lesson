package oop;

//mostu
public class Oop{
    public native long malloc(int size);
    public native byte[] bytes(long addr);
    public native void free(long addr);

    public static void main(String[] args) {
        String OS = System.getProperty("os.name").toLowerCase();
        if(OS.contains("win"))
            System.load("C:\\Users\\Step\\IdeaProjects\\java-lesson\\jni\\build\\Debug\\mylib.dll");
        else
            System.load("/Users/compandreimd/java-lesson/jni/libmylib.dylib");
        Oop oop = new Oop();
        System.out.println(oop);
        long test = oop.malloc(100);
        System.out.println(Long.toString(test, 16));
        oop.free(test);
       Person person[] = {
               new Person("P", 29),
               new LicPerson("L", 20),
               new Medic("M", 30)
       };
       Animal animal[] = {
               new Animal(),
               new Cat(),
               new Caine()
       };
        for(Animal a : animal){
            a.mak();
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
