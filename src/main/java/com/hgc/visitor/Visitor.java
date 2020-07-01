package com.hgc.visitor;

public interface Visitor {
    public void visitCPU(CPU cpu);
    public void visitMemory(Memory memory);
    public void visitBoard(Board board);
}
