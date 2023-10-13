package xxl.core;

import java.io.Serializable;

public abstract class Function extends Content implements Serializable{

    private String _name;

    protected abstract Literal compute();

    public Function(String name){
        _name = name;
    }

    public String getName(){
        return _name;
    }

    @Override
    public Literal value(){
        return compute();
    }
    
}
