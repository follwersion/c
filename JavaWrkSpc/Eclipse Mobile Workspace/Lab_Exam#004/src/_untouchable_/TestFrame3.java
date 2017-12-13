package _untouchable_;


//import _untouchable_.*;
//import sname_fname.part3.*;


//TestFrame fuer part3
public class TestFrame3 {
    
    public static void main( String[] argv ){
        /*
        KZ locTmpKZ;
        MH locTmpMH;
        TK locTmpTK;
        RH3_I locTmpRHI;
        KK3_I locTmpKKI;
        GK3_I locTmpGKI;
        LK3_I locTmpLKI;
        
        
        
        ZS zs = new ZS();
        
        zs.add( new KK( new KZ( Ort.K, "MHx01" ), new Halter( "Oller",  "Otto" ),    3 ) );
        zs.add( new KK( new KZ( Ort.G, "MHx02" ), new Halter( "Meyer",  "Frieda" ),  2 ) );
        zs.add( new RH( new KZ( Ort.F, "MHx03" ), new Halter( "Rabe",   "Ronja" ) )      );
        zs.add( new RH( new KZ( Ort.W, "MHx04" ), new Halter( "Rabe",   "Ronja" ) )      );
        zs.add( new RH( new KZ( Ort.P, "MHx05" ), new Halter( "Oller",  "Otto" )       ) );
        zs.add( new LK( new KZ( Ort.S, "MHx06" ), new Halter( "Hase",   "Heinz" ),  10 ) );
        zs.add( new LK( new KZ( Ort.H, "MHx07" ), new Halter( "Oller",  "Otto" ),    2 ) );
        zs.add( new LK( new KZ( Ort.K, "MHx08" ), new Halter( "Lustig", "Lara" ),    2 ) );
        zs.add( new GK( new KZ( Ort.F, "MHx09" ), new Halter( "Frech",  "Fritz" ),  20 ) );
        zs.add( new GK( new KZ( Ort.F, "MHx10" ), new Halter( "Elster", "Elke" ),   32 ) );
        
        
        
        
        
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
        locTmpKZ = new KZ( Ort.K, "MHx08" );
        System.out.printf( "%s -> %s\n",  locTmpKZ, zs.findHalter( locTmpKZ ) );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        Halter locTmpHalter = new Halter( "Oller",  "Otto" );
        for ( KZ3_I kz : zs.findKZ( locTmpHalter ) ) System.out.printf( "%s -> %s\n",  locTmpHalter, kz.getKZ() );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        
        
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        locTmpKZ = new KZ( Ort.F, "MHx03" );
        locTmpMH = (MH)zs.getMAP().get(locTmpKZ);
        locTmpRHI = (RH3_I)zs.getMAP().get(locTmpKZ);
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpMH );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpRHI );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );        
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        locTmpKZ = new KZ( Ort.G, "MHx02" );
        locTmpMH = (MH)zs.getMAP().get(locTmpKZ);
        locTmpTK = (TK)zs.getMAP().get(locTmpKZ);
        locTmpKKI = (KK3_I)zs.getMAP().get(locTmpKZ);
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpMH );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpTK );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpKKI );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );        
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        locTmpKZ = new KZ( Ort.F, "MHx09" );
        locTmpMH = (MH)zs.getMAP().get(locTmpKZ);
        locTmpTK = (TK)zs.getMAP().get(locTmpKZ);
        locTmpGKI = (GK3_I)zs.getMAP().get(locTmpKZ);
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpMH );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpTK );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpGKI );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        locTmpKZ = new KZ( Ort.H, "MHx07" );
        locTmpMH = (MH)zs.getMAP().get(locTmpKZ);
        locTmpTK = (TK)zs.getMAP().get(locTmpKZ);
        locTmpLKI = (LK3_I)zs.getMAP().get(locTmpKZ);
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpMH );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpTK );
        System.out.printf( "%s -> %s\n",  locTmpKZ, locTmpLKI );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" ); 
        
        
        
        
        
        // part3
        
        System.out.printf( "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" );
        System.out.printf( "%s\n",  zs.del( new RH( new KZ( Ort.W, "MHx03" ), new Halter( "Rabe", "Ronja" ))));
        System.out.printf( "%s\n",  zs.del( new RH( new KZ( Ort.F, "MHx03" ), new Halter( "Raab", "Ronja" ))));
        System.out.printf( "%s\n",  zs.del( new RH( new KZ( Ort.F, "MHx04" ), new Halter( "Rabe", "Ronja" ))));
        System.out.printf( "%s\n",  zs.del( new RH( new KZ( Ort.W, "MHx04" ), new Halter( "Rabe", "Ronja" ))));
        System.out.printf( "%s\n",  zs.del( new LK( new KZ( Ort.F, "MHx09" ), new Halter( "Frech","Fritz" ), 20 )));
        System.out.printf( "%s\n",  zs.del( new KK( new KZ( Ort.F, "MHx09" ), new Halter( "Frech","Fritz" ), 20 )));
        System.out.printf( "%s\n",  zs.del( new GK( new KZ( Ort.F, "MHx09" ), new Halter( "Frech","Fritz" ), 22 )));
        System.out.printf( "%s\n",  zs.del( new GK( new KZ( Ort.F, "MHx09" ), new Halter( "Frech","Fritz" ), 20 )));
        System.out.printf( "%s\n",  zs.del( new GK( new KZ( Ort.F, "MHx09" ), new Halter( "Frech","Fritz" ), 20 )));
        System.out.printf( "%d\n",  zs.noMH() );
        System.out.printf( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" );
        System.out.printf( "\n\n" );
        */
    }
}
