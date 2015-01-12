package code.apps.simpleCalc;


public class CalculatorModel {
    private double memory;

    public CalculatorModel() {
        memory = 0;
    }

    /*
     * You have two special tasks to complete in your getMemory method.
     * 1. You need to handle division by zero so that your calculator returns
     * "Infinity" when you divide by zero.
     * 2. You need to return integer values	as integers in your String (no decimals).
     * For example: 6.0/3.0 should return 2 and not 2.0
     *
     * You will need to know Double.toString() and Long.toString().  These methods take a
     * double or a long, convert it to a String, and then give you back that String.
     *
     * You may also want to make use of %. a % b gives you the
     * remainder of a divided by b. For example 11 % 4 = 3
     */
    public String getMemory() {
    	
    	if (memory % 1 == 0)
		{
			return String.valueOf((int) memory);
    	}
    	
    	return String.valueOf(memory);
    }

    public void setMemory(String string) {
        memory = convertStringToDouble(string);
    }

    public void addToMemory(String string) {
        memory += convertStringToDouble(string);
    }

    public void subtractFromMemory(String string) {
        memory -= convertStringToDouble(string);
    }

    public void multiplyMemoryBy(String string) {
        memory *= convertStringToDouble(string);
    }

    public void divideMemoryBy(String string) {
        memory /= convertStringToDouble(string);
    }

    private double convertStringToDouble(String string) {
        // all inputs are guaranteed to be whole number strings
        // so there's no need to worry about NumberFormatException

        return Double.parseDouble(string);
    }
}
