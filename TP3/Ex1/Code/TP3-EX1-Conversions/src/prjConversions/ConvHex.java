package prjConversions;

public class ConvHex implements Conv {

    @Override
    public void calc(int n) {
        System.out.println("Conversion en Hex : " + Integer.toHexString(n));
    }
}
