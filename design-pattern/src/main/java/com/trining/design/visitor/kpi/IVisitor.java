package com.trining.design.visitor.kpi;


public interface IVisitor {

    void visit(Engineer engineer);

    void visit(Manager manager);

}
