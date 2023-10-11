package xxl.core;
import java.io.Serializable;

public class Character extends Literal implements Serializable{
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
