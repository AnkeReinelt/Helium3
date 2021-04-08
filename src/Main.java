import java.util.ArrayList;




import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.awt.Container;

import javax.swing.*;

public class Main  {

	public Main() {
	}

	public static void main(String[] args) { // Main Methode

		String eingabe = null; // String für User-Input
		String username="anke"; // String für User Namen

		// Variablen, die darüber entscheiden, ob Spiel gewonnen oder verloren
		// wird
		int treibstoff = 0;
		int lebensenergie = 0;
		int gefundenesHelium3 = 0;
		int benoetigtesHelium3 = 0;




		//Infotext für die GUI-Ausgabe (Endstand)
		String infotext = null;
	    String infotext2=null;


		// Zufallsgenerator und Scanner zur Verfügung stellen
		Random rg = new Random();
		Scanner sc = new Scanner(System.in);
		int zufallszahl;

		// Array mit aktuellem Spielstand
		int[] spielstand = new int[] { lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3 };


		int[] array1 ={0,0,1};



		//Weltraumobjekte
		Weltraumobjekt weltraumobjekt1 = new Weltraumobjekt("feindlichen Außerirdischen");
        Weltraumobjekt weltraumobjekt2 = new Weltraumobjekt("Planeten");
		Weltraumobjekt weltraumobjekt3 = new Weltraumobjekt("schwarzes Loch");
		Weltraumobjekt weltraumobjekt4 = new Weltraumobjekt("Kometenhagel");
		Weltraumobjekt weltraumobjekt5 = new Weltraumobjekt("friedlichen Außerirdischen");
        Weltraumobjekt weltraumobjekt6 = new Weltraumobjekt("Raumschiff");
        Weltraumobjekt weltraumobjekt7 = new Weltraumobjekt("Weltraumtankstelle");

        //Planeten
		Planet planet1 = new Planet("Planet Centauri", 75, "ebene"); // name, helium3 Vorkommen, Oberfläche
		Planet planet2 = new Planet("Planet ZX-2000", 299, "sandige");
		Planet planet3 = new Planet("Planet Callisto", 130, "steinige");
		Planet planet4 = new Planet("Planet IO", 150, "flüssige");
		Planet planet5 = new Planet("Planet Ceres XL52", 100, "flüssige");

		//Schwarze Löcher
		SchwarzesLoch schwarzesLochStark = new SchwarzesLoch("großen schwarzen Loch ", 200);//name, anziehungskraft
		SchwarzesLoch schwarzesLochSchwach = new SchwarzesLoch("kleinen schwarzen Loch ", 180);

		//Weltraumbewohner

		Weltraumbewohner treibstoffSpender = new Weltraumbewohner("Wesen, welches dir Treibstoff spendet ", true, 50); // true=freund, false=böse
		Weltraumbewohner marsianer = new Weltraumbewohner("Marsianer", false, 10);
		Weltraumbewohner bloop = new Weltraumbewohner("Bloop", true, 5);
		Weltraumbewohner kryptoner = new Weltraumbewohner("Kryptoner", false, 8);


		System.out.println(
				"\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		System.out.println(
				"          HHHH    HHHH     EEEEEEEEEEEE     LLLL            IIIII     UUUU    UUUU     MMMM     MMMM             333333333333  ");
		System.out.println(
				"          HHHH    HHHH     EEEEEEEEEEEE     LLLL            IIIII     UUUU    UUUU     MMMM     MMMM             333333333333");
		System.out.println(
				"          HHHH    HHHH     EEEE             LLLL            IIIII     UUUU    UUUU     MMMMM   MMMMM                     3333 ");
		System.out.println(
				"          HHHH    HHHH     EEEE             LLLL            IIIII     UUUU    UUUU     MMMMMM MMMMMM                     3333");
		System.out.println(
				"          HHHHHHHHHHHH     EEEEEEEEEEEE     LLLL            IIIII     UUUU    UUUU     MMMMMMMMMMMMM             333333333333");
		System.out.println(
				"          HHHHHHHHHHHH     EEEEEEEEEEEE     LLLL            IIIII     UUUU    UUUU     MMMMMMMMMMMMM             333333333333 ");
		System.out.println(
				"          HHHH    HHHH     EEEE             LLLL            IIIII     UUUU    UUUU     MMMM  M  MMMM                     3333");
		System.out.println(
				"          HHHH    HHHH     EEEE             LLLL            IIIII     UUUU    UUUU     MMMM     MMMM                     3333");
		System.out.println(
				"          HHHH    HHHH     EEEEEEEEEEEE     LLLLLLLLLLLL    IIIII     UUUUUUUUUUUU     MMMM     MMMM             333333333333");
		System.out.println(
				"          HHHH    HHHH     EEEEEEEEEEEE     LLLLLLLLLLLL    IIIII     UUUUUUUUUUUU     MMMM     MMMM             333333333333");
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

		//Eingabe username
		System.out.println("Gib deinen Namen ein: ");
		System.out.println("");
		username = sc.nextLine();
		System.out.println("");

		//Begrüßung user und Wahl des Schwierigkeitslevels
		System.out.println("Hallo, " + username + "!");
		System.out.println("Welches Schwierigkeitslevel möchtest du spielen?");
		System.out.println("leicht : 1");
		System.out.println("mittel : 2");
		System.out.println("schwer : 3");
		System.out.println("");
		int level = sc.nextInt(); // Eingabe des Schwierigkeitslevels

		// Zuweisung der Ausgangswerte für Treibstoff, Lebensenergie und benötigtes Helium3
		// abhängig vom gewählten Schwierigkeitslevel
		if (level == 1) { // einfach
			benoetigtesHelium3 = 500;
			treibstoff = 700;
			lebensenergie = 100;
		} else if (level == 2) {// normal
			benoetigtesHelium3 = 600;
			treibstoff = 600;
			lebensenergie = 75;
		} else if (level == 3) {// schwierig
			benoetigtesHelium3 = 700;
			treibstoff = 500;
			lebensenergie = 50;
		}

		// boolean 'schalter' stellt sicher, dass Spiel erst fortgesetzt wird wenn
		//eine Zahl zwischen 1 und 3 (und somit ein Schwierigkeitslevel) gewählt wurde.
		boolean schalter = false;
		  while (schalter == false) {

			switch (level) { //je nach Wahl des Levels wird ein anderes Intro
			                 // mit anderen Ausgangswerten angezeigt
			case 1: //einfach

				System.out.println("");
                erzaehleMission(lebensenergie, treibstoff, benoetigtesHelium3);
				spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                System.out.println("");
				System.out.println("");
				schalter = true;
				break;

			case 2: //normal

				System.out.println("");
				erzaehleMission(lebensenergie, treibstoff, benoetigtesHelium3);
				spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                System.out.println("");
				System.out.println("");
				schalter = true;
				break;

			case 3: // schwer

				System.out.println("");
				erzaehleMission(lebensenergie, treibstoff, benoetigtesHelium3);
				spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
				System.out.println("");
				System.out.println("");
				schalter = true;
				break;

			default:
				System.out.println("Das verstehe ich nicht. Gib eine Zahl zwischen 1 und 3 an: ");
				level = sc.nextInt();
			}// Ende switch
		  }// Ende while


		  //Um Mission zu beginnen, muss User ein Wort entschlüsseln, indem
		  //er die Buchstaben in die richtige Reihenfolge bringt.
		  //Je nach Schwierigkeitslevel, ist dies ein Wort unterschiedlicher Länge:
		  //einfach: 4 Buchstaben   normal: 5 Buchstaben   schwierig: 6 Buchstaben
		starteRaumschiff(level);


        //solange genug treibstoff und lebensenergie der User hat und solange er noch nicht ausreichend
		//Helium3 gefunden hat, wird die Mission fortgesetzt
		while (treibstoff > 0 && lebensenergie > 0 && gefundenesHelium3 < benoetigtesHelium3) {

			while ((eingabe = wohinSollEsGehen(username)) != null) {

				int[] ausgabeArray = null;
				switch (eingabe.toLowerCase()) {
				case "a"://Richtung Andromedanebel

					System.out.println("");
					System.out.println("Du möchtest Richtung Andromedanebel reisen. Bist du dir sicher? ");
					System.out.println("Dort soll es zwar große HELIUM 3 Vorkommen geben.");
					System.out.println("Allerdings ist die Gefahr in ein schwarzes Loch zu geraten recht groß\nund das könnte dir unter Umständen das Leben kosten.");
					System.out.println("");
					System.out.println("Möchtest du das Risiko eingehen?");
					System.out.println("Ja: 'j'    Nein: 'n'");
					eingabe = sc.next();
					if (eingabe.equalsIgnoreCase("n")) { //Richtung Andromedanebel wird wieder verlassen.
						System.out.println("");
						System.out.println("Gute Entscheidung. Manchmal ist es besser etwas vorsichtiger zu sein.");


					} else if (eingabe.equalsIgnoreCase("j")) {//User hat sich entschieden weiter Richtung Andromedanebel zu gehen
						System.out.println("OKAY, du hast es nicht anders gewollt!");
						System.out.println("");
						spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);

						// Ob ein schwarzes Loch kommt ist abhängig vom Zufall:
						// 50% kleines schwarzes Loch, 30% großes schwarzes Loch
						// 20% kein schwarzes Loch

						zufallszahl = rg.nextInt(10); // Zufallszahl von 0 bis 9

						if (zufallszahl == 0 || zufallszahl == 1) {//kein schwarzes Loch
							System.out.println("");
							System.out.println("Glück gehabt! Es scheint hier kein schwarzes Loch zu geben");
						} else if (zufallszahl == 2 || zufallszahl == 3 || zufallszahl == 4) {
							System.out.println("");//großes schwarzes Loch
							schwarzesLochStark.begegneSchwarzemLoch("großen schwarzen Lochs", 200);
							lebensenergie = lebensenergie - (schwarzesLochStark.getAnziehungskraft() - 150);
							treibstoff = treibstoff - schwarzesLochStark.getAnziehungskraft();
						} else if (zufallszahl == 5 || zufallszahl == 6 || zufallszahl == 7 || zufallszahl == 8
								|| zufallszahl == 9) {//kleines schwarzes Loch
							System.out.println("");
							schwarzesLochSchwach.begegneSchwarzemLoch("kleinen schwarzen Lochs", 180);
							lebensenergie = lebensenergie - (schwarzesLochSchwach.getAnziehungskraft() - 150);// 30%
					        treibstoff = treibstoff - schwarzesLochSchwach.getAnziehungskraft();
						}



						pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
						spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                        System.out.println("");
                        zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
						spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                        System.out.println("");

                        //User erreicht Planet ZX-2000
						int[] array2 = Planet.landeAufPlanet("Planet ZX-2000", 299, "sandige");
                        treibstoff = treibstoff - array2[0];
						gefundenesHelium3 = gefundenesHelium3 + array2[1];

						System.out.println("");
						pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
                        zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
						spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                        System.out.println("");

                        //User begegnet einem gutartigen Weltraumwesen, welches Lebensenergie schenkt
						System.out.println("Du begegnest einem " + bloop.getName()+ ".");
						System.out.println("Er spendet dir " + bloop.getStaerke() + " % Lebensenergie.");
						lebensenergie = lebensenergie + bloop.getStaerke();
						System.out.println("Du hast jetzt " + lebensenergie + "% Lebensenergie.");

						spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
						System.out.println("");

						//User begegnet schwarzem Loch, wobei ihm eine zufällige Menge an
						//Lebensenergie und Treibstoff entzogen wird
						array1 = weltraumobjekt3.begegneEreignis();
						treibstoff = treibstoff - array1[1];
						lebensenergie = lebensenergie - array1[0];

						spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
						System.out.println("");
						pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext,infotext2,eingabe);
						zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
						spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
						System.out.println("");

                        // User begegnet einem Raumschiff und erhält eine zufällige Menge an Helium3
						array1=weltraumobjekt6.begegneEreignis();
                        gefundenesHelium3 = gefundenesHelium3 + array1[2];

						System.out.println("");
						spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
						pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
						System.out.println("");
						zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
						spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
					} // Ende Richtung Andromeda
					    System.out.println("");
				        System.out.println("Du solltest dich jetzt woanders umschauen.");
                        System.out.println("");
                    break;

				case "o":// Richtung Orionnebel

					System.out.println("");
					System.out.println("Du reist Richtung Orionnebel und wirst von einem Marsianer angegriffen.");
                    marsianer.begegneWeltraumbewoher();
					System.out.println("Du verlierst " + marsianer.getStaerke() + " % und hast jetzt nur noch "
							+ (lebensenergie - marsianer.getStaerke()) + " % Lebensenergie.");
					lebensenergie= lebensenergie- marsianer.getStaerke();

					pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext,infotext2,eingabe);
					spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                    zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);

                    //User begegnet feindlichem Außerirdischen und verliert eine zuällige Menge an
                    //Lebensenergie und Treibstoff
					 array1 = weltraumobjekt1.begegneEreignis();
                     treibstoff = treibstoff - array1[1];
					 lebensenergie = lebensenergie - array1[0];

                    System.out.println("");
                    spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
					System.out.println("");
					pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext,infotext2,eingabe);
					System.out.println("");
					zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
					spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
					System.out.println("");

					//User erreicht Planet auf dem er Helium3 abbauen kann
					int[] zahl3 = Planet.landeAufPlanet("Planet IO", 150, "flüssige");
					treibstoff = treibstoff - zahl3[0];
					gefundenesHelium3 = gefundenesHelium3 + zahl3[1];

					System.out.println("");
					zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
					pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext,infotext2,eingabe);
					spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);

					//User durchquert einen Kometenhagel.
					//Dabei verliert er eine zufällige Menge an Treibstoff
					array1 = weltraumobjekt4.begegneEreignis();
					treibstoff = treibstoff - array1[1];
					lebensenergie = lebensenergie - array1[0]; //array1[0]=0


					System.out.println("");
					spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
					pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext,infotext2,eingabe);
					zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
					System.out.println("");
					spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
					System.out.println("Du solltest vielleicht auch mal einen anderen Teil des Universums erforschen!");
					System.out.println(""); //Ende Richtung Orionnebel
					break;

				case "c":

					System.out.println("Du fliegst in die Richtung des Asteroiden C-3PO.");
					System.out.println("");

					//User begegnet einer Weltraumtankstelle.
					//Wenn er tankt verliert er Lebensenergie, bekommt aber vom
					//Tankstellenbesitzer Helium3 geschenkt
					array1=weltraumobjekt7.begegneEreignis();
					treibstoff = treibstoff + array1[1];
					lebensenergie = lebensenergie - array1[0];
					gefundenesHelium3=gefundenesHelium3 + array1[2];

                    spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                    System.out.println("");
					zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
					pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
					spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);

					System.out.println("Du fliegst weiter in Richtung des Asteroiden C-3PO");
                    System.out.println("");

                    //Kryptoner greift den User an
                    //Der Zufall entscheidet darüber, wer den Kampf gewinnt.
                    //User erhält Lebensenergie oder verliert welche.
					lebensenergie = lebensenergie + kryptoner.kaempfeGegenAlien();


					spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
					zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
			     	pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
                    spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                    System.out.println("");

                    //User erreicht Planet Callisto, auf dem er Helium3 abbauen kann
                    int[] array2 = Planet.landeAufPlanet("Planet Callisto", 130, "steinige");
                    treibstoff = treibstoff - array2[0];
                    gefundenesHelium3 = gefundenesHelium3 + array2[1];

                    pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
                    zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
                    System.out.println("");


				    //User begegnet einem Weltraumereignis
                    //Welches das ist, entscheidet der Zufall
                    zufallszahl = rg.nextInt(6)+1; //Zufallszahl von 1 bis 6
                    if (zufallszahl==1){//feindlichen Außerirdischen
                       int[] array3 = weltraumobjekt1.begegneEreignis();
	                   treibstoff = treibstoff - array3[1];
	                   lebensenergie = lebensenergie - array3[0];
                       System.out.println("");}//Planeten
                    else if (zufallszahl==2){
                       weltraumobjekt2.begegneEreignis();}
                    else if (zufallszahl==3){//schwarzes Loch
                       int[] array3 = weltraumobjekt3.begegneEreignis();
	                   treibstoff = treibstoff - array3[1];
	                   lebensenergie = lebensenergie - array3[0];
                       System.out.println("");}
                    else if (zufallszahl==4){//Kometenhagel
                       int[] array3 = weltraumobjekt4.begegneEreignis();
	                   treibstoff = treibstoff - array3[1];
	                   lebensenergie = lebensenergie - array3[0];//array3[0]=0
                       System.out.println("");}
                    else if (zufallszahl==5){//friedlicher Außerirdischer
                       int[] array3 = weltraumobjekt5.begegneEreignis();
	                   treibstoff = treibstoff + array3[1];
	                   lebensenergie = lebensenergie + array3[0];
                       System.out.println("");}
                    else if (zufallszahl==6){//Raumschiff
                       int[] array3 = weltraumobjekt6.begegneEreignis();
                       gefundenesHelium3 = gefundenesHelium3 + array3[2];
                       System.out.println("");}


                    spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                    zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
                    pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
                    System.out.println("");
                    System.out.println("Ich glaube hier in der Nähe des Asteroiden C-3PO gibt es nichts mehr zu entdecken.");
                    System.out.println("");
                    System.out.println("Möchtest du nicht lieber in eine andere Richtung reisen?");
                  break;

				case "u":
                    System.out.println("");
					System.out.println("Du möchtest also in den bisher unerforschten Teil der Galaxie reisen.");
					System.out.println("");
                    System.out.println("HOFFENTLICH WAR DAS KEIN FEHLER! Hier soll es viele Gefahren geben...");
                    System.out.println("");
                    spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
                    System.out.println("");
                    System.out.println("Da kommt schon der erste Gegner auf dich zu.");
                    System.out.println("Möchtest du gegen ihn kämpfen oder doch eine andere Richtung einschlagen?");
                    System.out.println("kämpfen   'k'      zurück zur Auswahl  'z'   ");
                	eingabe = sc.next();

                    if (eingabe.equalsIgnoreCase("z")) {//User kommt wieder zur Auswahl
	                System.out.println("");
                    System.out.println("OKAY, du traust dich also nicht zu kämpfen!");
                    System.out.println("Vielleicht ist es auch besser so, wenn du woanders weitersuchst...");
                    }else if (eingabe.equalsIgnoreCase("k")) {//User geht weiter Richtung unbekanntem Teil des Universums
                    System.out.println("");

                    //Kampf gegen Marsianer
					lebensenergie = lebensenergie + marsianer.kaempfeGegenAlien();

					System.out.println("");
                    spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
					pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
					System.out.println("");
					zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
			        spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);

					//User erreicht Planet Centauri auf dem er Helium3 abbauen kann
			        System.out.println("");
			        array2 = Planet.landeAufPlanet("Planet Centauri", 75, "ebene");
			        treibstoff = treibstoff - array2[0];
			        gefundenesHelium3 = gefundenesHelium3 + array2[1];

			        pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
			        System.out.println("");
			        zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
                    spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
			        System.out.println("");

			        //Angriff eines Kryptoners
                    System.out.println("Es scheint so als hätte dich jemand auf dem Planeten Centauri beobachtet und ist dir gefolgt...");
                    System.out.println("");
                    System.out.println("OOOHHHHHH NEEEIIINNNN.....Nicht schon wieder!");
                    System.out.println("");
                    kryptoner.kaempfeGegenAlien();
                    System.out.println("");

                    pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
	            	System.out.println("");
	             	zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);

	             	//User begegnet einem Weltraumereignis
                    //Welches das ist, entscheidet der Zufall
                    zufallszahl = rg.nextInt(6)+1; //Zufallszahl von 1 bis 6
                    if (zufallszahl==1){//feindlichen Außerirdischen
                       int[] array3 = weltraumobjekt1.begegneEreignis();
	                   treibstoff = treibstoff - array3[1];
	                   lebensenergie = lebensenergie - array3[0];
                       System.out.println("");}//Planeten
                    else if (zufallszahl==2){
                       weltraumobjekt2.begegneEreignis();}
                    else if (zufallszahl==3){//schwarzes Loch
                       int[] array3 = weltraumobjekt3.begegneEreignis();
	                   treibstoff = treibstoff - array3[1];
	                   lebensenergie = lebensenergie - array3[0];
                       System.out.println("");}
                    else if (zufallszahl==4){//Kometenhagel
                       int[] array3 = weltraumobjekt4.begegneEreignis();
	                   treibstoff = treibstoff - array3[1];
	                   lebensenergie = lebensenergie - array3[0];//array3[0]=0
                       System.out.println("");}
                    else if (zufallszahl==5){//friedlicher Außerirdischer
                       int[] array3 = weltraumobjekt5.begegneEreignis();
	                   treibstoff = treibstoff + array3[1];
	                   lebensenergie = lebensenergie + array3[0];
                       System.out.println("");}
                    else if (zufallszahl==6){//Raumschiff
                       int[] array3 = weltraumobjekt6.begegneEreignis();
                       gefundenesHelium3 = gefundenesHelium3 + array3[2];
                       System.out.println("");}


                       pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
                       System.out.println("");
                       zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
                       spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);

                       //User erreicht Planet Ceres XL52
                       System.out.println("");
                       System.out.println("Deinen Berechnungen zufolge müsstest du nun eigentlich gleich den nächsten Planeten erreichen.");
                       System.out.println("");
                       System.out.println("ACH, DA IST ER JA SCHON...");
                       System.out.println("");
                       System.out.println("");
                       array2 = Planet.landeAufPlanet("Planet Ceres XL52", 100, "flüssige");
                       treibstoff = treibstoff - array2[0];
                       gefundenesHelium3 = gefundenesHelium3 + array2[1];

                       pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
                       zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
                       System.out.println("");
spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);




//Kryptoner greift den User an
//Der Zufall entscheidet darüber, wer den Kampf gewinnt.
//User erhält Lebensenergie oder verliert welche.
System.out.println("OOOHHHHHH NEEEIIINNNN.....Ein " + kryptoner.getName() + " greift dich schon wieder an.");
lebensenergie = lebensenergie + kryptoner.kaempfeGegenAlien();

spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
pruefeSpielende(lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3, infotext, infotext2, eingabe);
zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
System.out.println("");



                     }//Ende Richtung unbekannter Teil des Universums
                    System.out.println("");
                    System.out.println("Du hast den Unbekannten Teil des Universums nun erforscht. Vielleicht solltest du wieder eine andere Richtung einschlagen...");
                    break;

				case "s":
					zeigeSpielstand(spielstand, lebensenergie, treibstoff, gefundenesHelium3, benoetigtesHelium3);
					spielFortsetzenOderBeenden(eingabe, lebensenergie, treibstoff);
					break;
				case "q": //TODO Sicherheitsabfrage einfügen
                    System.out.println("Schade! Vielleicht hast du ja morgen mehr Lust");
					System.exit(0);
                    break;
				case "": //Falls nur Enter/Return gedrückt wurde zurück zur Auswahl
					wohinSollEsGehen(username);
					break;
				default:
                    System.out.println("");
					System.out.println("UNGÜLTIGE EINGABE!");
					System.out.println("");
					wohinSollEsGehen(username);
					break;
				}
			} // Ende while (solange eine usereingabe gemacht wird)
          } // Ende while (Spiel läuft solange wie lebensenergie && treibstoff >0 und (benötigtes Helium3 - gefundenesHelim3) > 0

		sc.close();

	} //Ende Main Methode



	/**
	 *
	 * Aus einer vorgegebenen Buchstabenkombination,
	 * muss ein korrektes Wort gebildet werden
	 *
	 * Die zu entschlüsselnden Wörter und die dazugehörigen
	 * Lösungen sind in Array-Listen abgelegt und können deshalb
	 * beliebig erweitert werden.
	 *
	 * Abhängig vom eingegebenen level, werden Wörter unterschiedlicher
	 * Länge angezeigt.
	 *
	 * TODO Methode so ausbauen, dass der User eine andere Buchstabenkombination
	 *      zum Entschlüsseln angezeigt bekommt, falls er die aktuelle nicht lösen kann.
     *
	 */
	public static void starteRaumschiff(int level) {

		// Scanner && Zufallsgenerator erzeugen
		Scanner sc = new Scanner(System.in);
		Random rg = new Random();

		// String-Array Listen mit verschlüsselten Wörtern
		List<String> woerterSalat = new ArrayList<>();
		List<String> woerterLoesung = new ArrayList<>();

		List<String> woerterSalat1 = new ArrayList<>();
		//woerterSalat1.add("O A U T"); // Auto
		//woerterSalat1.add("A Z N T"); // Tanz
		//woerterSalat1.add("F F E A"); // Affe
		woerterSalat1.add("E E D R"); // Erde
		//woerterSalat1.add("A B N K"); // Bank
		woerterSalat1.add("S R M A"); // Mars

		// String-Array Liste der korrekten Wörter
		List<String> woerterLoesung1 = new ArrayList<>();
		//woerterLoesung1.add("A U T O");
		//woerterLoesung1.add("T A N Z");
		//woerterLoesung1.add("A F F E");
		woerterLoesung1.add("E R D E");
		//woerterLoesung1.add("B A N K");
		woerterLoesung1.add("M A R S");

		List<String> woerterSalat2 = new ArrayList<>();
		woerterSalat2.add("S U V N E"); // Venus
		//woerterSalat2.add("F U E E R"); // Feuer
		//woerterSalat2.add("N N S E O"); // Sonne
		woerterSalat2.add("P U L O T"); // Pluto
		//woerterSalat2.add("I E A N L"); // Alien

		// String-Array Liste der korrekten Wörter
		List<String> woerterLoesung2 = new ArrayList<>();
		woerterLoesung2.add("V E N U S");
		//woerterLoesung2.add("F E U E R");
		//woerterLoesung2.add("S O N N E");
		woerterLoesung2.add("P L U T O");
		//woerterLoesung2.add("A L I E N");

		List<String> woerterSalat3 = new ArrayList<>();
		//woerterSalat3.add("L E P A T N"); // Planet
		woerterSalat3.add("P T U E N N"); // Neptun
		woerterSalat3.add("U J P I T R E"); // Jupiter
		woerterSalat3.add("S U T A N R"); // Saturn
		woerterSalat3.add("K U R R M E"); // Merkur
		woerterSalat3.add("U U A R S N"); // Uranus

		// String-Array Liste der korrekten Wörter
		List<String> woerterLoesung3 = new ArrayList<>();
		//woerterLoesung3.add("P L A N E T");
		woerterLoesung3.add("N E P T U N");
		woerterLoesung3.add("J U P I T E R");
		woerterLoesung3.add("S A T U R N");
		woerterLoesung3.add("M E R K U R");
		woerterLoesung3.add("U R A N U S");

		// Je nach gewähltem Level des Users, müssen Wörter von
		// unterschiedlicher Länge entschlüsselt werden
		if (level == 1) {
			woerterSalat = woerterSalat1;
			woerterLoesung = woerterLoesung1;
		} else if (level == 2) {
			woerterSalat = woerterSalat2;
			woerterLoesung = woerterLoesung2;
		} else if (level == 3) {
			woerterSalat = woerterSalat3;
			woerterLoesung = woerterLoesung3;
		}

		// Zufallszahl von 0 bis WoerterSalat.size() wird erzeugt,
		// um zu entschlüsselndes Wort aus der String-Array Liste auszuwählen
		int zufallsZahl = rg.nextInt(woerterSalat.size());

		// Korrekte Lösung
		String loesungZusammen = woerterLoesung.get(zufallsZahl).replace(" ", "");

		// Aufforderung an den User, das korrekte Wort einzugeben
		System.out
				.println("Um die Mission antreten zu dürfen, musst du zuächst deine Intelligenz unter Beweis stellen.");
		System.out.println(
				"Du kannst das Raumschiff nur starten, indem du aus den folgenden Buchstaben das korrekte Wort \nüber die Tastatur eingibst.");
		System.out.println(
				"TIPP: Die Lösung ist ein Planet.");

		System.out.println(woerterSalat.get(zufallsZahl)); //Ausgabe des zu entschlüsselnden Wortes
		String userLoesung = sc.nextLine();//Usereingabe

		// Erst wenn das korrekte Wort eingegeben wurden, geht das Spiel weiter
		if (userLoesung.equalsIgnoreCase(loesungZusammen)) {// korrekt
			System.out.println(
					"Herzlichen Glückwunsch! Du hast den korrekten Code eingegeben. Deine Mission kann beginnen!");
			System.out.println("");
		} else {// bei falscher Lösung muss solange probiert werden bis korrektes Wort eingegeben wurde
			while (!userLoesung.equalsIgnoreCase(loesungZusammen)) {
				if (userLoesung.equalsIgnoreCase(loesungZusammen)) {
					userLoesung = sc.nextLine();
					System.out.println("");
					System.out.println("Herzlichen Glückwunsch! Du hast den korrekten Code eingegeben./nDu kannst deine Mission beginnen");
					System.out.println("");
				}else{
					System.out.println("Sorry. Das ist der falsche Code. Versuche es nochmal:");
					userLoesung = sc.nextLine();
					if (userLoesung.equalsIgnoreCase(loesungZusammen)){
						System.out.println("Herzlichen Glückwunsch! Du hast den korrekten Code eingegeben. Deine Mission kann beginnen!");
						System.out.println("");}
				      };
				   }
                 }
              }//Ende Methode: 'starteRaumschiff'

	/**
	 *
	 * Abfrage, wohin der User als nächstes reisen möchte
	 *
	 * @param username
	 * @return String ausgabe
	 *
	 */
	public static String wohinSollEsGehen(String username) {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("Wohin möchtest du, " + username + " ?");
		System.out.println("");
		System.out.println("Richtung Andromedanebel reisen mit 'a'       Richtung Orionnebel reisen mit 'o'");
		System.out.println(
				"Richtung Asteroid C-3PO reisen mit 'c'       Unbekannten Teil der Galaxie erforschen mit 'u'");
		System.out.println("aktuellen Spielstand abfragen  mit 's'       Spiel verlassen mit 'q'");
		String ausgabe = sc.nextLine();
		return ausgabe;
	} // Ende Methode: 'wohinSollEsGehen'


/**
 * Überprüfung, ob Spielende erreicht ist aufgrund fehlendem Treibstoffs, Lebensenergie
 * oder ausreichend gefundenem Helium3.
 *
 * Bei Spielende wird ein GUI swing ausgegeben mit dem Endstand
 *
 * @param lebensenergie
 * @param treibstoff
 * @param gefundenesHelium3
 * @param benoetigtesHelium3
 * @param infotext
 * @param infotext2
 * @param eingabe
 *
 * TODO so abändern, dass bei Spielende, keine weitere Eingabe über
 *      Konsole möglich ist.
 *
 */
	private static void  pruefeSpielende(int lebensenergie, int treibstoff, int gefundenesHelium3,
			int benoetigtesHelium3,String infotext, String infotext2, String eingabe) {

		if (lebensenergie > 0 && treibstoff > 0) { //noch genügend lebensenergie und treibstoff vorhanden...

			  if ((benoetigtesHelium3 - gefundenesHelium3) > 0 ) { //...aber noch nicht ausreichend Helium3 gefunden
				System.out.println("");
				System.out.println("Du kannst deine Mission fortsetzen");
				}

			     else if ((benoetigtesHelium3 - gefundenesHelium3) < 0) { //gewonnen, da mehr Helium3 gefunden als erforderlich

				  System.out.println("HERZLICHEN GLÜCKWUNSCH!");
				  System.out.println("");
				  System.out.println(
						"Du hast deine Mission erfüllt und \nsogar " + (benoetigtesHelium3 - gefundenesHelium3) * (-1)
								+ " Einheiten mehr Helium3 gefunden als erforderlich.");
				  System.out.println("Die Bewohner deines Planeten sind gerettet.");
				  infotext = "Du hast gewonnen!";
                  infotext2 ="Du hast "+ ((benoetigtesHelium3 - gefundenesHelium3) * (-1)) + " Einheiten Helium3 mehr gefunden als nötig.";


				  spielstandGUI(lebensenergie, treibstoff, gefundenesHelium3, infotext ,infotext2);}

			    else if ((benoetigtesHelium3 - gefundenesHelium3) == 0) {//gewonnen, da exakt die benötigte Menge an Helium3 gefunden
			      System.out.println("HERZLICHEN GLÜCKWUNSCH!");
				  System.out.println("");
				  System.out.println("Du hast deine Mission erfüllt und " + benoetigtesHelium3 + " Einheiten Helium gefunden.");
				  System.out.println("Die Bewohner deines Planeten sind gerettet.");
				  infotext = "Du hast gewonnen.";
				  infotext2 ="Du hast "+ benoetigtesHelium3 + " Einheiten Helium3 gefunden.";
                  spielstandGUI(lebensenergie, treibstoff, gefundenesHelium3, infotext,infotext2);}

		 }else if (lebensenergie <= 0 || treibstoff <= 0) {//falls treibstoff oder lebensenergie kleiner oder gleich 0 ist, ist spiel verloren

			System.out.println("OHHH NEEEIIIN....!");
			System.out.println("");
			if (lebensenergie <= 0) {
				System.out.println("Du hast keine Energie mehr:");
				lebensenergie=0;
				System.out.println("Lebensenergie: " + lebensenergie + " %");
				System.out.println("");}

			if (treibstoff <= 0) {
				System.out.println("Du hast keinen Treibstoff mehr:");
				treibstoff=0;
				System.out.println("Treibstoff: " + treibstoff + " Liter");
				System.out.println("");}

			System.out.println("Vielleicht klappt es ja beim nächsten Mal...");
			 infotext = "Du hast verloren!";
			 infotext2 ="Dir fehlen noch " + (benoetigtesHelium3 - gefundenesHelium3) + " Einheiten Helium3";


			  spielstandGUI(lebensenergie, treibstoff, gefundenesHelium3, infotext,infotext2);
		}
	}// Ende Methode 'pruefeSpielende'

	/**
	 *
	 * GUI swing mit Spielstand wird ausgegeben
	 *
	 * @param lebensenergie
	 * @param treibstoff
	 * @param gefundenesHelium3
	 * @param infotext
	 * @param infotext2
	 *
	 */

	private static void spielstandGUI(int lebensenergie, int treibstoff, int gefundenesHelium3, String infotext,String infotext2) {

				JFrame fenster = new JFrame("Endstand");
                //Breite und Höhe festlegen
				fenster.setSize(750,380);

		        fenster.setLayout(null);

				//Buttons erzeugen und in Fenster darstellen
		        //Button 1:
				JLabel schaltflaeche = new JLabel("            Lebensenergie: " + lebensenergie + " %");
			    schaltflaeche.setFont(schaltflaeche.getFont().deriveFont((float) 18)); //Schriftgröße anpassen
				fenster.add(schaltflaeche);
				schaltflaeche.setBounds(20, 150, 300, 400); //Position des Textfeldes >,v,
				schaltflaeche.setSize(300, 25);  //Weite des Textfeldes , Höhe des Textfeldes

				//Button 2:
				JLabel schaltflaeche2 = new JLabel("      Treibstoff: " + treibstoff + " Liter");
				schaltflaeche2.setFont(schaltflaeche2.getFont().deriveFont((float) 18));
				schaltflaeche2.setSize(300, 25);
				fenster.add(schaltflaeche2);
						schaltflaeche2.setBounds(50,200, 300, 400); //Position des Textfeldes >,v,
						schaltflaeche2.setSize(300, 25);  //Weite des Textfeldes , Höhe des Textfeldes

			    //Button 3:
				JLabel schaltflaeche3 = new JLabel("            gefundenes Helium3: " + gefundenesHelium3 + " Einheiten");
			    schaltflaeche3.setFont(schaltflaeche3.getFont().deriveFont((float) 18));
				fenster.add(schaltflaeche3);
				schaltflaeche3.setBounds(20, 250, 300, 400); //Position des Textfeldes >,v,
				schaltflaeche3.setSize(400, 25);  //Weite des Textfeldes , Höhe des Textfeldes

				//Button 4:
				JLabel schaltflaeche4 = new JLabel("          " + infotext);
			    schaltflaeche4.setFont(schaltflaeche4.getFont().deriveFont((float) 22)); //Schriftgröße anpassen
				fenster.add(schaltflaeche4);
				schaltflaeche4.setBounds(20, 50, 300, 400); //Position des Textfeldes >,v,
				schaltflaeche4.setSize(400, 25);  //Weite des Textfeldes , Höhe des Textfeldes

				//Button 5:
				JLabel schaltflaeche5 = new JLabel("          " + infotext2);
			    schaltflaeche5.setFont(schaltflaeche5.getFont().deriveFont((float) 22)); //Schriftgröße anpassen
				fenster.add(schaltflaeche5);
				schaltflaeche5.setBounds(20, 100, 300, 400); //Position des Textfeldes >,v,
				schaltflaeche5.setSize(680, 25);  //Weite des Textfeldes , Höhe des Textfeldes

				//Container ereugen, um dort GUI Elemente ablegen zu können.
				Container fensterScheibe = fenster.getContentPane();

				fensterScheibe.add(schaltflaeche);
                fensterScheibe.add(schaltflaeche2);

			    schaltflaeche2.setVisible(true);
		        schaltflaeche.setVisible(true);
		        fenster.setVisible(true);
	     }//Ende Methode 'spielstandGUI'


/**
 *
 * Mit Eingabe von 'w' wird das Spiel fortgeführt
 *
 * TODO Die Eingabewerte String eingabe und  int lebensenergie
 * sind überflüssig und können entfernt werden
 *
 * @param eingabe
 * @param lebensenergie
 * @param treibstoff
 */
	public static void spielFortsetzenOderBeenden(String eingabe, int lebensenergie, int treibstoff) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Weiter mit 'w'");
		eingabe = sc.next();
		while (!eingabe.equalsIgnoreCase("w") && !eingabe.equalsIgnoreCase("q")) { // Beginn
																					// while
			if (!eingabe.equalsIgnoreCase("w")) {
				System.out.println("Wenn du das Spiel fortsetzen möchtest, dann drücke 'w'");
				System.out.println("Falls du das Spiel beenden möchtest, dann drücke 'q'");
				eingabe = sc.next();
				if (eingabe.equalsIgnoreCase("q")) {
					System.out.println("Schade! Vielleicht hast du ja morgen mehr Lust");

					System.exit(0);
				}}
			}sc.nextLine();
		}// Ende Methode 'spielFortsetzenOderBeenden'

	/**
	 *
	 * Aktueller Spielstand wird angezeigt und auf Konsole
	 * ausgegeben.
	 *
	 * @param spielstand
	 * @param lebensenergie
	 * @param treibstoff
	 * @param gefundenesHelium3
	 * @param benoetigtesHelium3
	 *
	 */
	private static void zeigeSpielstand(int[] spielstand, int lebensenergie, int treibstoff, int gefundenesHelium3,
			int benoetigtesHelium3) {
		System.out.println("      aktueller Spielstand");
		System.out.println("----------------------------------");
		System.out.println("");
		for (int i = 0; i <= 3; i++) {
			if (i == 0) {
				spielstand[0] = lebensenergie;
				System.out.println("Lebensenergie:      " + spielstand[i] + " %");
				System.out.println("");

			} else if (i == 1) {
				spielstand[1] = treibstoff;
				System.out.println("Treibstoff:         " + spielstand[i] + " Liter");
				System.out.println("");
			} else if (i == 2) {
				spielstand[2] = gefundenesHelium3;
				System.out.println("gefundenes Helium3: " + spielstand[i] + " Einheiten");
				System.out.println("");
			} else if (i == 3) {
				spielstand[3] = (benoetigtesHelium3 - gefundenesHelium3);
				System.out.println("benoetigtesHelium3: " + spielstand[i] + " Einheiten");
				System.out.println("");
			}
		}
		System.out.println("----------------------------------");
	} // Ende Methode 'zeigeSpielstand'

/**
 *
 * Mission die der User zu erledigen hat
 * wird erzählt in Abhängigkeit von den
 * Werten für lebensenergie, treibstoff und
 * benötigtem Helium3
 *
 * @param lebensenergie
 * @param treibstoff
 * @param benoetigtesHelium3
 *
 */
	public static void erzaehleMission(int lebensenergie, int treibstoff, int benoetigtesHelium3) {
		System.out.println(
				"--------------------------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("                              ***** Deine Mission *****  ");
		System.out.println("");
		System.out.println("Die Energievorräte deines Heimatplaneten sind bald aufgebraucht. Um das Überleben deiner");
		System.out.println(
				"Spezies zu sichern, musst du dich mit deinem Raumschiff durch den Weltraum bewegen und auf  ");
		System.out.println("fremden Planeten nach HELIUM 3 Energievorräten suchen. Du benötigst " + benoetigtesHelium3
				+ " Einheiten Helium 3, \num deine Art zu retten. Steuere dein Raumschiff durch die Galaxie und versuche zu überleben.");
		System.out.println(" ");
		System.out.println("Pass dabei besonders auf deinen Treibstoffvorrat und deine Lebensenergie auf.  ");
		System.out.println("");
		System.out.println(
				"Aktuell hast du " + lebensenergie + " % Lebensenergie und " + treibstoff + " Liter Treibstoff.");
		System.out.println("");
		System.out.println("                                    - VIEL ERFOLG!-  ");
		System.out.println("");
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

	}// Ende Methode 'erzähle Mission'
}
