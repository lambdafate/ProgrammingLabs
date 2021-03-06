package com.compiler.ast;

public interface Visitor<R> {
//    public abstract void visit(Node node);
//    public abstract void visit(Expr node);
    public abstract R visit(Expr.Literal node);
    public abstract R visit(Expr.OpBinary node);
    public abstract R visit(Expr.Identify node);
}
