package prjConversions;

public class ConvOct implements Conv {

    @Override
    public void calc(int n) {
        System.out.println("Conversion en Oct : " + Integer.toOctalString(n));
    }
}
