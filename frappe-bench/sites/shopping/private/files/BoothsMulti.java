******************************************************************************************
Java Program for Booth's Algorithm for Multiplication 
******************************************************************************************

import java.util.*;       //Importing all classes of Util Package
public class BoothsMulti //Creating a class named BitMultiply
{
 public static void main(String[] args)         //Main Method
 {
  int i;
  System.out.println("Enetr the numbers in decimal form which you want to multiply : \n Note : 1.Numbers should be between 1 to 15 \n        2.Transition of Multiplicant should be less then multiplyer");
  Scanner InpOb = new Scanner(System.in); //Making Object InpOb
  System.out.println("Enetr the Multiplicand");
  int num1 = InpOb.nextInt();     //Taking the value of multiplicand by user
  System.out.println("Enetr the Multiplier");
  int num2 = InpOb.nextInt();     //Taking the value of multiplier by user
  System.out.println();
  int tempnum1 = num1;
  int tempnum2 = num2;
  System.out.print("Binary Number of " + num1 + " is : ");
  int num1arr[] = BoothsMulti.binaryConversion(num1);    //Converting Decimal to Binary
  int temp1arr[] = new int[5];
  int temp2arr[] = new int[5];
  for(i=0;i<=4;i++)
  {
   System.out.print(num1arr[i]);
   temp1arr[i] = num1arr[i];
  }
  System.out.println();
  System.out.print("Binary Number of " + num2 + " is : ");
  int num2arr[] = BoothsMulti.binaryConversion(num2);        //Converting Decimal to Binary
  for(i=0;i<=4;i++)
  {
   System.out.print(num2arr[i]);
   temp2arr[i] = num2arr[i];
  }
  int tocomp[] = {0,0,0,0,1};
  System.out.println();
  System.out.println();
  System.out.print("2's Complement of " + num1 + " is : ");
  int comp1arr[] = BoothsMulti.binaryComplement(num1arr);
  int twos1arr[] = BoothsMulti.binaryAddition(comp1arr, tocomp);   //taking 2's Complement 
  for(i=0;i<=4;i++)
  {
   System.out.print(twos1arr[i]);
  }
  System.out.println();
  System.out.print("2's Complement of " + num2 + " is : ");
  int comp2arr[] = BoothsMulti.binaryComplement(num2arr);
  int twos2arr[] = BoothsMulti.binaryAddition(comp2arr, tocomp);    //taking 2's Complement
  for(i=0;i<=4;i++)
  {
   System.out.print(twos2arr[i]);
  }
  System.out.println();
  System.out.println();
  int binaryResult[] = BoothsMulti.boothsAlgo(temp1arr, temp2arr, twos2arr);
  System.out.println();
  System.out.println();
  System.out.print("Final Binary Result is : ");
  for(i=0;i<=9;i++)
  {
   System.out.print(binaryResult[i]);
  }
  if((tempnum1<0)&&(tempnum2>0) || (tempnum1>0)&&(tempnum2<0))
  {
   int compResult[] = {0,0,0,0,0,0,0,0,0,1};
   int tempResult[] = BoothsMulti.binarytenComplement(binaryResult);
   int twosResult[] = BoothsMulti.binarytenAddition(tempResult, compResult);
   for(i=0;i<=9;i++)
   {
    binaryResult[i] = twosResult[i];
   }
   System.out.println();
   int deciResult = BoothsMulti.convDecimal(binaryResult);
   System.out.println("Result in Decimal form is -" + deciResult);
  }
  else
  {
   System.out.println();
   int deciResult = BoothsMulti.convDecimal(binaryResult);
   System.out.println("Result in Decimal form is " + deciResult);
  }
 }
 public static int convDecimal(int n[])     //Method for converting Binary to decimal
 {
  int deci = 0;
  int j,k;
  for(int i=9;i>=0;i--)
  {
   k=1;
   for(j=i;j<=9;j++)
   {
    k = k*2;
   }
  deci = deci + n[i]*(k/2);
  }
  return deci; 
 }
 public static int[] binaryConversion(int num)          //Method for converting Decimal to Binary
 {
  int i,temp, store;
  store = num;
  int binaryNum[] = {0,0,0,0,0};
  if(num<0)
  {
   num = num*(-1);
  }
  for(i = 4 ; i>=1 ; i--)
  {
   temp = num % 2;
   num = num/2;
   binaryNum[i] = temp;
  }
  if(store<0)
  {
   int storecomp[] = BoothsMulti.binaryComplement(binaryNum);
   int addone[] = {0,0,0,0,1};
   int storeadd[] = BoothsMulti.binaryAddition(storecomp, addone);
   for(i=0; i<5; i++)
   {
    binaryNum[i] = storeadd[i];
   }
  }
  return binaryNum;
 }
 public static int[] binaryComplement(int comp[])          //Method for taking complement 5 Bits
 {
  for(int i=4;i>=0;i--)
        {  
   if(comp[i]==0)
   {
    comp[i]=1;
   }
   else
   {
    comp[i]=0;
   }
        }
  return comp;
 }
 public static int[] binarytenComplement(int comp[])          //Method for taking complement 10 Bits
 {
  for(int i=9;i>=0;i--)
        {  
   if(comp[i]==0)
   {
    comp[i]=1;
   }
   else
   {
    comp[i]=0;
   }
        }
  return comp;
 }
 public static int[] binaryAddition(int add1[], int add2[])         //Method for addition of array 5 Bits
 {
  int i, carry = 0;
  int add3[] = {0,0,0,0,0};
  for(i=4;i>=0;i--)
  {
   if(add1[i]==1 && add2[i]==1 && carry==0)          
   {
    add3[i]=0;
    carry=1;
   }
   else if(add1[i]==1 && add2[i]==1 && carry==1)
     {
         add3[i]=1;
         carry=1;
     }
   else if(add1[i]==1 && add2[i]==0 && carry==0)
     {
         add3[i]=1;
         carry=0;
     }
   else if(add1[i]==1 && add2[i]==0 && carry==1)
     {
         add3[i]=0;
         carry=1;
     }
   else if(add1[i]==0 && add2[i]==1 && carry==0)
     {
         add3[i]=1;
         carry=0;
     }
   else if(add1[i]==0 && add2[i]==1 && carry==1)
     {
         add3[i]=0;
         carry=1;
     }
   else if(add1[i]==0 && add2[i]==0 && carry==0)
     {
         add3[i]=0;
         carry=0;
     }
   else if(add1[i]==0 && add2[i]==0 && carry==1)
     {
         add3[i]=1;
         carry=0;
     }
    }
  return add3; 
 }
 public static int[] binarytenAddition(int add1[], int add2[])    //Method for addition of array 10 Bits
 {
  int i, carry = 0;
  int add3[] = {0,0,0,0,0,0,0,0,0,0,0};
  for(i=9;i>=0;i--)
  {
   if(add1[i]==1 && add2[i]==1 && carry==0)        
   {
    add3[i]=0;
    carry=1;
   }
   else if(add1[i]==1 && add2[i]==1 && carry==1)
     {
         add3[i]=1;
         carry=1;
     }
   else if(add1[i]==1 && add2[i]==0 && carry==0)
     {
         add3[i]=1;
         carry=0;
     }
   else if(add1[i]==1 && add2[i]==0 && carry==1)
     {
         add3[i]=0;
         carry=1;
     }
   else if(add1[i]==0 && add2[i]==1 && carry==0)
     {
         add3[i]=1;
         carry=0;
     }
   else if(add1[i]==0 && add2[i]==1 && carry==1)
     {
         add3[i]=0;
         carry=1;
     }
   else if(add1[i]==0 && add2[i]==0 && carry==0)
     {
         add3[i]=0;
         carry=0;
     }
   else if(add1[i]==0 && add2[i]==0 && carry==1)
     {
         add3[i]=1;
         carry=0;
     }
    }
  return add3; 
 }
 public static int[] boothsAlgo(int X[], int addY[], int subY[])    //Method for Booths Algorithm
 {
  int i,x1=0;
  int U[] = {0,0,0,0,0};
  System.out.println();
  System.out.println("  U\t  X\tX-1");
  for(i=0;i<=4;i++)
  {
   System.out.print(U[i]);
  }
  System.out.print("\t");
  for(i=0;i<=4;i++)
  {
   System.out.print(X[i]);
  }
  System.out.print("\t ");
  System.out.print(x1);
  for(int j=0;j<=4;j++)
  {
   if((X[4]==0) && (x1==1))
   {
    int tempU[] = BoothsMulti.binaryAddition(U, addY);
    for(i=0;i<=4;i++)
    {
     U[i] = tempU[i];
    }
    x1 = X[4];
    X[4] = X[3];
    X[3] = X[2];
    X[2] = X[1];
    X[1] = X[0];
    X[0] = U[4];
    U[4] = U[3];
    U[3] = U[2];
    U[2] = U[1];
    U[1] = U[0];
    System.out.println();
    for(i=0;i<=4;i++)
    {
     System.out.print(U[i]);
    } 
    System.out.print("\t");
    for(i=0;i<=4;i++)
    {
     System.out.print(X[i]);
    }
    System.out.print("\t ");
    System.out.print(x1);
   }
   else if((X[4]==1) && (x1==0))
   {
    int tempU[] = BoothsMulti.binaryAddition(U, subY);
    for(i=0;i<=4;i++)
    {
     U[i] = tempU[i];
    }
    x1 = X[4];
    X[4] = X[3];
    X[3] = X[2];
    X[2] = X[1];
    X[1] = X[0];
    X[0] = U[4];
    U[4] = U[3];
    U[3] = U[2];
    U[2] = U[1];
    U[1] = U[0];
    System.out.println();
    for(i=0;i<=4;i++)
    {
     System.out.print(U[i]);
    } 
    System.out.print("\t");
    for(i=0;i<=4;i++)
    {
     System.out.print(X[i]);
    }
    System.out.print("\t ");
    System.out.print(x1);
   }
   else
   {
    x1 = X[4];
    X[4] = X[3];
    X[3] = X[2];
    X[2] = X[1];
    X[1] = X[0];
    X[0] = U[4];
    U[4] = U[3];
    U[3] = U[2];
    U[2] = U[1];
    U[1] = U[0];
    System.out.println();
    for(i=0;i<=4;i++)
    {
     System.out.print(U[i]);
    } 
    System.out.print("\t");
    for(i=0;i<=4;i++)
    {
     System.out.print(X[i]);
    }
    System.out.print("\t ");
    System.out.print(x1);
   }
  }
  int finalArr[] = new int[10];          //Shifting Result in finalArr
  finalArr[9] = X[4];
  finalArr[8] = X[3];
  finalArr[7] = X[2];
  finalArr[6] = X[1];
  finalArr[5] = X[0];
  finalArr[4] = U[4];
  finalArr[3] = U[3];
  finalArr[2] = U[2];
  finalArr[1] = U[1];
  finalArr[0] = U[0];
  return finalArr;
 }
}

******************************************************************************************
Result
******************************************************************************************
Enetr the numbers in decimal form which you want to multiply :
 Note : 1.Numbers should be between 1 to 15
        2.Transition of Multiplicant should be less then multiplyer
Enetr the Multiplicant
-5
Enetr the Multiplyer
14

Binary Number of -5 is : 11011
Binary Number of 14 is : 01110

2's Complement of -5 is : 00101
2's Complement of 14 is : 10010


  U       X     X-1
00000   11011    0
11001   01101    1
11100   10110    1
00101   01011    0
11011   10101    1
11101   11010    1

Final Binary Result is : 1110111010
Result in Decimal form is -70
*****************************************************************************************