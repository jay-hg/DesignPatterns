package com.hgc.visitor;

public class CPU implements ComputerPart {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitCPU(this);
    }

    @Override
    public double getPrice() {
        return 500;
    }
}
