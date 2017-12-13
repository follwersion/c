package a08;

import java.io.File;

public class ListRoot {
	
	private long freeSpace;
	private long usedSpace;
	private long totalSpace;
	
	public void showroots(){
		System.out.println("Datei\tFreeSpace (MB)\tUsedSpace (MB) \tTotalSpace (MB)\n");
		 for (File ls : File.listRoots()){
			 System.out.print(ls+"\t");
			 freeSpace = ls.getFreeSpace()/1024/1024;
			 usedSpace = ls.getUsableSpace()/1024/1024;
			 totalSpace = ls.getTotalSpace()/1024/1024;
			 System.out.print(freeSpace+"\t\t" + usedSpace +"\t\t"+totalSpace );
			 System.out.println("\t");
			 
			
		 }
		
	}

}
