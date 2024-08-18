package vars;

public class DemoVars {
    /**
     * boolean = true|false (1 bit)
     * byte = 2^8 (-128 ... 127) = 8 * bits
     * n
     */
    public String demo() {
        String name = "My name is Andrei. I am student QA!";
        System.out.println(name);
        System.out.println(name);
        System.out.println(name);
        System.out.println(name);
        return name;
        // byte n = -15;
        // -128| 64| 32| 16|  8|  4|  2|  1
        //  1 | 1 | 1 | 1 | 0 | 0 | 0 |  1
    }
}
