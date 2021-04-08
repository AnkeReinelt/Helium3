import java.util.Scanner;
import java.util.Random;

public class Weltraumobjekt {



		//Eigenschaften
         private String name;



		// Konstruktor
        public Weltraumobjekt(String name) {
			this.name = name;

		}

		// Getter / Setter

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}




		// toString() überschreiben
		@Override
		public String toString() {
			return "Person [name=" + name + "]";
		}

		// weitere Methoden
/**
 *
 *Die Begegnungen mit verschiedenen Weltraumobjekten,
 *können dazu führen, dass der User Lebensenergie
 *und Treibstoff gewinnt oder verliert.
 *
 */

		public int[] begegneEreignis (){
			Scanner sc = new Scanner(System.in);
			Random rg = new Random();
			String befehl;

			int[] ausgabeArray = new int[3];
			System.out.println("In einiger Entfernung entdeckst du etwas Ungewöhnliches. ");
System.out.println("Du kannst aber nicht erkennen, was es ist.");
			System.out.println("Möchtest du dich weiter nähern?");
			System.out.println("Ja: 'j'      Nein: 'n'");
			befehl = sc.nextLine();

			if (befehl.equalsIgnoreCase("j")){


		    if (name.equalsIgnoreCase("Planeten")){
		    	    //Planet
		    	System.out.println("Du erkennst, dass es sich um ein "+ name+ " handelt.");
					System.out.println("Allerdings gibt es hier kein Helium3.");
					System.out.println("");
					System.out.println("Deshalb fliegst du weiter...");

			}else if (name.equalsIgnoreCase("feindlichen Außerirdischen")){
				System.out.println("Du erkennst, dass es sich um einen "+ name+ " handelt.");
                     //Außerirdisches Wesen entzieht Lebensenergie und Treibstoff.
                     //Wieviel, ist abhängig vom Zufall.
			  	ausgabeArray[0] =rg.nextInt(21)+5;//Zahl zwischen 5 und 25 (Lebensenergieverlust)
			  	ausgabeArray[1]=rg.nextInt(21)+50;//Zahl zwischen 50 und 70 (Treibstoffverlust)
					 System.out.println("Er greift dich an.");
					 System.out.println("Du verlierst " + ausgabeArray[0] + " % deiner Lebensenergie");
					 System.out.println("und " + ausgabeArray[1] + " Liter Treibstoff.");

				}else if (name.equalsIgnoreCase("friedlichen Außerirdischen")){
					System.out.println("Du erkennst, dass es sich um einen "+ name+ " handelt.");
					//Außerirdisches Wesen spendet Lebensenergie und Treibstoff.
	                //Wieviel, ist abhängig vom Zufall.
					ausgabeArray[0] =rg.nextInt(16)+5;//Zahl zwischen 5 und 20 (Lebensenergie)
					ausgabeArray[1] =rg.nextInt(26)+5;//Zahl zwischen 5 und 30 (Treibstoff)
					System.out.println("Es möchte dir helfen und spendet dir " + ausgabeArray[0] + "% Lebensenergie");
					 System.out.println("und " + ausgabeArray[1] + " Liter Treibstoff.");

			    }else if (name.equalsIgnoreCase("Schwarzes Loch")){
			    	System.out.println("Du erkennst, dass es sich um ein "+ name+ " handelt.");
			    	 //Schwarzes Loch führt zu Lebensenergie und Treibstoffverlust
			    	 //Wieviel, ist abhängig vom Zufall
			    	ausgabeArray[0] =rg.nextInt(21)+5;//Zahl zwischen 5 und 25 (Lebensenergieverlust)
			    	ausgabeArray[1]=rg.nextInt(21)+50;//Zahl zwischen 50 und 70 (Treibstoffverlust)
					 System.out.println("Die Anziehungskraft ist so stark, dass du ");
					 System.out.println( ausgabeArray[0] + " % deiner Lebensenergie und " + ausgabeArray[1] + " Liter Treibstoff benötigst,");
					 System.out.println("um zu entkommen.");
              }

			    else if (name.equalsIgnoreCase("Kometenhagel")){
			    //Kometenhagel führt zu Treibstoffverlust zwischen 100 und 150 Litern
			    	ausgabeArray[0] =0;//Lebensenergie bleibt gleich
			    	ausgabeArray[1]=rg.nextInt(51)+100;//Zahl zwischen 100 und 150 (Treibstoffverlust)
					 System.out.println("OOHHHH NEEEIINN...Es ist ein Kometenhagel. Der Tank deines Raumschiffs wird beschädigt.");
					 System.out.println("");
					 System.out.println( "Du verlierst " + ausgabeArray[1] + " Liter Treibstoff.");

			    }

			    else if (name.equalsIgnoreCase("Raumschiff")){
			  System.out.println("");
			  System.out.println("Es ist ein Raumschiff aus einer anderen Galaxie.");
			  System.out.println("Da es nicht mehr viel Treibstoff hat, muss es Balast abwerfen.");
			  System.out.println("");
			  System.out.println("DAS IST DEIN GROßES GLÜCK!");


			    	ausgabeArray[0] =0;
			    	ausgabeArray[1]=0;
			    	ausgabeArray[2]=rg.nextInt(51)+50;
			    	System.out.println("Denn du fängst " + ausgabeArray[2]+ " Einheiten Helium3 auf.");
System.out.println("");


             }else if (name.equalsIgnoreCase("Weltraumtankstelle")){
				System.out.println("Du erkennst, dass es sich um eine "+ name+ " handelt.");
				System.out.println("Möchtst du hier tanken?");
				System.out.println("Ja mit 'j'    Nein mit 'n'");
				befehl = sc.nextLine();
                if (befehl.equalsIgnoreCase("n")){

                	System.out.println("Okay, dann nicht. Wenn das mal kein Fehler war. Bis zur nächsten Tankstelle kann es ganz schön weit sein!");
                }else if(befehl.equalsIgnoreCase("j")){
                	System.out.println("Wieviel Treibstoff möchtest du tanken?");
                	System.out.println("Bedenke aber, dass dir dieselbe Menge deiner Lebensenergie abgezogen wird.");

                	ausgabeArray[1]=sc.nextInt();
                	ausgabeArray[0]=ausgabeArray[1];
ausgabeArray[2]=rg.nextInt(51)+50;//50 bis 100  Menge an geschenktem Helium3
                	System.out.println("Alles klar. Du tankst also "+ ausgabeArray[1] +" Liter Treibstoff, verlierst dafür aber ganausoviel Lebensenergie.");
                	System.out.println("");
                	System.out.println("Der Besitzer der Tankstelle freut sich so sehr, dass du bei ihm vorbeigeschaut hast,");
              System.out.println("denn du bist seit 20 Jahren der erste Besucher an seiner Tankstelle.");
              System.out.println("");
              System.out.println("Er schenkt dir deshalb " + ausgabeArray[2] + " Einheiten Helium3." );

                }


				}
			}else if (befehl.equalsIgnoreCase("n")){
				System.out.println("Okay, alles klar! Weiter geht's...");
				System.out.println("Du verlierst keine Lebensenergie und keinen Treibstoff.");
				ausgabeArray[0]=0;
				ausgabeArray[1]=0;
             }

return ausgabeArray;
		}

	}
