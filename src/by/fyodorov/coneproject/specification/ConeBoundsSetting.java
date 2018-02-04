package by.fyodorov.coneproject.specification;

public enum ConeBoundsSetting {
    NONE((byte) 0),
    MAX_INFINITY((byte) 1),
    MIN_INFINITY((byte) 2),
    BOTH_INFINITY((byte) (MAX_INFINITY.getFlag() | MIN_INFINITY.getFlag()));
    private final byte flag;
    ConeBoundsSetting(byte flag) {
        this.flag = flag;
    }

    public byte getFlag() {
        return flag;
    }

    public boolean isMinInfinity() {
        return (flag & MIN_INFINITY.getFlag()) != 0;
    }

    public boolean isMaxInfinity() {
        return (flag & MAX_INFINITY.getFlag()) != 0;
    }
}
