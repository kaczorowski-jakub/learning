package misc;

public class Atom {
    Atom() {
        System.out.println("atom");
    }
}

class Rock extends Atom {
    Rock(String type) {
        System.out.println(type);
    }
}

class Mountain extends Rock {
    Mountain() {
        super("granite");
        new Rock("granite");
    }
}
