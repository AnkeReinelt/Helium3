import java.util.Random;
import java.util.Scanner;

public class Weltraumbewohner extends Weltraumobjekt {

	//Die Eigenschaft 'name wurde von Weltraumereignisse_SUPERKLASSE geerbt
	//weitere Eigenschaften

	private boolean freund;  //gut oder böse
	private String nachricht;
	private int staerke; // je stärker das jeweilige Objekt ist, desto mehr Lebensenergie kann der Weltraumbewohner nehmen/geben

	//Konstruktor
	/**
	 * @param name
	 * @param freund
	 */
	public Weltraumbewohner(String name, boolean freund,  int staerke) {
		super(name);

		this.freund = freund;

		this.staerke = staerke;
	}

	//getter setter



	/**
	 * @return the helium3Vorkommen
	 */
	public boolean isHelium3Vorkommen() {
		return freund;
	}

	/**
	 * @param freund the freund to set
	 */
	public void setFreund(boolean freund) {
		this.freund = freund;
	}


	/**
	 * @return the nachricht
	 */
	public String getNachricht() {
		return nachricht;
	}

	/**
	 * @param name the nachricht to set
	 */
	public void setNachricht(String nachricht) {
		this.nachricht = nachricht;
	}


	/**
	 * @return the staerke
	 */
	public int getStaerke() {
		return staerke;
	}

	/**
	 * @param name the staerke to set
	 */
	public void setStaerke(int staerke) {
		this.staerke = staerke;
	}
	//toString überschreiben

	@Override
	public String toString() {
		return "Weltraumbewohner [ freund=" + freund + ", staerke=" + staerke + "]";
	}

	//weitere Methoden
/**
 *
 * Kampf mit Weltraumbewohner,
 * wobei abhängig vom Zufall und der 'staerke'
 * des Weltraumbewohners
 * entschieden wird, ob und wieviel Energie
 * der User gewinnt oder verliert.
 *
 * Die Gewinnchance ist 50 zu 50.
 *
 */
	public int kaempfeGegenAlien() {

	    Random rg = new Random();
		int zufallszahl1;
		int zufallszahl2;
		int energie=0;

		System.out.println("Ein " + getName() +  " greift dich an.");
		System.out.println("Ihr kämpft gegeneinander.");
		System.out.println("");
		zufallszahl1 = rg.nextInt(3)+1; //Zufallszahl zwischen 1 und 3
		zufallszahl2=rg.nextInt(2)+1; //Zufallszahl zwischen 1 und 2
		//Wenn zufallszahl2=1 ist, gewinnt der User den Kamp
		//Wenn zufallszahl2=2 ist, gewinnt der Weltraumbewohner
		if (zufallszahl2==1){//user gewinnt und bekommt (zufallszahl1 * getStaerke) an Energie dazu}
			energie= zufallszahl1 * getStaerke();
			System.out.println("Du gewinnst den Kampf und erhälst " + energie + " % Lebensenergie.");


		}else if(zufallszahl2==2){//alien gewinnt und user bekommt (zufallszahl1 * getStaerke) an Energie abgezogen
			energie= zufallszahl1 * getStaerke();
			System.out.println("Du verlierst den Kampf und verlierst " + energie + " % Lebensenergie.");
		energie= energie *(-1);
		}
		return energie; //Der Ausgabewert muss in der Main Methode dazuaddiert werden, um die korrekte Energie zu erhalten.
}//Ende Methode 'kaempfeGegenAlien'



	public void begegneWeltraumbewoher() {
	nachricht = (freund == true)? "Ich kann dir helfen und dir etwas Lebensenergie schenken." : "Er entzieht dir Lebensenergie. ";
	System.out.println(nachricht);}
}

