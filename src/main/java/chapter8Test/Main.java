package chapter8Test;

import java.math.BigInteger;

public class Main {
    public static void main(String args[]) {
        BigInteger pNum = new BigInteger("10");
        BigInteger nNum = new BigInteger("-10");
        ThrowsTag.mod(pNum);
        ThrowsTag.mod(nNum);
    }
}
