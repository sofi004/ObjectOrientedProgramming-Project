package xxl.core;

import java.io.Serializable;

public abstract class Function extends Content implements Serializable, Observer{

    private String _name;

    private Literal _value;

    protected abstract Literal compute();

    public Function(String name){
        _name = name;
    }

    public String getName(){
        return _name;
    }

    @Override
    public Literal value(){
        return _value;
    }
    
    public void update(){
        _value = compute();
    }

    public boolean accept(Visitor visitor){
        return visitor.visit(this);
    }
}
