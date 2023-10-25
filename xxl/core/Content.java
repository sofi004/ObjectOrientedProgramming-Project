package xxl.core;

import java.io.IOException;

public abstract class Content {
    
    public abstract String toString();

    abstract Literal value();

    public  String getName() throws IOException{
        throw new IOException();    
    }
    
    public int asInt(){
        return this.value().asInt();    
    }

    public String asString(){
        return this.value().asString();
    }

    
    
}