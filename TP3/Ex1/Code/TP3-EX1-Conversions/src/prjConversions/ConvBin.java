package prjConversions;

public class ConvBin implements Conv {

    @Override
    public void calc(int n) {
        System.out.println("Conversion en Bin : " + Integer.toBinaryString(n));
    }
}
