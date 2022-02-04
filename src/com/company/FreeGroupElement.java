package com.company;

record FreeGroupElement<E extends Enum<E>>(Word<E> representative) {

    FreeGroupElement {
        if (!representative.isReduced()) {
            representative.reduce();
        }
    }

    @Override
    public String toString() {
        return representative.toString();
    }
}
