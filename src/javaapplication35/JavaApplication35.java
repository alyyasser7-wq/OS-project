/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication35;

import java.util.ArrayList;
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
}}
