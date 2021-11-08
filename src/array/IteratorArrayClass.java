package array;

/**
 * Implementacao do iterador generico.
 * @param <E> - tipo de elementos a iterar.
 */
public class IteratorArrayClass<E> implements Iterator<E>{
	/**
	 * O vector generico de elementos do tipo E.
	 */
	private E[] elems;
	
	/**
	 * O numero de elementos do array.
	 */
	private int counter;
	
	/**
	 * O indice do proximo elmento.
	 */
	private int current;

	
	/**
	 * Construtor por defeito.
	 */
	public IteratorArrayClass(E[] elems, int counter) {
		this.elems = elems;
		this.counter = counter;
		rewind();
	}

	@Override
	public void rewind() {
		current = 0;
	}

	@Override
	public boolean hasNext() {
		return current < counter;
	}

	@Override
	public E next() {
		return elems[current++];
	}
}
