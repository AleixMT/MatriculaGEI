package principal;

import TAD.*;
import tipus.Enter;

public class TestTaulaHash {

	public static void main(String[] args) {
		TaulaHashEncadenadaIndirecta<Enter, Enter> t = new TaulaHashEncadenadaIndirecta<Enter, Enter>(10);
		TaulaHashEncadenadaIndirecta<Integer, Integer> e = new TaulaHashEncadenadaIndirecta<Integer, Integer>(10);
		
		t.afegir(new Enter(108), new Enter(8));
		t.afegir(new Enter(1789), new Enter(9));
		t.afegir(new Enter(55557), new Enter(0));
		t.afegir(new Enter(112354), new Enter(1));
		t.afegir(new Enter(178411), new Enter(11));
		
		t.afegir(new Enter(112354), new Enter(21));
		t.afegir(new Enter(112354), new Enter(13));
		t.afegir(new Enter(987654531), new Enter(133));
		
		e.afegir(8, 8);
		e.afegir(9, 9);
		e.afegir(0, 0);
		e.afegir(1, 1);
		e.afegir(11, 11);
		e.afegir(11, 21);
		e.afegir(11, 13);
		e.afegir(1, 133);
		
		System.out.println("Mostro informacio d'e, dispersio amb el tipus Integer");
		e.mostrarTaula();
		
		System.out.println("Mostro informacio de t, dispersio amb el tipus Enter propi");
		t.mostrarTaula();
		
		/*Consulta*****************************/
		
		System.out.println("Consulto si hi ha l'enter 1 "+t.consultar(new Enter(1)));
		System.out.println("Consulto si hi ha l'enter 11 "+t.consultar(new Enter(11)));
		System.out.println("Consulto si hi ha l'enter 5 "+t.consultar(new Enter(5)));
		System.out.println("Consulto si hi ha l'enter 8 "+t.consultar(new Enter(8)));
		System.out.println("Consulto si hi ha l'enter 9 "+t.consultar(new Enter(9)));
		
		
		/*Esborrar****************************************/
		
		t.esborrar(new Enter(1));
		t.esborrar(new Enter(11));
		t.esborrar(new Enter(8));
		System.out.println("Mostro informacio despres d'esborrar elements");
		t.mostrarTaula();		
		
		
		t.afegir(new Enter(1111111111), new Enter(21));
		t.afegir(new Enter(11999999), new Enter(13));
		t.afegir(new Enter(888881), new Enter(133));
		System.out.println("Mostro nova informacio de t, dispersio amb el tipus Enter propi");
		t.mostrarTaula();
	}

}
