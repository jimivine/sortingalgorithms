package findelement_d;

/**
 * - Question 2 - Write a Java program to compute g(n) 
 *      using the recursive definition of f .
 * @author jimivine
 */
public class Question_2 
{
    public static void main(String[] args)
    {
        long t1 = System.nanoTime();
        //Method used to calculate f(n,n)
        f(10,10);
        long t2 = System.nanoTime() - t1;
        //Outputs time in milliseconds
            System.out.println(t2/1000000.0);
            System.out.println(t2);
    }
    
    
    /**
     * - Question 2, Part 1
     * Write a Java program to compute g(n) using the recursive definition of f
     * @param i
     * @param j
     * @return 
     */
    public static int f(int i, int j)
    {
        if (i==0 && j==0) 
        {
            return 0;
        }
        if (i>0 && j==0) 
        {
            return 1;
        }
        if (j>0 && i==0) 
        {
            return 1;
        }
        return (f(i-1, j) + f(i-1, j-1) + f(i, j-1)) * 1/3;
    }
}