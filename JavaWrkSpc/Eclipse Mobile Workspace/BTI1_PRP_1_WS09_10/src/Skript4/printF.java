package Skript4;

public class printF {

    public static void main(String[] args) {

        System.out.printf("~%d~%d~%d~\n", 1, 2, 3);
        System.out.printf("~%2d~%3d~\n", 4, 5);
        System.out.printf("~%04d~%-3d~\n", 6, 7);
        System.out.printf("~%d~%x~%X~\n", 27, 28, 29);
        System.out.printf("~%2$d~%4$d~%3$d~%1$d~\n", 1, 2, 3, 4); // tun Sie es
                                                                  // nicht ;-)
        System.out.printf("~%7.4f~%06.3f~%-8.2f~\n", (1.0 / 3), (2.0 / 3),
                (5.0 / 7));
        System.out.printf("~%c~%s~%5s~%-4s~\n", 'a', "bb", "ccc", "dd");

        System.out.println("\nBOOLEAN:");

        boolean boolF = Boolean.FALSE;
        System.out.println(boolF);
        boolean boolT = Boolean.TRUE;
        System.out.println(boolT);
        System.out.println("\nCHAR:");

        char charHi = Character.MAX_VALUE;
        System.out.println(charHi);
        char charLo = Character.MIN_VALUE;
        System.out.println(charLo);
        System.out.println("\nBYTE:");

        byte byteHi = Byte.MAX_VALUE;
        System.out.println(byteHi);
        byte byteLo = Byte.MIN_VALUE;
        System.out.println(byteLo);
        System.out.println("\nSHORT:");
        byte b = (byte)(127 + 126);
        System.out.println("***" + b + "** " + (byte)253);

        short shortHi = Short.MAX_VALUE;
        System.out.println(shortHi);
        short shortLo = Short.MIN_VALUE;
        System.out.println(shortLo);
        System.out.println("\nINTEGER:");

        int intHi = Integer.MAX_VALUE;
        System.out.println(intHi);
        int intLo = Integer.MIN_VALUE;
        System.out.println(intLo);
        System.out.println("\nLONG:");

        long longHi = Long.MAX_VALUE;
        System.out.println(longHi);
        long longLo = Long.MIN_VALUE;
        System.out.println(longLo);
        System.out.println("\nFLOAT:");

        float floatHi = Float.MAX_VALUE;
        System.out.println(floatHi);
        float floatLo = Float.MAX_VALUE;
        System.out.println(floatLo);
        System.out.println("\nDOUBLE:");

        double doubleHi = Double.MAX_VALUE;
        System.out.println(doubleHi);
        double doubleLo = Double.MIN_VALUE;
        System.out.println(doubleLo);
        System.out.println();
        
        
        
        System.out.println("ACHTUNG!");
        System.out.println("========");
        System.out.println("- byte != Byte");
        System.out.println("- short != Short");
        System.out.println("- int != Integer");
        System.out.println("- long != Long");
        System.out.println("- float != Float");
        System.out.println("- double != Double");
        System.out.println("- - - - - - - - - -");
        System.out.println("<byte> 8bit : " + Byte.MIN_VALUE + ", ..., " + Byte.MAX_VALUE);
        System.out.println("<short> 16bit : " + Short.MIN_VALUE + ", ..., " + Short.MAX_VALUE);
        System.out.println("<int> 32bit : " + Integer.MIN_VALUE + ", ..., " + Integer.MAX_VALUE);
        System.out.println("<long> 64bit : " + Long.MIN_VALUE + ", ..., " + Long.MAX_VALUE);
        System.out.println("<float> 32bit : " + Float.MIN_VALUE + ", ..., " + Float.MAX_VALUE);
        System.out.println("<double> 64bit : " + Double.MIN_VALUE + ", ..., " + Double.MAX_VALUE);
        
        byte g = (byte)(0xAE ^ 0x60);
        System.out.println(0xAE);
        System.out.println(0x60);
        System.out.println(0xCE);
        System.out.println(g);

    }

}
