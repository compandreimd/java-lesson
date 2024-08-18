package homework;

public class HW5 {
    public static void main(String[] args) {
        Student s = new Student(), c = new Student();
        Student a = new Student("Jhon", 8), b = new Student("George",7) ;
        s.setName("Ana");
        s.setNota(10);
        System.out.println("Students("+Student.getStudents()+"):");
        System.out.println(s.getId() + ":" + s);
        System.out.println(a.getId() + ":" + a);
        System.out.println(b.getId() + ":" + b);
    }
}
