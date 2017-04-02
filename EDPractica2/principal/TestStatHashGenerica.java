package principal;

import java.util.Random;

import TAD.TaulaHashEncadenadaIndirecta;
import tipus.Enter;

public class TestStatHashGenerica {
	public static void main(String[] args) {
		TaulaHashEncadenadaIndirecta<Enter, Enter> t = new TaulaHashEncadenadaIndirecta<Enter, Enter>(10000);
				
		Random randomGenerator = new Random(0);
		
		/*Canviant el mètode hashcode es pot veure com varia el temps d'afegir elements depenent de la qualitat de la dispersió*/
		long t1 = System.currentTimeMillis();
		for(int i=0;i<100000;i++){			
				int randomInt = Math.abs(randomGenerator.nextInt());
				t.afegir(new Enter(randomInt), new Enter(randomInt));
		}
		System.out.println("Temps:"+(System.currentTimeMillis()-t1)+"ms");
		System.out.println("F.Càrrega:"+t.getFactorDeCarrega());
		t.mostrarColisions();
	}
}
