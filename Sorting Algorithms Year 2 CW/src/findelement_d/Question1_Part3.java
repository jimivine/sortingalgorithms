package findelement_d;

import java.util.Random;

/**
 * - Question 1 Part 3 - Finding the worst case runtime complexity
 * @author jimivine
 */
public class Question1_Part3 
{
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) 
    {
        // Record mean and std deviation of performing an operation
        // reps times
        int reps = 100;
        int[] arraySize = {10,20,30,40,50,60,70,80,90,
                           100,200,300,400,500,600,700,800,900,
                           1000,2000,3000,4000};
        
        for(int j =0; j <arraySize.length; j++)
        {
            double sum=0, s=0;
            double sumSquared=0;
            int[][] something = generateDataSet(arraySize[j]); //2D matrix
            for(int i =0; i <reps; i++)
            {
                long t1=System.nanoTime();
               //call FindElement method for an instance of size n
               
                //Algorithm 1
                findElement_D(something,-1);
                
                //Algorithm 2
                //findElement_D1(something,-1);
                
                //Algorithm 3
                //findElement_D2(something,-1);
                
                long t2=System.nanoTime()-t1;
                //Time in milliseconds
                sum+=(double)t2/1000000.0;
                sumSquared+=(t2/1000000.0)*(t2/1000000.0);
            }
            double mean=sum/reps;
            double variance=sumSquared/reps-(mean*mean);
            double stdDev=Math.sqrt(variance);
            System.out.println(mean + ", " + stdDev + "\n");
        }
    }
    
    /**
     * - Question 1 - Linear Search Algorithm for FindElement_D
     * @param A
     * @param p
     * @return 
     */
    public static boolean findElement_D(int[][] A, int p)
    {   
        for(int i =0; i <A.length; i++) 
        {
            for(int j =0; j <A.length; j++)
            {               
                if(A[i][j] == p)
                {
                    return true;
                }
            }
        }
        return false; 
    }

    /**
     * - Question 1 - Binary Search Algorithm for FindElement_D1
     * @param A
     * @param p
     * @return 
     */
    public static boolean findElement_D1(int[][] A, int p) 
    {
        int low = 0; //start of row
        int high = A.length -1; //end of row

        for(int i =0; i <A.length; i++) 
        {
            low = 0;
            high = A.length - 1;
            while (low <= high) 
            { //While high is greater than low, continue
                int mid = (low + high) / 2; //calculate mid-point
                if(A[i][mid] < p) 
                {
                    low = mid + 1; //search upper half of row
                }else if(A[i][mid] > p) 
                {
                    high = mid - 1; // search lower half of row
                }else if(A[i][mid] == p) 
                { //check if mid-point is a match
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * - Question 1 - Improved Search Algorithm for FindElement_D2
     * @param A
     * @param p
     * @return 
     */
    public static boolean findElement_D2(int[][] A, int p)
    {
        int j = (A.length -1);
        int i = 0;
           
            while(p != A[i][j])
            { //While p does not equal value of A, continue
                if(p > A[i][j])
                {
                    i++; //goes to next row
                } else if(p < A[i][j])
                {
                    j--; //moves back a column
                }  
                if(i == A.length || j == 0)
                {
                    return false;
                }
            }
        return true;
    } 
    
    /**
     * - Generates random data set
     * @param n
     * @return 
     */
    public static int[][] generateDataSet(int n)
    {
        int[][] data=new int[n][n];
        Random r=new Random();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                data[i][j]=r.nextInt();
        return data;
    }
}
