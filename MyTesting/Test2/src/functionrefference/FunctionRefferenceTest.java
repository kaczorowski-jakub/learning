package functionrefference;

import java.util.function.Function;

public class FunctionRefferenceTest {
    public static void main(String[] args) {

        // static call
        FunctionalInterfaceTest fit1 = FunctionRefferenceTest::func1; // (a,b) -> FunctionRefferenceTest.func1(a,b)
        FunctionalInterfaceTest fit11 = (a, b) -> FunctionRefferenceTest.func1(a, b);
        System.out.println(fit1.calculate(1, 2));

        
        // object call
        FunctionalInterfaceTest fit2 = new FunctionRefferenceTest()::func2;
        FunctionalInterfaceTest fit22 = (a, b) -> new FunctionRefferenceTest().func2(a, b);
        System.out.println(fit2.calculate(1, 2));
        FunctionRefferenceTest frt = new FunctionRefferenceTest();
        FunctionalInterfaceTest fit21 = frt::func2;
        System.out.println(fit21.calculate(1, 2));
        FunctionalInterfaceTest fit212 = (a, b) -> frt.func2(a, b);

        
        // arbitrary object call
        Function<String, Integer> fun1 = String::length;
        Function<String, Integer> fun12 = a -> a.length();
        System.out.println(fun1.apply("ABCD"));

        FunctionalInterfaceArbitraryTest fiat = String::toString;
        System.out.println(fiat.print("ABCD"));

        FunctionalInterfaceArbitraryTest2 fiat2 = Person::toString;
        FunctionalInterfaceArbitraryTest2 fiat21 = p -> p.toString();
        System.out.println(fiat2.print(new Person("Kuba", 37)));

        FunctionalInterfaceArbitraryTest3 fiat3 = Person::toStringPlus;
        FunctionalInterfaceArbitraryTest3 fiat31 = (p, agePlus) -> p.toStringPlus(agePlus);
        System.out.println(fiat3.print(new Person("Kuba", 37), 13));

        Function<Person, String> fun2 = Person::toString;
        System.out.println(fun2.apply(new Person("Jan", 99)));

        
        // constructor call
        FunctionalInterfaceArbitraryTest4 fiat4 = Person::new;
        System.out.println(fiat4.print());
        
        FunctionalInterfaceArbitraryTest5 fiat5 = Person::new;
        System.out.println(fiat5.print("Kazik", 65));
        
        //FunctionalInterfaceArbitraryTest6 fiat6 = Person::new;
    }

    public static String func1(int a, int b) {
        return a + " - " + b;
    }

    public String func2(int a, int b) {
        return a + " ---> " + b;
    }

}
