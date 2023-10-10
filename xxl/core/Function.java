package xxl.core;

public abstract class Function extends Content{
    private String _name;

    public Function(String name){
        _name = name;
    }

    public String getName(){
        return _name;
    }
}
