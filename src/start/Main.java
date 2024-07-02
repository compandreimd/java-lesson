package start;

import cicle.Whl;
import clazz.App;
import clazz.DemoEx;
import clazz.Point;
import condition.Sw;
import forloop.ForLoop;
import game.UFO;
import homework.HW2;
import homework.HW3;
import homework.HW4;
import homework.Student;
import method.Mth;
import oop.Oop;
import org.jetbrains.annotations.NotNull;
import sir.SIr;
import sir.Sir2D;

import java.util.*;

public class Main {
    private static String END = "exit";

    public static boolean isRepeat(@NotNull String arg) {
        return arg.contentEquals("1") || arg.contentEquals("yes") || arg.contentEquals("y");
    }


    private static String choose(Scanner scanner, @NotNull Dictionary<String, Runnable> dic) {
        Enumeration<String> eKeys = dic.keys();
        List<String> keys = new ArrayList<>();
        dic.put(END, () -> {
        });
        while (eKeys.hasMoreElements()) {
            keys.add(eKeys.nextElement());
        }
        keys.sort((a, b) -> {
            return (a.compareTo(END) != 0 ? 0 : 100) + a.compareTo(b);
        });
        String choose;
        do {
            System.out.println("Choose from (" + String.join(", ", keys) + ") ?");
            choose = scanner.nextLine();

        } while (!keys.contains(choose));
        dic.get(choose).run();
        return choose;
    }

    public static void GetProps(){
        Properties properties = System.getProperties();
        properties.list(System.out);
    }
    public static void main(String[] args) {
        GetProps();
        Scanner scan = new Scanner(System.in);
        Hashtable<String, Runnable> table = new Hashtable();

        table.put("cicle", () -> {
            Whl.main(args);
        });
        table.put("clazz", () -> {
            Hashtable<String, Runnable> kidTable = new Hashtable();
            kidTable.put("App", () -> {
                App.main(args);
            });
            kidTable.put("DemoEx", () -> {
                DemoEx.main(args);
            });
            kidTable.put("Point", () -> {
                Point.main(args);
            });
            while (!choose(scan, kidTable).equals(END)) ;
        });
        table.put("condition", () -> {
            Sw.main(args);
        });
        table.put("forloop", () -> {
            ForLoop.main(args);
        });
        table.put("game", () -> {
            UFO.main(args);
        });
        table.put("graph", () -> {
            graph.UFO.main(args);
        });
        table.put("homework", () -> {
            Hashtable<String, Runnable> kidTable = new Hashtable();
            kidTable.put("HW2", () -> {
                HW2.main(args);
            });
            kidTable.put("HW3", () -> {
                HW3.main(args);
            });
            kidTable.put("HW4", () -> {
                HW4.main(args);
            });
            kidTable.put("Student", () -> {
                Student.main(args);
            });
            while (!choose(scan, kidTable).equals(END)) ;
        });
        table.put("method", () -> {
            Mth.main(args);
        });
        table.put("oop", () -> {
            Oop.main(args);
        });
        table.put("sir", () -> {
            Hashtable<String, Runnable> kidTable = new Hashtable();
            kidTable.put("Sir", () -> {
                SIr.main(args);
            });
            kidTable.put("Sir2D", () -> {
                Sir2D.main(args);
            });
            while (!choose(scan, kidTable).equals(END)) ;
        });
        table.put("start", () -> {
            Hashtable<String, Runnable> kidTable = new Hashtable();
            kidTable.put("Andrei", () -> {
                Andrei.main(args);
            });
            kidTable.put("DemoStart", () -> {
                DemoStart.main(args);
            });
            kidTable.put("Main", () -> {
                main(args);
            });
            while (!choose(scan, kidTable).equals(END)) ;
        });


        while (!choose(scan, table).equals(END)) ;

    }
}
