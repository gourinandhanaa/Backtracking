/*   
Level    1

There is a given maze of size N x N [Basically a 2D matrix]. The source and the destination location is top-left cell and bottom right cell respectively. Some cells are valid to move and some cells are blocked. If one rat starts moving from start vertex to destination vertex, we have to find that is there any way to complete the path, if it is possible then mark the correct path for the rat.

The maze is given using a binary matrix, where it is marked with 0, it is a valid path, otherwise 1 for a blocked cell.

NOTE: The rat can only move in two directions, either to the right or to the down.

 
Input Format

This algorithm will take the maze as a matrix.
In the matrix, the value 0 indicates the free space and 1 indicates the wall or blocked area.
 

Sample Input 1

5
1 0 1 0 1
1 1 1 1 1 
0 0 0 0 0
0 0 0 0 1
1 0 0 0 0 

Sample Output 1
No solution exists

Sample Input 2
5
0 0 1 1 1 
1 0 0 1 1
1 1 0 0 1
1 0 1 0 1
1 0 1 0 0
Sample Output 2
1 1 0 0 0 
0 1 1 0 0 
0 0 1 1 0 
0 0 0 1 0 
0 0 0 1 1  *\    

import java.util.*;
public class Demo{
    static int n ;
    static int[][] mat ;
    static int[][] sol;
    public static void main(String args[])
    {
     Scanner sc = new Scanner(System.in);
     n = sc.nextInt();
     mat = new int[n][n];
     sol = new int[n][n];
     for(int i = 0 ; i<n ; i++)
     {
         for(int j =0 ; j<n ; j++)
         {
             mat[i][j] = sc.nextInt();
         }
     }
     
     boolean b = solve(0,0);
     
     if(b)
     {
         for(int i = 0 ; i<n ; i++)
         {
             for(int j = 0 ; j<n ; j++)
             {
                 System.out.print(sol[i][j]+" ");
             }
             System.out.println();
         }
     }
     else
     {
         System.out.println("No solution exists");
     }
    }
    
    public static boolean solve(int x , int y)
    {
        if(x==n-1 && y ==n-1 && mat[x][y]==0)
        {
            sol[x][y] = 1;
            return true;
        }
        if(x<n && y<n && x>=0 && y>=0 && mat[x][y]==0 && sol[x][y]==0)
        {
            sol[x][y]=1;
            if(solve(x+1,y)) return true;
            if(solve(x , y+1)) return true;
            sol[x][y] =0;
        }
        return false;
    }
}
