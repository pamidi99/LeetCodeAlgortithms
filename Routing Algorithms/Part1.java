import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//@Author
//Bhanu Prakash Pamidi-800972464


public class Part1 {
	public static int pickMinDistUntravelledVertex(double dist[],boolean srcVertex[],int noOfVertices){
		double min=Double.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<noOfVertices;i++){
			if(!srcVertex[i]&&dist[i]<min){
				min=dist[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	public static void main(String[] args) 
	{
		if(args.length == 0)
		{
			System.out.println("Please enter InputFile name");
			System.out.println("Usage: java (FileName) (Input File)");
			return;
		}
		else if(args.length > 1)
		{
			System.out.println("Please enter only 1 argument");
			return;
		}
		else
		{
			
			BufferedReader reader = null;
			

			try {
				//reading contents from input.txt and storing it in ArrayList
				String text = null;
				String inputFile = args[0];
				reader = new BufferedReader(new FileReader(inputFile));
				 
				text=reader.readLine();
				int noOfVertices=Integer.parseInt(text);
				//System.out.println(""+noOfVertices);
				double graph[][]=new double[noOfVertices][noOfVertices];
				for(int i=0;i<noOfVertices;i++)
				{
				  for(int j=0;j<noOfVertices;j++){
					  graph[i][j]=Double.MAX_VALUE;
					  
				  }
				  graph[i][i]=0;
				}
				while ((text = reader.readLine()) != null) 
				{
					String[] resultingTokens = text.split("\\s+");
					int fromVertex=Integer.parseInt(resultingTokens[0]);
					int toVertex=Integer.parseInt(resultingTokens[1]);
					double edgeWeight=Double.parseDouble(resultingTokens[2]);
					//System.out.println("edge connects"+resultingTokens[0]+" & "+resultingTokens[1]+"its weight is "+resultingTokens[2]);
					graph[fromVertex-1][toVertex-1]=edgeWeight;
					graph[toVertex-1][fromVertex-1]=edgeWeight;
					
				}
				boolean srcSet[]=new boolean[noOfVertices];
				double dist[]=new double[noOfVertices];
				int beforeVertex[]=new int[noOfVertices];
			    System.out.println("Please enter source index");
			    Scanner sc=new Scanner(System.in);
			    int srcVertex=Integer.parseInt(sc.nextLine())-1;
				for(int i=0;i<noOfVertices;i++){
					srcSet[i]=false;
					dist[i]=Double.MAX_VALUE;
					beforeVertex[i]=-1;
				}
				dist[srcVertex]=0.0;
				for(int count=0;count<noOfVertices;count++){
					int currentVertex=pickMinDistUntravelledVertex(dist,srcSet,noOfVertices);
					srcSet[currentVertex]=true;
					
					for(int j=0;j<noOfVertices;j++){
						if(!srcSet[j]&&graph[currentVertex][j]!=Double.MAX_VALUE&&dist[currentVertex]!=Double.MAX_VALUE&&dist[j]>(dist[currentVertex]+graph[currentVertex][j])){
							dist[j]=dist[currentVertex]+graph[currentVertex][j];
							beforeVertex[j]=currentVertex;
						}
					}
				}
				
			    
				 
			        System.out.println("Please enter destination index");
				    int destVertex=Integer.parseInt(sc.nextLine())-1;
				    
				    ArrayList<Integer> path=new ArrayList<Integer>();
				    int beforevertex=destVertex;
				    while(beforevertex!=srcVertex){
				    	path.add(beforevertex);
				    	beforevertex=beforeVertex[beforevertex];
				    }
				    path.add(beforevertex);
				    
				    
				    System.out.println("path is given below");
				    System.out.print((path.get(path.size()-1)+1)+" > ");
				    for(int i=path.size()-2;i>0;i--){
				    	System.out.print(path.get(i)+1+" > ");
				    }
				    System.out.println(path.get(0)+1+" weight of the path is "+dist[destVertex]);
				    	
				    
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			
		}
	}
}
