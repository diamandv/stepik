package org.diamandv;

import java.util.Objects;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || (getClass() != otherObject.getClass())) return false;
        ComplexNumber complexNumber = (ComplexNumber) otherObject;
        return re == complexNumber.re
                && im == complexNumber.im;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}