package part1;

import part1.HardDisk.HDI;

public class TestFrame {
	
	public static void main(String[] args) {
		//
		// TEST 1
		//
		System.out.printf("Test 1:\n\n");
		Store shed = new Store();
		shed.add(new Screen("brilliantScreen", 15000, "TFT,1400x1050"));
		shed.add(new Processor("BNE, SMT, quad core", 40000, "9GHz"));
		shed.add(new Screen("oldCGAScreen", 10000, "CRT,320x200"));
		shed.add(new Screen("theScreen", 10000, "CRT,1024x768"));
		shed.add(new Memory("SDRAM", 7500, "1GB"));
		shed.add(new Screen("finallyHDTV", 45000, "LCD,1920x1080"));
		// Kommentar entfernen falls der Enumerations-Typ HDI implementiert wurde
		shed.add(new HardDisk("BIGDISK", 70000, "2TB", 16  , HDI.SCSI ));
		shed.add(new HardDisk("maxiDISK", 75000, "4TB", 32  , HDI.USB ));
		shed.add(new Memory("DDR2-SDRAM", 15000, "1GB"));
		shed.add(new Processor("EXFAX, quad core P8", 50000, "8GHz"));
		shed.add(new Memory("DDR3-SDRAM", 22500, "1GB"));
		shed.add(new Memory("RDRAM", 20000, "1GB"));
		shed.add(new Memory("RDRAM", 50000, "2GB"));		
		shed.printAllComponents();
		

		//
		// TEST 2
		//
		try {
		// den folgenden Kommentar entfernen falls delete, numOfComponentsInStore und computeValue implementiert wurde
		// andernfalls gezielt in geeigneter Weise den Kommentar Manipulieren für delete/numOfComponentsInStore/computeValue
		
		System.out.printf("\n\n\n\nTest 2:\n\n");
		System.out.printf("#Components = %d ; ", shed.numOfComponentsInStore());
		shed.delete(3);
		System.out.printf("%d ; ", shed.numOfComponentsInStore());
		shed.add(new Screen ( "oldVGAScreen", 11000, "CRT,640x480" ) );
		System.out.printf("%d ; ", shed.numOfComponentsInStore());
		shed.delete(13);
		System.out.printf("%d ; ", shed.numOfComponentsInStore());
		shed.add( new Memory ( "DDR1-SDRAM", 10000, "1GB") );
		System.out.printf("%d\n\n", shed.numOfComponentsInStore());
		int v = shed.computeValue();
		System.out.printf("Value = %d.%02d€\n", v/100, v%100);
		System.out.printf("\n\n\n\nprintAllComponents:\n\n");
		shed.printAllComponents();
		shed.delete(14);
		
		// den folgenden Kommentar entfernen falls NonExistingComponentException implementiert wurde
		
		System.out.printf("\nBUG\n");
		} catch (NonExistingComponentException e) {
		System.out.printf("\nok %s\n", e);
		
		} finally {
		// just to keep the compiler happy ;-)
		}
		// den folgenden Kommentar entfernen falls durchgängig toString implementiert wurde
		
		System.out.printf("\n\n\n\ntoString:\n\n");
		System.out.print(shed);		
		
		
	}
}