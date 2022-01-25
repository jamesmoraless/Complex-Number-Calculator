package Q1;


public class ComplexAddSubClass extends RecComplexNum//This is the child class of RecComplexNum
{
    private static int counter;

    public ComplexAddSubClass()//no parameter constructor returns a incremented counter
    {
        super();
        counter++;
    }

    public ComplexAddSubClass(double real, double imaginary)//parameter constructor returns an incremented counter whenever real and imaginary values are passed in it
    {
        super(real, imaginary);
        counter++;
    }

    public int getCounter()//This getter method returns the value of counter
    {
        return counter;
    }

    public ComplexAddSubClass adder(ComplexAddSubClass a, ComplexAddSubClass b)//This method adds two complex numbers and returns the resultant complex number
    {
        double real = a.getReal() + b.getReal();
        double imaginary = a.getImaginary() + b.getImaginary();
        ComplexAddSubClass newObject1 = new ComplexAddSubClass(real, imaginary);

        return newObject1;
    }

    public ComplexAddSubClass substractor(ComplexAddSubClass a, ComplexAddSubClass b)//This method subtracts two complex numbers and returns the resultant complex number
    {
        double real = a.getReal() - b.getReal();
        double imaginary = a.getImaginary() - b.getImaginary();
        ComplexAddSubClass newObject2 = new ComplexAddSubClass(real, imaginary);

        return newObject2;
    }

    public String toString()//This method is used for formatting and would return a complex number's real and imaginary numbers in the desired format
    {
        String rightFormat;
        if (super.getImaginary()<0)
            rightFormat = String.format("%.2f - %.2fi", super.getReal(), super.getImaginary()*-1);
        else
            rightFormat = String.format("%.2f + %.2fi", super.getReal(), super.getImaginary());

        return rightFormat;//returns the correct values in proper format
    }
}


