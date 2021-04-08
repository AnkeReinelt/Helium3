import java.util.Scanner;
public class Planet extends Weltraumobjekt {


		//Die Eigenschaft 'name' wurde von Weltraumereignis (Superklasse) geerbt
		//weitere Eigenschaften
        private int helium3Vorkommen; // Helium3 Vorkommen auf dem Planeten
        private String oberflaeche;   // Oberflächenbeschaffenheit

		//Konstruktor
		    public Planet(String name, int helium3Vorkommen, String oberflaeche) {
			super(name); //intern wird ein Weltraumobjekt Objekt erstellt
            this.helium3Vorkommen = helium3Vorkommen;
            this.oberflaeche = oberflaeche;
         }

		//getter & setter
          public int getHelium3Vorkommen() {
				return helium3Vorkommen;
			}

      	public void setHelium3Vorkommen(int helium3Vorkommen) {
    		this.helium3Vorkommen = helium3Vorkommen;
    	}

      	 public String getOberflaeche() {
				return oberflaeche;
			}

   	public void setOberflaeche(String oberflaeche) {
 		this.oberflaeche = oberflaeche;
 	}



		//toString überschreiben

        @Override
		public String toString() {
			return "Player [ helium3Vorkommen=" + helium3Vorkommen + "oberflaeche=" + oberflaeche + "]";
		}

		//weitere Methoden

	    /**
	     *
	     * User kann entscheiden, ob er auf Planet landen will oder nicht.
	     * Wenn er dies tut, gewinnt er Helium3, verliert aber Treibstoff.
	     * @param name
	     * @param helium3Vorkommen
	     * @param oberflaeche
	     * @return
	     */

		public static int[] landeAufPlanet (String name, int helium3Vorkommen, String oberflaeche) {
			Scanner sc = new Scanner(System.in);
			String eingabe;
			int[] ausgabeArray = new int[2];
			System.out.println("Du hast " + name + " erreicht.");
			System.out.println("");
			System.out.println("Hier kannst du " + helium3Vorkommen + " Einheiten Helium3 abbauen.");
			System.out.println("Der Planet hat eine "+ oberflaeche + " Oberfläche.");
			if(oberflaeche.equalsIgnoreCase("ebene")){
				System.out.println("Wenn du hier landest verlierst du deshalb 50 Liter Treibstoff.");
				System.out.println("Möchtest du hier landen?");
				System.out.println("Ja: 'j'    Nein: 'n'");
				eingabe = sc.nextLine();
				if (eingabe.equalsIgnoreCase("n")){
					System.out.println("Okay, alles klar. Weiter geht's...");
				}else if (eingabe.equalsIgnoreCase("j")){
					ausgabeArray[0]=50;
					ausgabeArray[1]= helium3Vorkommen;}
			}else if(oberflaeche.equalsIgnoreCase("steinige")){
				System.out.println("Wenn du hier landest verlierst du deshalb 75 Liter Treibstoff.");
				System.out.println("Möchtest du hier landen?");
				System.out.println("Ja: 'j'    Nein: 'n'");
				eingabe = sc.nextLine();
				if (eingabe.equalsIgnoreCase("n")){
					System.out.println("Okay, alles klar. Weiter geht's...");
				}else if (eingabe.equalsIgnoreCase("j")){
					ausgabeArray[0]=75;
					ausgabeArray[1]= helium3Vorkommen;
			}}
			else if(oberflaeche.equalsIgnoreCase("sandige")){
				System.out.println("Wenn du hier landest verlierst du deshalb 100 Liter Treibstoff.");
				System.out.println("Möchtest du hier landen?");
				System.out.println("Ja: 'j'    Nein: 'n'");
				eingabe = sc.nextLine();
				if (eingabe.equalsIgnoreCase("n")){
					System.out.println("Okay, alles klar. Weiter geht's...");
				}else if (eingabe.equalsIgnoreCase("j")){
					ausgabeArray[0]=100;
					ausgabeArray[1]= helium3Vorkommen;
				}}
			else if(oberflaeche.equalsIgnoreCase("flüssige")){
				System.out.println("Wenn du hier landest verlierst du deshalb 100 Liter Treibstoff.");
				System.out.println("Möchtest du hier landen?");
				System.out.println("Ja: 'j'    Nein: 'n'");
				eingabe = sc.nextLine();
				if (eingabe.equalsIgnoreCase("n")){
					System.out.println("Okay, alles klar. Weiter geht's...");
				}else if (eingabe.equalsIgnoreCase("j")){
					ausgabeArray[0]=100;
					ausgabeArray[1]= helium3Vorkommen;
				}
             }return ausgabeArray;// erste Wert des Rückgabearrays gibt an wieviel Treibstoff man verliert und der zweite wieviel helium3 gewonnen wird
             }//Ende Methode landeAufPlanet
		   }//Ende Klasse Planeten
