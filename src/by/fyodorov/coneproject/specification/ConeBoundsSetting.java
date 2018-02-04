package by.fyodorov.coneproject.specification;

/**
 * setting for bounds in specification
 * NONE (0b0000_0000) - bounds of between specifications are worked  (min <= x <= max) ~ x-values, less, than max and gather, than min
 * MAX_INFINITY (0b0000_0001) - right bound of between specification was reduced (min <= x) ~ x-values, gather than min
 * MIN_INFINITY (0b0000_0010) - left bound of between specification was reduced (x <= max) ~ x-values, less than max
 * BOTH_INFINITY (0b000_0011) - all bound of between specification was reduced (x) ~ all x-values
 */
public enum ConeBoundsSetting {
    NONE((byte) 0b0000_0000),
    MAX_INFINITY((byte) 0b0000_0001),
    MIN_INFINITY((byte) 0b0000_0010),
    BOTH_INFINITY((byte) (MAX_INFINITY.getFlag() | MIN_INFINITY.getFlag()));

    private final byte flag;


    ConeBoundsSetting(byte flag) {
        this.flag = flag;
    }

    /**
     * getting flag of current setting
     * @return byte with setting
     */
    public byte getFlag() {
        return flag;
    }

    /**
     * left bound setting
     * @return is left bound was reduced?
     */
    public boolean isMinInfinity() {
        return (flag & MIN_INFINITY.getFlag()) != 0;
    }

    /**
     * right bound setting
     * @return is right bound was reduced?
     */
    public boolean isMaxInfinity() {
        return (flag & MAX_INFINITY.getFlag()) != 0;
    }
}
