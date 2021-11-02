package Test;


import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        new Main2().getTypeString();


    }
    public enum TypeEnum {
        ZERO,
        ONE
    }

    private TypeEnum type;

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getTypeString() {
        switch (type) {
            case ZERO:
                return "ZERO";
            case ONE:
                return "ONE";
            default:
                return "OTHER";
        }
    }


}
