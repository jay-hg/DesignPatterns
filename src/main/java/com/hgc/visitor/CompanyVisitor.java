package com.hgc.visitor;

public class CompanyVisitor implements Visitor {
    double totalPrice = 0.0;
    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += 0.9*cpu.getPrice();
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += 0.75*memory.getPrice();
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += 0.66*board.getPrice();
    }
}
