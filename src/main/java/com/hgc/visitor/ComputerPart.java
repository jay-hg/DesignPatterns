package com.hgc.visitor;

/**
 * 节点的继承
 */
public interface ComputerPart {
    public void accept(Visitor visitor);
    public double getPrice();
}
