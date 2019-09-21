import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.Math;
public class IP {
	
	public static int[] binary(String[] str)
	{
		//This func is to only to convert the ip to binary
		int arr[] = new int[32];
		int a,b,c,d,i,rem;
		a=b=c=d=1;
		Stack<Integer> st = new Stack<Integer>();
		
		//From here we have to seperate each number in the ip addr
		
		if(str!=null)
		{
			a=Integer.parseInt(str[0]);
			b=Integer.parseInt(str[1]);
			c=Integer.parseInt(str[2]);
			d=Integer.parseInt(str[3]);
		}
		
		//Next step is to convert into binary 
		for(i=0;i<=7;i++)
		{
			rem=a%2;
			st.push(rem);
			a=a/2;
		}
		for(i=0;i<=7;i++)
		{
			arr[i]=st.pop();
		}
		
		for(i=8;i<=15;i++)
		{
			rem=b%2;
			st.push(rem);
			b=b/2;
		}
		for(i=8;i<=15;i++)
		{
			arr[i]=st.pop();
		}
		
		for(i=16;i<=23;i++)
		{
			rem=c%2;
			st.push(rem);
			c=c/2;
		}
		for(i=16;i<=23;i++)
		{
			arr[i]=st.pop();
		}
		
		for(i=24;i<=31;i++)
		{
			rem=d%2;
			st.push(rem);
			d=d/2;
		}
		for(i=24;i<=31;i++)
		{
			arr[i]=st.pop();
		}
		
		return(arr);
	}
	

	
	public static int[] decimal(int[] bin)
	{
		int[] arr1 = new int[4];
		int a,b,c,d,i,j;
		a=b=c=d=0;
		j=7;
		
		for(i=0;i<8;i++)
		{
			a=a+(int)(Math.pow(2, j))*bin[i];
			j--;
		}
		
		j=7;
		for(i=8;i<16;i++)
		{
			b=b+bin[i]*(int)(Math.pow(2, j));
			j--;
		}
		
		j=7;
		for(i=16;i<24;i++)
		{
			c=c+bin[i]*(int)(Math.pow(2, j));
			j--;
		}
		
		j=7;
		for(i=24;i<32;i++)
		{
			d=d+bin[i]*(int)(Math.pow(2, j));
				j--;
		}
		
		arr1[0]=a;
		arr1[1]=b;
		arr1[2]=c;
		arr1[3]=d;
		return arr1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i;
		String[] str = new String[4];
		String ip;
		Scanner read =  new Scanner(System.in);
		 System.out.println("Enter the IP Address and Subnet Mask in the form of (X.Y.Z.U/n), n being the value of the subnet mask");
		 ip = read.next();
		 //Because we have to seperate sbnet and ip addr
		 String[] str1 = ip.split("/");
		 String tr = str1[0];
		 
		 //Because we have to spilt the ip addr
		 str = tr.split("\\.");
		 
		 int[] b = new int[32];
		 System.out.println();
		 
		 b=binary(str);
		 
		 int n = Integer.parseInt(str1[1]);
		 int[] network = new int[32];
		 int[] usable = new int [32];
		 int diff=32-n;
		 
		 //Network Address
		 for(i=0;i<=(31-diff);i++)
		 {
			 network[i] = b[i];
			 usable[i] = b[i];
		 }
		 
		 for(i=31;i>(31-diff);i--)
		 {
			network[i] = 0; 
		 }
		 
		 //Last bits to zero
		 for(i=31;i>(31-diff);i--)
		 {
			usable[i] = 1; 
		 }
		 System.out.println();
		 
		 int[] net = decimal(network);
		 int[] use = decimal(usable);
		 
		// Printing in dotted decimal format  
	        System.out.println("Network Address : " + net[0]  
	                     + "." + net[1] + "." + net[2] + "." + net[3]);  
	          
	        // Printing in dotted decimal format 
	        System.out.println("broadcast address : " 
	                     + use[0] + "." + use[1] + "." + use[2] + "." + use[3]);  
	        
	        System.out.println("Therefore the 10th usable ip : " 
	                + use[0] + "." + use[1] + "." + use[2] + "." + (net[3]+10));  
	}

}
