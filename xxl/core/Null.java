package xxl.core;
import java.io.Serializable;

public class Null extends Literal implements Serializable{
    public Null(){
    }

    public String toString(){
        return "";
    }
    public Literal value(){
        return new Character("#VALUE");
    }
}
