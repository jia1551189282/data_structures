package com.jiajia.study;

/**
 * @Author zjiajia
 * @Date 2020/8/19 19:40
 */


public class Person {

    private String userName;

    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
