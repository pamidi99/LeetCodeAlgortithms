import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
/*
 @Author 
 Bhanu Prakash Pamidi-800972464
*/
public class MainClass {
public static void main(String args[]){
	try{
      String input=readFile(args[0]);
      
      URL path =MainClass.class.getResource("localPeaks_Output.txt");
      File f = new File("LocalPeaks_Output.txt");
      f.createNewFile();
      FileWriter fWriter = new FileWriter(f);
      PrintWriter pWriter=new PrintWriter(fWriter);//creates a pWriter instance for printing the ouput
      
      input=input.replaceAll("[a-zA-Z=]","").trim();
      input=input.replaceAll(" ","");
      
      
      input=input.replace("[[","");
      input=input.replace("]]","");
      input=input.replaceAll("[\\[]","");
      String[] str2=input.split("],");
      int numberOfRows=str2.length;
      int numberOfColumns=findNumberOfOcuurences(str2[0],',');
      numberOfColumns+=1;
      int[][] array=new int[numberOfRows][numberOfColumns];
      System.out.println("input after replacing string present is"+input);
      for(int i=0;i<str2.length;i++){
      System.out.println("str["+i+"] after replacing string present is"+str2[i]);
      String str3[]=str2[i].split(",");
      for(int j=0;j<str3.length;j++){
    	  array[i][j]=Integer.parseInt(str3[j]);
      }
      }
      for(int i=1;i<numberOfRows-1;i++){
    	  for(int j=1;j<numberOfColumns-1;j++){
    		  if(array[i-1][j]<=array[i][j]&&array[i+1][j]<=array[i][j]&&array[i][j-1]<=array[i][j]&&array[i][j+1]<=array[i][j]){
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
public static String readFile(String filename){

	String output="";
	try{
	URL path =MainClass.class.getResource(filename);
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
