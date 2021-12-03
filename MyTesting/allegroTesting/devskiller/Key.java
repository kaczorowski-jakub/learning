package devskiller;

class Key {
    public final int value;

    public Key(int value) {
        this.value = value;
    }

    // equals simplified for the sake of brevity
    public boolean equals(Object o) {
        return this.value == ((Key)o).value;
    }

    public int hashCode() {
        return 1;
    }
}
