package com.cad.jvm;


public class TestTransferValue {

    public void changeValue1(int age) {
        age = 30;
    }
    public void changeValue2(Person person) {
        person.setPersonName("xxx");
    }
    public void changeValue3(String str) {
        str = "xxx";
    }

    public static void main(String[] args) {

        TestTransferValue test = new TestTransferValue();
        int age = 20;
        test.changeValue1(age);

        System.out.println("age------" + age);//20

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName-----" + person.getPersonName());//xxx

        String str = "abc";
        test.changeValue3(str);
        System.out.println("String------" + str);//abc
    }
}


class Person {

    private String personName;

    public Person(String str) {
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

}
