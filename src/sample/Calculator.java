package sample;

public class Calculator {

    private static Calculator single_instance = null;

    public static Calculator getInstance()
    {
        if (single_instance == null)
            single_instance = new Calculator();
        return single_instance;
    }

    public float showResult(String exp, String sign){
        String[] numbers = exp.split(sign);
        float first = Float.parseFloat(numbers[0]);
        float second = Float.parseFloat(numbers[1]);
        switch (sign){
            case "\\-":
                return first-second;
            case "\\+":
                return first+second;
            case "/":
                return first/second;
            case "\\*":
                return first*second;
            default:
                System.out.println("Loh");
        }
        return 0;
    }

}
