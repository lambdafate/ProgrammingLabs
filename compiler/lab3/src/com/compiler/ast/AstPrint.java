package com.compiler.ast;


public class AstPrint implements Visitor<Void> {

    @Override
    public Void visit(Expr.Literal node) {
        System.out.print(node.value);
        return null;
    }

    @Override
    public Void visit(Expr.OpBinary node) {

        System.out.print("(");
        node.left.accept(this);
        System.out.print(node.op);
        node.right.accept(this);
        System.out.print(")");

        return null;
    }


    @Override
    public Void visit(Expr.Identify node) {
        System.out.print(node.name);
        return null;
    }

}
