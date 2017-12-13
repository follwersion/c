package dolberg_konstantin;

import dolberg_konstantin.Admin.Authorization;

public class TestFrame2 {

	public static void main(String[] args) throws NonExistingAccountException {
		ZMS zms;
		User tmpu;
		zms = new ZMS();
		System.out.printf("Test2a\n======\n\n");
		Person klugeKarla = new Person("Kluge", "Karla", "Customer Care");
		Person marxMax = new Person("Marx", "Max", "Marketing");
		Person allmaAnton = new Person("Allmächtig", "Anton", "EDV");
		zms.add(new Chef("kluge_k", new Password("xX_01_Xx"), klugeKarla));
		zms.add(new Entwickler("eilig_e", new Password("xX_02_Xx"), new Person(
				"Eilig", "Egon", "R&D")));
		zms.add(new Admin("allma_aa", new Password("xX_03_Xx"), allmaAnton));
		zms.add(new Chef("allma_ac", new Password("xX_04_Xx"), allmaAnton));
		zms.add(new Gast("allma_ag", new Password("xX_05_Xx"), allmaAnton));
		zms.add(new NurNutzer("hase_h", new Password("xX_06_Xx"), new Person(
				"Hase", "Heike", "HR")));
		zms.add(new Entwickler("xanadu_x", new Password("xX_07_Xx"),
				new Person("Xanadu", "Xaver", "R&D")));
		zms.add(new NurNutzer("gjoen_g", new Password("xX_08_Xx"), new Person(
				"Gjoen", "Gustav", "HR")));
		zms.add(new NurNutzer("defoy_d", new Password("xX_09_Xx"), new Person(
				"Defoy", "Doris", "HR")));
		zms.add(new NurNutzer("marx_m", new Password("xX_10_Xx"), marxMax));
		zms.add(new Entwickler("torfs_t", new Password("xX_11_Xx"), new Person(
				"Torfs", "Till", "R&D")));
		zms.add(new Admin("wolf_w", new Password("xX_12_Xx"), new Person(
				"Wolf", "Wilma", "EDV")));
		zms.add(new NurNutzer("feuers_f", new Password("xX_13_Xx"), new Person(
				"Feuerstein", "Fred", "Marketing")));
		zms.add(new Admin("duck_d", new Password("xX_14_Xx"), new Person(
				"Duck", "Donald", "EDV")));
		zms.add(new Chef("flof_f", new Password("xX_15_Xx"), new Person("Floh",
				"Fritz", "Marketing")));
		zms.add(new NurNutzer("chok_c", new Password("xX_16_Xx"), new Person(
				"Chok", "Charlie", "Marketing")));
		System.out.printf("ZMS:\n----\n%s\n", zms);
		System.out.print("\n\n\n");
		System.out.printf("Test2b\n======\n\n");
		System.out.printf("#User: %d\n", zms.nou());
		System.out.printf("#Personen: %d\n", zms.nop());
		zms.del("marx_m");
		zms.del("wolf_w");
		System.out.printf("#User: %d\n", zms.nou());
		System.out.printf("#Personen: %d\n", zms.nop());
		zms.del("allma_ac");
		System.out.printf("#User: %d\n", zms.nou());
		System.out.printf("#Personen: %d\n", zms.nop());
		System.out.printf("ZMS:\n----\n%s\n", zms);
		System.out.print("\n\n\n");
		System.out.printf("Test2c\n======\n\n");
		if (!zms.checkPassword("flof_f", new Password("falsch")))
			System.out.println("OK#1");
		if (zms.checkPassword("flof_f", new Password("xX_15_Xx")))
			System.out.println("OK#2");
		try {
			zms.del("???_?");
			System.out.println("ERR#1");
		} catch (NonExistingAccountException e) {
			System.out.printf("OK#3: %s\n", e.getMessage());
		}
		Admin a = new Admin("xxx_x", new Password("xX_##_Xx"), new Person(
				"Xxxxx", "Xxx", "EDV"));
		tmpu = a;
		System.out.println(a.getAuthorization());
		a.setAuthorization(Authorization.ADMIN);
		System.out.println(a.getAuthorization());
		System.out.print("\n\n\n");
		System.out.printf("Test2d\n======\n\n");
		zms.printAllUser();
		zms.delPerson(3);
		System.out.printf("#User: %d\n", zms.nou());
		System.out.printf("#Personen: %d\n", zms.nop());
		zms.printAllUser();
		
		System.out.println(zms.checkPassword("chok_c", new Password("xX_16_Xx")));
		
		// darf nicht akzeptiert werden
//		 System.out.println( tmpu.pw.secret_pw );
//		 System.out.println( a.authorization );
	}// main
}// TestFrame2P