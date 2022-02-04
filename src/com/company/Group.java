package com.company;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

record Group<E>(E neutralElement, BinaryOperator<E> groupOperation, UnaryOperator<E> inverse) {

    E raiseToPower(E groupElement, int exponent) {

        E result = neutralElement();

        if (exponent > 0) {
            for (int i = 1; i <= exponent; i++) {
                result = groupOperation().apply(result, groupElement);
            }
        }
        if (exponent < 0) {
            result = inverse().apply(raiseToPower(groupElement, -exponent));
        }

        return result;
    }


}
