class A7MiniGryspeerdtHendrix{
  public static void main(String args[]){
  // Question 1:
    int n = 11;
    System.out.println("Question 1:");
    System.out.println(--n);System.out.println(--n);
    System.out.println(--n);System.out.println(--n);
    System.out.println(--n);System.out.println(--n);
    System.out.println(--n);System.out.println(--n);
    System.out.println(--n);System.out.println(--n);
    System.out.println(--n);System.out.println("\n");
 //Question 2:
   int m = 1;
   System.out.println("Question 2:");
   System.out.println(m += 0);    System.out.println(m *=2);
   System.out.println(m *=2);System.out.println(m *=2);
   System.out.println(m *=2);System.out.println(m *=2);
   
 //Question 4:
   int z = 498; //z can be any int
   int a = 25;
   int b = 10;
   int c = 5;
   int d = 1;
   int numa = z/a;
   int numb = (z - a * numa)/b;
   int numc = (z - a * numa - b * numb)/c;
   int numd = (z - a * numa - b * numb - c * numc)/d;
   System.out.println("Question 4:");
   System.out.print("\n"+ z +" cents in quarters, dimes, nickels and pennies is: ");
   System.out.print( numa +" quarters, "+ numb + " dimes, "+ numc +" nickels, "+ numd +" pennies");
    
   
 //Bonus Question:
   
  int num1 = 10;
  int num2 = 20;
  num2 -=  num1;
  num1 += num1;
  System.out.println("\n\nBonus Question:\n");
  System.out.println(num1);
  System.out.println(num2);
   
  //Question 6:
  
  double x=2, y=5;
  System.out.println("\n\n");
  
  /*operation*/x++;
  System.out.println("#1: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x *= y;
  System.out.println("#2: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x %= y;
  System.out.println("#3: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/y = ++x;
  System.out.println("#4: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x = y++;
  System.out.println("#5: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x -= y++;
  System.out.println("#6: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x *= y/x;
  System.out.println("#7: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x += y++ + x;
  System.out.println("#8: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x -= y-- - 5;
  System.out.println("#9: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x += ++y - 6;
  System.out.println("#10: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x += y++ - y;
  System.out.println("#11: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  System.out.println("\n");
  /*operation*/x += y++ - y++;
  System.out.println("#12: value of x is "+ x +"\n"
                    +"    value of y is "+ y);
  x=2; y=5;
  
   System.out.println("\n -End of program-");
  
  }}