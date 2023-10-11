package xxl.core;

public abstract class Function extends Content{
    private String _name;

    protected abstract Literal compute();

    public Function(String name){
        _name = name;
    }

    public String getName(){
        return _name;
    }

    public Literal value(){
        return compute();
    }
    
}
