package com.company;

import java.util.Scanner;

public class Animal {

    String name;
    int legs;
    String speaks;
    String eats;
    protected Animal(String name, int legs, String speaks, String eats){
        this.name = name;
        this.legs =legs;
        this.speaks=speaks;
        this.eats=eats;
    }
    void isDoing()
    {
        System.out.println(this.name+ " is eating " + this.eats
        );
    }
}
