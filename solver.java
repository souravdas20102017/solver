import java.io.*;
import java.util.*;
class solver
{
    public static void main(String args[])
    {
        
         int a[][]={{2,0,5,0,0,9,0,0,4},
                   {0,0,0,0,0,0,3,0,7},
                   {7,0,0,8,5,6,0,1,0},
                   {4,5,0,7,0,0,0,0,0},
                   {0,0,9,0,0,0,1,0,0},
                   {0,0,0,0,0,2,0,8,5},
                   {0,2,0,4,1,8,0,0,6},
                   {6,0,8,0,0,0,0,0,0},
                   {1,0,0,2,0,0,7,0,8}};
         solver obj=new solver();
         obj.display(a);
         System.out.println();
         boolean d=obj.solution(a);
         obj.display(a);
         }
         void display(int a[][])
        {
            for(int i=0;i<9;i++)
             {
            if(i%3==0 && i!=0)
                {
                    for(int k=0;k<11;k++)
                    {
                        System.out.print("- ");
                        
                    }
                    System.out.println();
                }
            
            for(int j=0;j<9;j++)
            {
                if(j%3==0 && j!=0)
                {
                    System.out.print("| ");
                }
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
            }
            
    }
    int[] empty(int a[][])
    {
        int []k={-1,-1};
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(a[i][j]==0)
                {
                   k[0]=i;
                   k[1]=j;
                   return(k);
                }
            }
        }
       return(k) ;
    }
   boolean check(int a[][],int r,int c,int num)
   {
       
       //row && col
       for(int i=0;i<9;i++)
       {
          if((num==a[r][i] && c!=i) || (num==a[i][c] && r!=i))
           {
            return false;   
         }
        }
        //box
        int s=0,e=0;
       int divr=r/3;
       int divc=c/3;
       if(divr==2)
       {
           s=6;
        }
       if(divr==1)
       {
           s=3;
        }
       if(divr==0)
        {
            s=0;
        }
       if(divc==2)
       {
           e=6;
        }
       if(divc==1)
       {
           e=3;
        }
       if(divc==0)
        {
            e=0;
        }
       for(int i=s;i<s+3;i++)
       {
           for(int j=e;j<e+3;j++)
           {
            if((num==a[i][j]) && (r!=i && j!=c))
            {
                return false;
            }
        }
       }
        return true;
        
    }
  boolean solution(int a[][])
  {
      int d,e;
      int b[]=empty(a);
      d=b[0];e=b[1];
      
      if(d==-1)
      {
          return true;
       }
       else{
        for(int i=1;i<10;i++)
        {
         if(check(a,d,e,i))
         {
             a[d][e]=i;
             if(solution(a))
             { 
                 return true;
                }
                else
                {
                    a[d][e]=0; 
                }
            }
        }
       return false;
    }
  }
}
                    
                 
        
      
      
    
       
