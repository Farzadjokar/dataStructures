package solveprojects;
public class Permutation {
    public static void main(String[] args) {
    char []array=new char[]{'a','b','c','d','e'};
   char permutation[][]=permutations(array);
   System.out.println(permutation.length);
//    for(int i=0;i<permutation.length;i++){
//     for(int j=0;j<permutation[i].length;j++){
// System.out.print(permutation[i][j]+" ");
//     }
//     System.out.println();
//    }
    }
    public static char[][] permutations(char []array){
char permutation[][]=new char[factroriel(array.length)][array.length];
char x1[]=new char[1];
int x=0;
int counter=0;
int i=0,j=0;
boolean flag=false;
int factroriel=factroriel(array.length-counter-1);
while(x!=factroriel(array.length)*array.length){
if(permutation[i][j%array.length]==x1[0]){
permutation[i][j%array.length]=array[counter];
flag=true;
x++;
i++;
}else{
    j++;
    flag=false;
}
if(i%factroriel==0&&i!=0&&flag==true){
    j++;
}
if(i==permutation.length){
    counter++;
factroriel=factroriel(array.length-counter-1);
i=0;j=0;
}
}
return permutation;
    }
    public static int factroriel(int x){
        int fact=1;
        for (int i =1; i <=x; i++) {
            fact=i*fact;
        }
        return fact;
    }
}