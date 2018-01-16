import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
        private static List<List<Integer>> matrix;
        private static List<List<Integer>>copy;
    public static void main(String[] args) {
        matrix=new ArrayList<>();
       copy=new ArrayList<>();
        int x,y;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y=sc.nextInt();
        for(int i=0;i<x;i++){
            List<Integer>nev=new ArrayList<>();
            for(int j=0;j<y;j++){
                nev.add(sc.nextInt());
            }
            matrix.add(nev);
            copy.add(nev);
        }
        List<Integer>diff=new ArrayList<>();
        for(int i=0;i<=100;i++){
            diff.add(0);
        }
        for(int i=0;i<=100;i++){
            check(i,diff);
        }
        for(int i=0;i<diff.size();i++){
            System.out.println(diff.get(i));
        }
       /* for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++){
                copy.get(i).set(j,matrix.get(i).get(j));
            }
        }
        System.out.println(bejar(0,100,0,0));*/
       // int n=sc.nextInt();

    }

    private static void check(int n,List<Integer>diff){

        for(int i=n;i<=100;i++){
            int max_val=calc(n,i);
            //if(max_val!=0)System.out.println("nem 0");
            if(max_val>diff.get(i-n))diff.set(i-n,max_val);
        }
    }

    private static int calc(int a,int b){
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++){
                copy.get(i).set(j,matrix.get(i).get(j));
            }
        }
        Integer max=0;
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++){
                int num=copy.get(i).get(j);
                if(num>=a && num<=b){
                    int v=bejar(a,b,i,j);
                    if(v>max)max=v;
                }
            }
        }
        return max;
    }

    private static Integer bejar(int a,int b,int i,int j){
        copy.get(i).set(j,-1);
        int ret=0;
        if(i>0){
            int num=copy.get(i-1).get(j);
            if(num>=a && num<=b){
                ret+=bejar(a,b,i-1,j);
            }
        }
        if(j>0){
            int num=copy.get(i).get(j-1);
            if(num>=a && num<=b){
                ret+=bejar(a,b,1,j-1);
            }
        }
        if(i<matrix.size()-1){
            int num=copy.get(i+1).get(j);
            if(num>=a && num<=b){
                ret+=bejar(a,b,i+1,j);
            }
        }
        if(j<matrix.get(0).size()-1){
            int num=copy.get(i).get(j+1);
            if(num>=a && num<=b){
                ret+=bejar(a,b,i,j+1);
            }
        }
        return (ret+1);
    }
}