package xxl.core;

public class Character extends Literal{
    private String _value;


    public Character(String val){
        _value = val;
    }

    public String toString(){
        return _value;  
    }

    public String asString(){
        return _value;
    }
}
