package com.compiler.ast;

public interface Node{
    //所有语法数节点必须都实现该方法
    public abstract <R> R accept(Visitor<R> visitor);

}
