package solveprojects;
public interface BagInterface<T>{

    public int getSize();

    public boolean isEmpty();

    public boolean add(T newEntry);

    public T remove();

    public boolean remove(T entry);

    public void clear();

    public int getFrequencyOf(T entry);

    public int getIndex(T entry);

    public T[] toArray();

}
