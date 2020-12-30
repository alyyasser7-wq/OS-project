/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication35;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class JavaApplication35 {
static int LRU(ArrayList<Integer> pages,int capacity,int n){ 
    ArrayList<Integer> Ar = new ArrayList<Integer>(capacity);
    ArrayList<Integer> index = new ArrayList<Integer>(capacity);
    int pagefault = 0;
    int counter=0;
    
        for (int i=0; i<n; i++) 
        { 
            if (Ar.size() < capacity)  // array.size=4 , cap = 4
            {               
                if (!Ar.contains(pages.get(i))) //
                { 
                    Ar.add(pages.get(i)); 
                    pagefault++; 
                    index.add(pages.get(i)); 
                    counter++;
                    System.out.println("no page replacement occured");
                    System.out.println(Ar);
                } 
                 else{
                    
                    System.out.println("page"+pages.get(i)+"already in memory "); 
                }
            } 
              else
        { 
           
            if (!Ar.contains(pages.get(i))) //i=5
            { 
               int val = index.get(0);
               int nw =Ar.indexOf(val); 
               Ar.remove(Integer.valueOf(val)); //remove le value=7
               Ar.add(nw,pages.get(i));
               System.out.println("pages "+val+" was replaced by "+pages.get(i)); // frame 7 was replaced by 3
               System.out.println(Ar); // cout ll array 
               index.remove(0);
               index.add(pages.get(i)); 
               pagefault++; 
               counter=i;
            } 
            else
            {
             index.remove(Integer.valueOf(pages.get(i)));
             index.add(pages.get(i));
             System.out.println("page"+pages.get(i)+"already in memory "); 
            }
        }      
       }   
    return (pagefault); 
   }
static int First_in_First_Out(ArrayList<Integer> pages, int n, int capacity) 
    { 
        Queue<Integer> index = new LinkedList<>() ; 
        ArrayList<Integer> Ar = new ArrayList<Integer>(capacity);
        
        int counter=0;
        int pagefault = 0;
        for (int i=0; i<n; i++) 
        { 
            // Check if the frame isnot full 
            if (Ar.size() < capacity) 
            { 
                if (!Ar.contains(pages.get(i))) 
                { 
                   Ar.add(pages.get(i)); 
                    pagefault++;         
                    index.add(pages.get(i));
                    counter++;
                    System.out.println("no page replacement occured");
                    System.out.println(Ar);
                }
                else
                {   
                    System.out.println("page"+pages.get(i)+"already in memory "); 
                }
            } 
           
            else
            { 
                if (!Ar.contains(pages.get(i))) 
                { 
                    int val = index.poll();
                    int Y =Ar.indexOf(val);
                    System.out.println("hit");
                    Ar.remove(Integer.valueOf(val)); //remove le value=7
                    Ar.add(Y,pages.get(i));
                    System.out.println("page "+val+" was replaced by "+pages.get(i)); 
                    System.out.println(Ar);
                    index.add(pages.get(i)); 
                    pagefault++;
                    counter=i;
                } 
            } 
        } 
        return (pagefault); 
    } 
  static int optimal(ArrayList<Integer> pages,int capacity,int n)
  { 
    ArrayList<Integer> Ar = new ArrayList<Integer>(capacity);
    ArrayList<Integer> index = new ArrayList<Integer>(capacity);
    ArrayList<Integer> x = new ArrayList<Integer>(capacity);
    int counter=0;
    int faults = 0;
    for (int i=0; i<n; i++) 
    { 
     if (Ar.size() < capacity)
     {               
       if (!Ar.contains(pages.get(i))) //
       { 
         Ar.add(pages.get(i)); 
         faults++; 
         index.add(pages.get(i)); 
         counter++;
         System.out.println("no page replacement occured");
         System.out.println(Ar);
       } 
       else
       {
          System.out.println("page"+pages.get(i)+"already in memory "); 
       }
     } 
     else
     { 
       if (!Ar.contains(pages.get(i))) //i=5
       { 
         x.clear();
         for(int j=0;j<capacity;j++)
         {
           x.add(-1);
         } 
         for(int k=0;k<capacity;k++)
         {
           for(int z=i;z<n;z++)
           {
            if(index.get(k)==pages.get(z))
            {
             x.set(k, z);
            }
           }
         }
         int max=x.get(0);
         counter=0;
         for(int loop=0;loop<capacity;loop++)
         {
           if(x.get(loop)==-1)
           {
            max=x.get(loop);
            counter=loop;
            break;
           }
          if(max<x.get(loop))
          {
            max=x.get(loop);
            counter=loop;
          }
         }
         int val = index.get(counter);
         int y =Ar.indexOf(val);
         System.out.println("hit");
         Ar.remove(Integer.valueOf(val));
         Ar.add(y,pages.get(i));
         System.out.println("page "+val+" was replaced by "+pages.get(i)); 
         System.out.println(Ar);
         index.remove(counter);
         index.add(pages.get(i));
         faults++; 
        } 
        else
        {
          System.out.println("page"+pages.get(i)+"already in memory ");
        }
      } 
    } 
   return (faults); 
  }
  public static void main(String[] args) {
        ArrayList<Integer> Ar = new ArrayList<Integer>();
        Scanner x = new Scanner(System.in);
        int frame = 0;
        System.out.println("please enter how many frames you need to work with: "); 
        frame=x.nextInt();
        System.out.println("please the numbers you want to use and -1 when you want to process: ");
        int y=x.nextInt();
        while(y!=-1)
        {
        if(y<0)
          {
            System.out.println("enter a correct number ");  
          }
          else
          {
            Ar.add(y);
          }
          y = x.nextInt();
        }
        System.out.println("choose what algorithem you want to use:");
        System.out.println("for Fifo=1  optimal=3 LRU=3");
       int z=x.nextInt();
       if(z==1)
       {
       System.out.println("Using FIFO algoritem: ");
        System.out.println(First_in_First_Out(Ar,frame,Ar.size()));
       }
       else if(z==2)
       {
        System.out.println("optimal:");
        System.out.println(optimal(Ar, frame, Ar.size()));
       }
       else if (z==3)
       {
        System.out.println("LRU:");
        System.out.println(LRU(Ar, frame, Ar.size()));
       }
      
}}
