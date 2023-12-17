package exercise3;

class FloatField implements Field<FloatField> {

    private Float value = Float.valueOf(0.0f);

    public FloatField(Float a) {
        this.value = a;
    }

    @Override
    public int compareTo(FloatField o) {
        return value.compareTo(o.value);
    }

    @Override
    public FloatField add(FloatField a) {
        return new FloatField(this.value + a.value);
    }

    @Override
    public FloatField sub(FloatField a) {
        return new FloatField(this.value - a.value);
    }

    @Override
    public FloatField mul(FloatField a) {
        return new FloatField(this.value * a.value);
    }

    @Override
    public FloatField div(FloatField a) {
        return new FloatField(this.value / a.value);
    }
}
