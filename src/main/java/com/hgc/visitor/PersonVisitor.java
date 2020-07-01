package com.hgc.visitor;

public class PersonVisitor implements Visitor {
    double totalPrice = 0.0;
    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice();
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice();
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice();
    }
}
