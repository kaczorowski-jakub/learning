package com.os.udemy.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (1) upper bounded wildcards (extends) to read lower bounded wildcards (super)
 * to manipulate
 * 
 * (2) upper bounded wildcard cannot be treated as immutability secure because
 * we can add(null) or sort the collection
 * 
 * (3) T types can be used only in class definition or method when wildcars in
 * the code like List<? super Number> a = new ArrayList<>();
 * 
 * (4) wildcards are unknown types and we dont have access to the type T we have
 * access to the type
 * 
 * (5) wildcards we can have a single bound (extends or super) T can have
 * multiple bounds like <T extends A,B,C>
 * 
 * @author jakub.kaczorowski
 *
 */
/**
 * As others have pointed out, this:
 * 
 * class MyOtherClass <T extends OtherInterface & SomeInterface> 
 * defines a
 * multiply bounded type parameter. If you use MyOtherClass, you must give it a
 * type that implements both OtherInterface and SomeInterface.
 * 
 * However, this does not define a multiply bounded type parameter:
 * 
 * class MyClass <T extends OtherInterface, SomeInterface> 
 * It defines a generic
 * with two type parameters. The first one must implement OtherInterface. The
 * second one can be anything. It's just the same as
 * 
 * class MyClass <T extends OtherInterface, U> except that you named it
 * SomeInterface instead of U. (The convention is that type parameters are
 * normally single upper-case letters, or sometimes an upper-case letter and a
 * digit or a short upper-case identifier. But the compiler doesn't care. It
 * won't look at the form of the identifier to figure out that you really meant
 * it as an interface.)
 * 
 * @author jakub.kaczorowski
 *
 */
public class WildcardsVsGenericParameter {
    public static void main(String[] args) {

        // (5)
        MyClass2 myClass2 = new MyClass2();
        test(myClass2);

        MyClass myClass = new MyClass();
        // test(myClass);
        // The method test(T) in the type WildcardsVsGenericParameter
        // is not applicable for the arguments (MyClass)

        // List<? super Number, Serializable> list = new ArrayList<>();
        // I ncorrect
        // number of arguments for type List<E>; it cannot be parameterized with
        // arguments <? super Number, Serializable>
    }

    private static <T extends MyClass & Comparable<T>> void test(T elem) {
        System.out.println(elem);

    }
}

class MyClass {

}

class MyClass2 extends MyClass implements Comparable<MyClass2> {

    @Override
    public int compareTo(MyClass2 o) {
        // TODO Auto-generated method stub
        return 0;
    }

}