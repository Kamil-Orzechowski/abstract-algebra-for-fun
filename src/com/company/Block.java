package com.company;

record Block<E extends Enum<E>>(E generator, int exponent) {

    @Override
    public String toString() {
        return generator.name() + "^" + exponent;
    }

}
