import java.util.Scanner; // used to read input strings

public class Calculator {

    // private data members
    private String name = "";
    // public methods and functions
    public Float addition(Float A, Float B){
        return A + B;
    }
    public Float subtraction(Float A, Float B){
        return A - B;
    }
     public Float multiplication(Float A, Float B){
        return A * B;
    }
    public void setName(String N ){
        name = N; // set name to argument passed in
    }
    public String getName(){
        return this.name; // return name
    }
    public static void main(String args[]) {


        // create a calc object
        Calculator mycalc = new Calculator();
        // set name to group 13
        mycalc.setName("Group 13");


        String userIn = "P"; // declaration and initliization
        Scanner scan = new Scanner(System.in); // used for inputs


        while(true) { // loop until 'Q' is entered 


        // print welcome line

        System.out.println("Welcome to the calculator designed by " + mycalc.getName());

        System.out.println("Enter A to add, S to subtract, M to multiply, and Q to quit");
        userIn = scan.nextLine(); // take in user input

         // this wasn't specified in the prompt but I am adding it anyways to make sure that we have a valid input value
         /* ignore above, I am redoing it because I understand now that when something other than A,S,M,Q is entered, we should
         immediately return to the welcmoe and the prompt */
        if(!(userIn.equals("Q")) && !(userIn.equals("S")) && !(userIn.equals("M")) && !(userIn.equals("A"))){
            //System.out.println("This is not a valid character input, please enter A,S,M or Q");
           // userIn = scan.nextLine();

           continue; // go back to top of loop which has the welcome prompt and the input prompt when an invalid input is given
        }

        if(userIn.equals("Q")){
            break; // do not do anything below if Q is entered, exit the loop immediately
        }



        // get two operands

       String operand1;
       String operand2; // read in these two as strings and then convret to floating point as required in prompt
       System.out.println("Enter argument one");
       operand1 = scan.nextLine();
       System.out.println("Enter argument two");
       operand2 = scan.nextLine();
       Float a = Float.parseFloat(operand1);
       Float b = Float.parseFloat(operand2);
       // now perform one of the operations based on userIn

       if(userIn.equals("A")){
           Float result = mycalc.addition(a, b);
           System.out.println("The sum of " + operand1 + " and " + operand2 + " is " + result);

       }
        else if(userIn.equals("S")){
           Float result = mycalc.subtraction(a,b);
           System.out.println("The difference of " + operand1 + " and " + operand2 + " is " + result);

       }
        else {   // since userIn is forced to be A,S,M,Q and the others are covered one else block is enough to execute for multiplication
           Float result = mycalc.multiplication(a,b);
           System.out.println("The product of " + operand1 + " and " + operand2 + " is " + result);

       }


        } // end while loop

    } // end main
}
