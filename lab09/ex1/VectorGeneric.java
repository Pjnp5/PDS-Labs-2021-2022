package lab09.ex1;


import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;

    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }

    private void ensureSpace() {
        if (nElem >= dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem);
            vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem - i - 1 > 0)
                    // not last element
                    System.arraycopy(vec, i + 1, vec, i, nElem - i - 1);
                vec[--nElem] = null;
                // libertar último objecto para o GC
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return nElem;
    }

    public T getElem(
            int i) {
        return (T) vec[i];
    }

    public Iterator<T> Iterator(){
        return (this).new VectorIterator<T>();
    }

    public ListIterator<T> ListIterator(){
        return (this).new VectorListIterator<T>();
    }

    public ListIterator<T> ListIterator(int index){
        return (this).new VectorListIterator<T>(index);
    }


    private class VectorIterator<T> implements Iterator<T>{
        private int index;

        VectorIterator(){ index = 0; }

        @Override
        public boolean hasNext() {
            return (index < nElem);
        }

        @Override
        public T next() {
            if(hasNext()){
                @SuppressWarnings("unchecked")
                T vector = (T) VectorGeneric.this.vec[index++];
                return vector;
            }
            throw new NoSuchElementException("There is only " + nElem + " elements");
        }
    }

    private class VectorListIterator<T> implements ListIterator<T>{

        private int index;

        VectorListIterator(int index){
            index = this.index;
        }


        public VectorListIterator() {
            index = 0;
        }


        @Override
        public void add(T e) {
            System.out.print("Operação opcional não usada");
        }

        @Override
        public boolean hasNext() {
            if (this.index < nElem) return true;
            else{
                index--;
                return false;
            }
        }

        @Override
        public boolean hasPrevious() {
            if(this.index > 0) return true;

            else{
                index++;
                return false;
            }
        }

        @Override
        public T next() {
            if (hasNext()){
                @SuppressWarnings("unchecked")
                T vector = (T) VectorGeneric.this.vec[index++];
                return vector;
            }
            throw new NoSuchElementException("Index out of bounds!");
        }

        @Override
        public int nextIndex() {
            return this.index + 1;
        }

        @Override
        public T previous() {
            if (hasPrevious()){
                @SuppressWarnings("unchecked")
                T vector = (T) VectorGeneric.this.vec[index--];
                return vector;
            }
            throw new NoSuchElementException("Index out of bounds!");
        }

        @Override
        public int previousIndex() {
            return this.index - 1;
        }

        @Override
        public void remove() {
            System.out.print("Operação opcional não usada");
            
        }

        @Override
        public void set(T e) {
            System.out.print("Operação opcional não usada");
            
        }

    }

}
