package main;

import system.System;

public class Main {

    public static void main (String[] args) {
        System system = new System("configDefault.properties", 20);
        system.start();
    }

}
