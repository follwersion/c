package dolberg_konstantin.part2;


import _untouchable_.*;
import dolberg_konstantin.part2.*;


//TestFrame fuer part2
public class TestFrame2 {
    
    public static void main( String[] argv ){
        
        KZ locTmpKZ;
        MH locTmpMH;
        TK locTmpTK;
        RH_I locTmpRHI;
        KK_I locTmpKKI;
        GK_I locTmpGKI;
        LK_I locTmpLKI;
        
        
        
        ZS2_I zs = new ZS();
        
        zs.add( new KK( new KZ( "MHx01" ), new Halter( "Oller",  "Otto" ),    3 ) );
        zs.add( new KK( new KZ( "MHx02" ), new Halter( "Meyer",  "Frieda" ),  2 ) );
        zs.add( new RH( new KZ( "MHx03" ), new Halter( "Rabe",   "Ronja" ) )      );
        zs.add( new RH( new KZ( "MHx04" ), new Halter( "Rabe",   "Ronja" ) )      );
        zs.add( new RH( new KZ( "MHx05" ), new Halter( "Oller",  "Otto" )       ) );
        zs.add( new LK( new KZ( "MHx06" ), new Halter( "Hase",   "Heinz" ),  10 ) );
        zs.add( new LK( new KZ( "MHx07" ), new Halter( "Oller",  "Otto" ),    2 ) );
        zs.add( new LK( new KZ( "MHx08" ), new Halter( "Lustig", "Lara" ),    2 ) );
        zs.add( new GK( new KZ( "MHx09" ), new Halter( "Frech",  "Fritz" ),  20 ) );
        zs.add( new GK( new KZ( "MHx10" ), new Halter( "Elster", "Elke" ),   32 ) );
        
        
        
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        zs.printAll();
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        System.out.printf( "%s\n",  zs );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        System.out.printf( "%s\n",  zs.getMAP() );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        System.out.printf( "%d\n",  zs.noMH() );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        
        
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        locTmpKZ = new KZ( "MHx08" );
        System.out.printf( "%s -> %s\n",  locTmpKZ, zs.findHalter( locTmpKZ ) );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        Halter locTmpHalter = new Halter( "Oller",  "Otto" );
        for ( KZ_I kz : zs.findKZ( locTmpHalter ) ) System.out.printf( "%s -> %s\n",  locTmpHalter, kz.getKZ() );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        
        
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        locTmpKZ = new KZ( "MHx03" );
        locTmpMH = (MH)zs.getMAP().get(locTmpKZ);
        locTmpRHI = (RH_I)zs.getMAP().get(locTmpKZ);
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpMH );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpRHI );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );        
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        locTmpKZ = new KZ( "MHx02" );
        locTmpMH = (MH)zs.getMAP().get(locTmpKZ);
        locTmpTK = (TK)zs.getMAP().get(locTmpKZ);
        locTmpKKI = (KK_I)zs.getMAP().get(locTmpKZ);
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpMH );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpTK );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpKKI );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );        
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        locTmpKZ = new KZ( "MHx09" );
        locTmpMH = (MH)zs.getMAP().get(locTmpKZ);
        locTmpTK = (TK)zs.getMAP().get(locTmpKZ);
        locTmpGKI = (GK_I)zs.getMAP().get(locTmpKZ);
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpMH );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpTK );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpGKI );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        locTmpKZ = new KZ( "MHx07" );
        locTmpMH = (MH)zs.getMAP().get(locTmpKZ);
        locTmpTK = (TK)zs.getMAP().get(locTmpKZ);
        locTmpLKI = (LK_I)zs.getMAP().get(locTmpKZ);
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpMH );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpTK );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpLKI );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" ); 
        
    }
}
