package com.hgc.visitor;

public class Client {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor visitor) {
        this.cpu.accept(visitor);
        this.board.accept(visitor);
        this.memory.accept(visitor);
    }
    public static void main(String[] args) {
        Client client = new Client();
        Visitor personVisitor = new PersonVisitor();
        client.accept(personVisitor);
        System.out.println(((PersonVisitor) personVisitor).totalPrice);

        Visitor companyVisitor = new CompanyVisitor();
        client.accept(companyVisitor);
        System.out.println(((CompanyVisitor) companyVisitor).totalPrice);
    }
}
