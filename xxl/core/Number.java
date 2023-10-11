package xxl.core;  

public class Number extends Literal{
    private int _value;
    

    public Number(int val){
        _value = val;
    }

    public int asInt(){
        return _value;
    }

    public String toString(){
        return String.valueOf(_value);
    }

}
