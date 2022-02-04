package com.company;

public class Main {

    public static void main(String[] args) {
        Word<Generator> w = new Word<>();
        Block<Generator> b1 = new Block<>(Generator.A, 1);
        Block<Generator> b2 = new Block<>(Generator.B, 6);
        Block<Generator> b3 = new Block<>(Generator.B, -1);
        Block<Generator> b4 = new Block<>(Generator.C, 0);
        Block<Generator> b5 = b1;
        Block<Generator> b6 = new Block<>(Generator.A, -1);

        w.add(b1);
        w.add(b2);
        w.add(b3);
        w.add(b4);
        w.add(b5);
        w.add(b6);

        System.out.println("w = " + w);
        System.out.println("Is w reduced?\n" + w.isReduced());

        FreeGroupElement<Generator> g = new FreeGroupElement<>(w);
        System.out.println("g = " + g);

    }
}

