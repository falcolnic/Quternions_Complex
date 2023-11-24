class ComplexNumber{
    private final double a;
    private final double b;
    private double newA;
    private double newB;
    ComplexNumber newComplex;
    public ComplexNumber(double _a, double _b){
        this.a = _a;
        this.b = _b;
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    //Addition
    public ComplexNumber add(ComplexNumber otherNumber){
        newA = a + otherNumber.getA();
        newB = b + otherNumber.getB();
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }
    //Subtraction
    public ComplexNumber subtract(ComplexNumber otherNumber){
        newA = a - otherNumber.getA();
        newB = b - otherNumber.getB();
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }
    //Multiplication
    public ComplexNumber multiply(ComplexNumber otherNumber){
        newA = (a * otherNumber.getA()) - (b * otherNumber.getB());
        newB = (b * otherNumber.getA()) + (a * otherNumber.getB());
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }
    //Division
    public ComplexNumber divide(ComplexNumber otherNumber){
        newA = ((a * otherNumber.getA()) + (b * otherNumber.getB())) / ((otherNumber.getA() * otherNumber.getA()) + (otherNumber.getB() * otherNumber.getB()));
        newB = ((b * otherNumber.getA()) - (a * otherNumber.getB())) / ((otherNumber.getA() * otherNumber.getA()) + (otherNumber.getB() * otherNumber.getB()));
        newComplex = new ComplexNumber(newA, newB);
        return newComplex;
    }

    @Override
    public String toString(){
        return "(" + a + ") + (" + b + ")i";
    }
}
