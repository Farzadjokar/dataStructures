package solveprojects;
public class Ricursive {
    public static void main(String[] args) {
System.out.println(isPalindrom3(new int[]{7,1,9,6,7}, 0, 4));
    }
    public static int getMax(int array[],int start,int end){
if(start==end){
return array[start];
}
int max=getMax(array, start+1, end);
if(max<array[start]){
    max=array[start];
}
return max;
    }
    public static boolean isPalindrome(int array[],int start,int end){
        if(start>=end){
            return true;
        }
        if (array[start]==array[end]){
            isPalindrome(array, start+1, end-1);
            return true;
        }
        else {
            return false;
        }

    }
     public static void doPalidrome(int array[],int start,int end){
if(start>=end){
    return;
}
int temp=array[start];
array[start]=array[end];
array[end]=temp;
doPalidrome(array, start+1, end-1);
     }
     public static double getSeries(double x){
if(x==1){
    return 1;
}
return (1/x)+getSeries(x-1);
     }
     public static double getSeries2(double i){
        if(i==1){
            return i/(2*i+1);
        }
        return i/(2*i+1)+getSeries2(i-1);
     }
     public static double getSeries3(double i){
        if(i==1){
            return i/(i+1);
        }
        return i/(i+1)+getSeries3(i-1);
     }
     public static void printRiverse(int value){
if(value==0){
    return;
}
int x=value%10;
System.out.print(x);
printRiverse( value/=10);
     }
     public static void printCharacterRiversely(String x,int start,int end){
if(start==end){
    return;
}
System.out.print(x.charAt(end));
printCharacterRiversely(x, start, end-1);
     }
     public static int freq(String x,char key,int start,int end){
if(start==end){
    if(x.charAt(end)==key){
        return 1;
    }else{
        return 0;
    }
}
if(x.charAt(start)==key){
    return 1+freq(x, key, start+1, end);
}else{
    return 0+freq(x, key, start+1, end);
}
     }
     public static int getSum(int value){
if(value==0){
    return 0;
}
return (value%10)+getSum(value/=10);
     }
    public static String decimalToBinary(int value){
if(value==1){
    return ""+value;
}
String z=value%2+decimalToBinary(value/=2);
return z;
    }
    public static int binaryToDecimal(String value,int start,int end,int power){
if(start==end){
return Integer.parseInt(""+value.charAt(end))*(int)Math.pow(2, power);
}
return Integer.parseInt(""+value.charAt(start))*(int)Math.pow(2, power)+binaryToDecimal(value, start+1, end, power-1);
    }
public static void printRiverse2(String text,int index){
if(index==0){
    System.out.print(text.charAt(index));
    return;
}
System.out.print(text.charAt(index));
printRiverse2(text, index-1);
}
public static int getFreq(String text,int index,char key){
if(index==0){
if(text.charAt(index)==key){
    return 1;
}else{
    return 0;
}
}
if(text.charAt(index)==key){
    return 1+getFreq(text, index-1, key);
}else{
    return getFreq(text, index-1, key);
}
}
public static int sumOfDigit(int value){
if(value==0){
    return 0;
}
return value%10+sumOfDigit(value/=10);
}
public static int getMax2(int array[],int s){
if(s==array.length-1){
    return array[s];
}
int max=getMax2(array, s+1);
if(max<array[s]){
    max=array[s];
}
return max;
}
public static String dec2Bi(int value){
if(value<2){
return value+"";
}
String z = ""+value%2;
return dec2Bi(value/=2)+""+z;
}
public static int binaryToDecimal2(String binary,int index){
if(index==binary.length()-1){
    return Integer.parseInt(""+binary.charAt(index));
}
return (int)Math.pow(2,binary.length()-index-1)*Integer.parseInt(""+binary.charAt(index))+binaryToDecimal2(binary, index+1);
}
public static boolean isPalindrom3(int array[],int start,int end){
    if(start>=end){
        if(array[start]==array[end]){
            return true;
        }else{
            return false;
        }
    }
    if(array[start]==array[end]){
        return true && isPalindrom3(array, start+1, end-1);
    }else{
        return false ;
    }
}
}
