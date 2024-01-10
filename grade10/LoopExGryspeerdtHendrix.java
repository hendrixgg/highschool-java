// Loop Java exercise
// Oct 30th, 2019
// Repetition using Java – Loops
import java.util.*;
import java.text.DecimalFormat;
class LoopExGryspeerdtHendrix{
  public static void main(String args[]){
  Scanner input = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("###,###.00");
    DecimalFormat df1 = new DecimalFormat("###,###.0#");
    System.out.println("1. A program that generates a table of squares, cubes and 4th powers.");
    double z;
    System.out.println("Enter the number which you want the program to go up to (must be positive):");
    z = input.nextDouble();
    while (z < 0){
      System.out.println("Enter the number which you want the program to calculate up to (must be positive):");
      z = input.nextDouble();
    }
    double x = z;
    double w = z;
    z = 1;
    System.out.println("Number, Square, Cube, 4th power"+"\n"
                     +" "+(z)+", "+(z)+", "+(z)+", "+(z));
    int X = 0;
    while(x > 1){
    if ( (w - z) > 0 && (w - z) < 1){ System.out.print(" "+w+", "+Math.pow(w,2)+", "+Math.pow(w,3)+", "+Math.pow(w,4)+"\n"); -- x; X = 1;}
    else{
    z++; 
    System.out.print(" "+z+", "+Math.pow(z,2)+", "+Math.pow(z,3)+", "+Math.pow(z,4)+"\n");
    if ( (w - z) > 0 && (w - z) < 1 && X != 1){ System.out.print(" "+w+", "+Math.pow(w,2)+", "+Math.pow(w,3)+", "+Math.pow(w,4)+"\n"); -- x; }
    -- x; }
    }
    
    System.out.println("2. A program that converts temperature from Centigrade to Farenheight");
    System.out.println("Enter the temperature in Centigrade:");
    double C = input.nextDouble();
    double F = C * (9.00/5.00) + 32;
    System.out.println("Table from "+ C +" to "+ (C+15) +"\n");
    System.out.printf("Centigrade     Farenheight\n"
                     +"----------     -----------\n"
                     + df1.format(C) +"            "+ df1.format(F));
    System.out.print("\n");
    for (int i = 1; i <= 15; i++){
    C++;
    F = C * (9.00/5.00) + 32;
    System.out.printf(df1.format(C) +"            "+ df1.format(F));
    System.out.print("\n");
    }
    System.out.println("----------     -----------\n");
    
    System.out.println("3. A program to calculate annual compounding interest");
    
    System.out.println("Enter the amount $ deposit:");
    double P = input.nextDouble();
    while (P <= 0){
    System.out.println("Enter the amount $ deposit:");
    P = input.nextDouble(); }
    double p = P;
    System.out.println("Enter the interest rate in percentage:");
    double R = input.nextDouble();
    while (R < 0){
    System.out.println("Enter the interest rate in percentage:");
    R = input.nextDouble(); }
    
    System.out.println("Enter the number of periods in years:");
    int years = input.nextInt();
    while (years < 0){
    System.out.println("Enter the number of periods in years:");
    years = input.nextInt(); }
    R = R/100;
    double I = P*R;
    int n = 1;
    double T = P + I;
    System.out.printf("Year      Principal Deposit     Interest earned      Total Amount\n\n"
                     +" n           (P)                 I = P*R*t             P + I\n\n");
    while ( n <= years ){
    System.out.printf(" "+n+"          "+ df.format(P) +"       "+ df.format(P) +" * "+ df.format(R) +" * 1 = "+ df.format(I) +"      "); System.out.printf(df.format(T)+"\n");
    P = P+I; n++; I = P*R; T = P + I;
    }
    p = P - p;
    System.out.print("Interest earned $                  "+ df.format(p) +"\n");
    System.out.printf("Future value at the end of "+ years +" years $ = "+ df.format(P));
    
  }}