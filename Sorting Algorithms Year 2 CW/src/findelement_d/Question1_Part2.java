package findelement_d;

/**
 * - Question 1 Part 2
 * @author jimivine
 */
public class Question1_Part2 
{
    static int[][] arrayD = 
    {
        {1,3,7,8,8,9,12},
        {2,4,8,9,10,30,38},
        {4,5,10,20,29,50,60},
        {8,10,11,30,50,60,61},
        {11,12,40,80,90,100,111},
        {13,15,50,100,110,112,120},
        {22,27,61,112,119,138,153}
    };
    
    public static void main(String[] args)
    {
        int elementArray[] = {4,12,110,5,6,111};
        for(int i =0; i <elementArray.length; i++)
        {
            boolean d = findElement_D(arrayD, elementArray[i]);
            boolean d1 = findElement_D1(arrayD, elementArray[i]);
            boolean d2 = findElement_D2(arrayD, elementArray[i]);
            System.out.println("FindElement_D: " + d 
                            + " |FindElement_D1: " + d1 
                            + " |FindElement_D2: " + d2);
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
}
