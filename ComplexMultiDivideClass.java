package Q1;


public class ComplexMultiDivideClass extends PolarComplexNum {

    private static int polarCounter;

    public ComplexMultiDivideClass()
    {
        super();
        polarCounter++;//Eveerytime a ComplexMultiDivideClass object is instantiated, the counter's value will be augmented by 1
    }

    public ComplexMultiDivideClass(double magnitude, double angle)
    {
        super(magnitude, angle);//Here I access the PolarComplex's magnitude and angle argument method and add to the counter every time it is used.
        polarCounter++;
    }

    public static int getPolarCounter()
    {
        return polarCounter;//Here I return the int polarCounter value
    }

    public static ComplexMultiDivideClass multiply(ComplexMultiDivideClass a, ComplexMultiDivideClass b)//This method performs the right operation (multiplication) of two ComplexMultiDivideClass objects and outputs the result
    {
        return new ComplexMultiDivideClass((a.getMagnitude()*b.getMagnitude()), (a.getAngle()+b.getAngle()));
    }

    public static ComplexMultiDivideClass divide(ComplexMultiDivideClass a, ComplexMultiDivideClass b)//This method performs the right operation (dividing) of two ComplexMultiDivideClass objects and outputs the result
    {
        return new ComplexMultiDivideClass((a.getMagnitude()/b.getMagnitude()), (a.getAngle()-b.getAngle()));
    }

    public String toString()
    {
            return String.format("Magnitude: %.2f, Angle: %.2f degrees", getMagnitude(), getAngle());
    }
}

