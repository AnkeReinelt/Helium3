

public class SchwarzesLoch extends Weltraumobjekt {


		//Die Eigenschaft name wurde von Weltraumereignisse_SUPERKLASSE geerbt
		//weitere Eigenschaften



		private int anziehungskraft; // je größer die Anziehungskraft, desto mehr Treibstoffverlust entsteht, um zu entkommen

		//Konstruktor
		public SchwarzesLoch(String name, int anziehungskraft) {
			super(name);
            this.anziehungskraft = anziehungskraft;

           }

		//getter setter

		//getter & setter
        public int getAnziehungskraft() {
				return anziehungskraft;
			}

    	public void anziehungskraft(int anziehungskraft) {
  		this.anziehungskraft = anziehungskraft;
  	}


		//toString überschreiben

		@Override
		public String toString() {
			return "SchwarzesLoch [ anziehungskraft=" + anziehungskraft + "]";
		}

		//weitere Methoden

	   /**
	    *
	    * Abhängig von der Anziehungskraft des schwarzen Lochs
	    * bekommt User Treibstoff und Lebensenergie abgezogen.
	    *
	    *
	    * @param name
	    * @param anziehungskraft
	    * @return
	    */
		public int begegneSchwarzemLoch(String name,  int anziehungskraft) {
			System.out.println("OHHHH NEEEIINN....Du bist in die Nähe eines "+ name +" geraten.");
			System.out.println("");
			System.out.println("Du verlierst " + anziehungskraft + " Liter Treibstoff");
			System.out.println("und " + (anziehungskraft -150)+ " % Lebensenergie beim Versuch zu entkommen.");
			return anziehungskraft;

	}

}//Ende Klasse Schwarzes Loch
