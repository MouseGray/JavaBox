import java.util.Random;

public class Box<A> {
    private final Object[] data;
    private int size;

    Box(int size) {
        if (size < 0) throw new IllegalArgumentException();
        this.data = new Object[size];
        this.size = 0;
    }

    public boolean put(A element) {
        if (size == data.length) return false;
        data[size++] = element;
        return true;
    }

    @SuppressWarnings("unchecked")
    public A get() {
        if (isEmpty()) return null;
        Random rnd = new Random();
        return (A) data[rnd.nextInt(size)];
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void remove(final A element) {
        for (int i = 0; i < size; i++){
            if (element.equals(data[i])) {
                erase(i);
                break;
            }
        }
    }

    private void erase(int n) {
        if (size-- - n >= 0) {
            System.arraycopy(data, n + 1, data, n, size - n);
        }
    }
}
