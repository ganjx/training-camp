package com.trining.design.visitor.runoob;

public interface ComputerPart {

    public void accept(ComputerPartVisitor computerPartVisitor);
}