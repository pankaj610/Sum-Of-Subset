package algo;

public class SumOfSubset {
    int total_nodes;
    public static int calculate_sum(int[] weight, boolean[] include){
        int sum=0;
        for(int i=0; i < weight.length; i++){
            if(include[i]==true){
                sum+=weight[i];
            }
        }
        return sum;
    }
    public static void printResult(int[] weight, boolean[] included_weight){
        for(int i=0; i < weight.length; i++){
            if(included_weight[i]==true){
                System.out.print(weight[i]+",");
            }
        }
        System.out.println("    sum : "+calculate_sum(weight, included_weight));
    }
    public static void SumOfSubsetAlgo(int[] weight,int sumNeeded,int index, boolean[] included_weight){

//        boolean[] include = inclided_weight;
        int sumTill = calculate_sum(weight, included_weight);
        if( sumTill == sumNeeded){
            printResult(weight, included_weight);
        }else if(sumTill > sumNeeded){
            return;
        }else{
            if(index+1 == weight.length){return;}
            included_weight[index+1] = true;
            SumOfSubsetAlgo(weight, sumNeeded, index+1, included_weight);
            included_weight[index+1] = false;
            SumOfSubsetAlgo(weight, sumNeeded, index+1, included_weight);
        }
        
//        int cal_sum=0;
//        boolean[] nodes = new boolean[weight.length];
//        for(int i=0; i<weight.length; i++){
//            int w = weight[i];
//            cal_sum += w;
//            if(cal_sum==size){
//                nodes[i] = true;
//                System.out.println(cal_sum);
//            }else if(cal_sum<size){
//                nodes[i] = true;
//            }else{
//                
//            }
//        }
    }
    public static void main(String[] args) {
        int[] weight = {5, 7, 10, 12, 15, 18, 20};
        int sumNeeded = 35;
        
        SumOfSubsetAlgoRecursive(weight, sumNeeded);
    }
    public static void SumOfSubsetAlgoRecursive(int[] weight,int sumNeeded){
        int index = 0;
        boolean[] included_weight = new boolean[weight.length];
        
        included_weight[index] = true;
        SumOfSubsetAlgo(weight, sumNeeded, index, included_weight);
        included_weight[index] = false;
        SumOfSubsetAlgo(weight, sumNeeded, index, included_weight);
    }
}
