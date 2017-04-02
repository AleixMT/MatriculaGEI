package TAD;

public class TaulaHashEncadenadaIndirecta<K, V> implements TADTaulaHashGenerica<K, V> {

	private NodeHash<K, V>[] taulaElements;
	private int capacitatTaula, numElements;
	// taula per a analitzar el numero de colisions que tenim en cada posicio
	private int[] numColisions; 
	private int maxNumColisions;

	@SuppressWarnings("unchecked")
	public TaulaHashEncadenadaIndirecta(int capacitatTaulaHash) {
		this.capacitatTaula = capacitatTaulaHash;
		this.taulaElements = new NodeHash[capacitatTaulaHash];
		this.numElements = 0;
		
		// analitzar colisions
		numColisions=new int[capacitatTaulaHash];
		maxNumColisions=0;
	}

	@Override
	public void afegir(K k, V v) {
		int clauHash = k.hashCode();
		if (clauHash<0) clauHash=clauHash*(-1);
		clauHash=clauHash % capacitatTaula;

		if (taulaElements[clauHash] == null){
			taulaElements[clauHash] = new NodeHash<K, V>(k, v, null);
			this.numElements++;
			// analitzar colisions
			numColisions[clauHash]++;
			if (numColisions[clauHash]>maxNumColisions) maxNumColisions=numColisions[clauHash];
		}
		else {
			NodeHash<K, V> nant = taulaElements[clauHash];
			NodeHash<K, V> n = nant.getSeguent();

			while (n != null && !nant.getClau().equals(k)) {
				nant = n;
				n = n.getSeguent();
			}

			if (nant.getClau().equals(k))	//substituir
				nant.setValor(v);
			else {							//inserir
				NodeHash<K, V> nouNode = new NodeHash<K, V>(k, v, null);
				nant.setSeguent(nouNode);
				this.numElements++;
				// analitzar colisions
				numColisions[clauHash]++;
				if (numColisions[clauHash]>maxNumColisions) maxNumColisions=numColisions[clauHash];
			}
		}
	}

	@Override
	public V esborrar(K k) {
		int clauHash = k.hashCode() % capacitatTaula;

		NodeHash<K, V> nant = taulaElements[clauHash];

		if (nant != null) {
			if (nant.getClau().equals(k)){
				taulaElements[clauHash] = nant.getSeguent();
				numElements--;
				return nant.getValor();
			}
			else {

				NodeHash<K, V> n = nant.getSeguent();
				while (n != null && !n.getClau().equals(k)) {
					nant = n;
					n = n.getSeguent();
				}
				
				if (n==null)
					return null;
				else{
					nant.setSeguent(n.getSeguent());
					numElements--;
					return n.getValor();
				}					
			}			
		}

		return null;
	}

	@Override
	public V consultar(K k) {
		
		int clauHash = k.hashCode();
		if (clauHash<0) clauHash=clauHash*(-1);
		clauHash=clauHash % capacitatTaula;
		
		NodeHash<K, V> n = taulaElements[clauHash];

		while (n != null && !n.getClau().equals(k))
			n = n.getSeguent();

		return (n != null) ? n.getValor() : null;
	}

	@Override
	public float getFactorDeCarrega() {
		return (float) numElements / capacitatTaula;
	}

	@Override
	public void mostrarTaula() {
		for (int i = 0; i < this.capacitatTaula; i++) {
			System.out.print(i + ": ");

			NodeHash<K, V> nant = taulaElements[i];

			while (nant != null) {
				System.out.print(nant.getClau().toString() + "("
							+ nant.getValor().toString() + ") ");
				nant = nant.getSeguent();
			}

			System.out.println("");
		}
		System.out.println("Factor càrrega:"+this.getFactorDeCarrega());
		System.out.println("");
	}

	// analitzar colisions
	public void mostrarColisions() {
		int[] frequencia=new int[maxNumColisions+1];
		int num, totalElements=0;
		for (int i = 0; i < this.capacitatTaula; i++) {
			num=numColisions[i];
			frequencia[num]++;
		}
		System.out.println("Analisi de les colisions. X (quantes posicions de la taula tenen X colisions)");
		for (int i = 0; i <= maxNumColisions; i++) {
			totalElements=totalElements+frequencia[i]*i;
			System.out.print(i+":("+frequencia[i]+") ");
			//for(int j=0; i<frequencia[i]; j++) System.out.print("*");
			System.out.println();
		}
		System.out.println("El numero de valors diferents que tenim a la taula es de "+totalElements);
	}
}
