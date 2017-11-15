import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
/*
 @Author 
 Bhanu Prakash Pamidi
*/
public class FindLocalPeaks {
public static void main(String args[]){
	try{
      String input=readFile(args[0]); //calling readFile method which reads the contents of input file and puts everything in a single string
      
      File f = new File("LocalPeaks_Output.txt");
      f.createNewFile();
      FileWriter fWriter = new FileWriter(f); //for writing output to output file

      PrintWriter pWriter=new PrintWriter(fWriter);//creates a pWriter instance for printing the ouput
      
      input=input.replaceAll("[a-zA-Z=]","").trim(); // removes "problemMatrix = " 
      input=input.replaceAll(" ","");
      
      
      input=input.replace("[[",""); //removes initial [[ braces
      input=input.replace("]]",""); //removes ]] we have at the end
      input=input.replaceAll("[\\[]",""); //removes [ we have beginning of each row
      String[] str2=input.split("],"); //each string index will contain data for one row e.g str2[0]=101, 2, 3, 4, 5, 6, 7, 8, 9, 10
      int numberOfRows=str2.length; //no of strings in sbove string array=no of rows
      int numberOfColumns=findNumberOfOcuurences(str2[0],','); //take one string row..count number of commas ,add one to it..it will be number of columns
      numberOfColumns+=1;
      int[][] array=new int[numberOfRows][numberOfColumns];
      for(int i=0;i<str2.length;i++){
      
      String str3[]=str2[i].split(",");
      for(int j=0;j<str3.length;j++){
    	  array[i][j]=Integer.parseInt(str3[j]);
      }
      }
      for(int i=1;i<numberOfRows-1;i++){
    	  for(int j=1;j<numberOfColumns-1;j++){
    		  if(array[i-1][j]<=array[i][j]&&array[i+1][j]<=array[i][j]&&array[i][j-1]<=array[i][j]&&array[i][j+1]<=array[i][j]){
                       // found that array[i][j] is a peak..putting it in output file
    			 System.out.println("Value "+array[i][j]+" is a peak at row="+i+"column="+j); 
    			 pWriter.println("Value "+array[i][j]+" is a peak at row="+i+"column="+j);
    		  }
    	  }
      }
     
      pWriter.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
//for finding number of occurences of a character in a string ....it is used to find number of columns 
public static int findNumberOfOcuurences(String input,char expected){
	int count=0;
	for (int i=0; i < input.length(); i++)
    {
        if (input.charAt(i) == expected)
        {
             count++;
        }
    }
	return count;
}
//for reading contents of file to a string
public static String readFile(String filename){

	String output="";
	try{
	URL path =FindLocalPeaks.class.getResource(filename);
	File f = new File(path.getFile());
	BufferedReader br = new BufferedReader(new FileReader(f));
	String currentLine;
	while((currentLine=br.readLine())!=null){
		output=output+currentLine;
	}
	br.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	return output;
}
}
