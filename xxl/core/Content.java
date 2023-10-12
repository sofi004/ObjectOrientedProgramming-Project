package xxl.core;

public abstract class Content {
    
    public abstract String toString();

    abstract Literal value();
    
    public int asInt(){
        return this.value().asInt();    
    }

    public String asString(){
        return this.value().asString();
    }
    
}