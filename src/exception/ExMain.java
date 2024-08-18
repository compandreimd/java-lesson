package exception;

import java.io.File;
import java.io.IOException;

public class ExMain {
    private int age = 0;

    public static void main(String[] args)  {
        //Runtime div by 0
        int age = 17;
        ExMain ex = new ExMain();
        try {
            ex.setAge(age);
        } catch (AgeLimitException e) {
            try {
                ex.setAge(age+1);
            } catch (AgeLimitException exc) {
                System.out.println(exc);
            }
        }
        System.out.println(ex.getAge());
    }
    void creazaFile() // 1. throws IOException
    {
        File f = new File("~/java.txt");
        //Compilation
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("IO_EX");
        } catch (Exception ex){
            System.out.println("EX");
        }
        finally {
            f = null;
            System.out.println("FINE");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeLimitException {
        if(age < 18)
            throw new AgeLimitException();
        this.age = age;
    }
}
