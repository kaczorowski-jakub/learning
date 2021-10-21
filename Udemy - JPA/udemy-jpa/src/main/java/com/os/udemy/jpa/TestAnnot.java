package com.os.udemy.jpa;

public @interface TestAnnot {
    String req();
    String opt() default "A";
    String[] arr();
}
