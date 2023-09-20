public class SecondIndexItem implements Comparable<SecondIndexItem>{
    private String key;
    private int val;

    public SecondIndexItem(String key, int val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "{" + key +
                ", " + val +
                '}';
    }

    @Override
    public int compareTo(SecondIndexItem o) {
        return this.key.compareTo(o.key);
    }
}
