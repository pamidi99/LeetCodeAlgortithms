
Part1: Program to implement the standard Dijkstra's algorithm for finding shortest paths from a given source node to a given destination node in graphs.
Part2: Program to find the shortest pair of edge-disjoint paths in a graph, from a given source node to a given destination node. The slides on possible algorithms for this part are given in the Moodle.

Input File Graph Instance Format:

The graph instances will be supplied as plain ASCII text files, with the format described below. The first line of the graph contains a single number which gives the number N of vertices in the graph. The rest of the file is an adjacency list, one line per edge. In each line, there are four numbers, separated by spaces or tabs. The first two numbers are integers between 1 and Nand indicate source and destination vertices respectively. The third number is a real number indicating the cost of the edge. The fourth number is an integer specifying edge capacity - we do not need it for this programming project.

Note that this format can also represent directed graphs. But in this project, we are using the files to record undirected graphs, so all input files will specify an edge only once - indicating a bidirectional link.

Example:
4
1 2 4.0000 192
1 3 3.0000 192
2 4 4.0000 96
3 4 8.0000 48



Steps to Run:
1.Opening Command Window :
   a.go to the folder in which project is present 
   b.press Shift+Right Click ,then select "open command window here"
2.Make sure  java Java jre folder is set to path variable in command window .if you dont have it set,please use fallowing command to set it.
   set path= <java folder address>
3.compile both the files(Part1.java,Part2.java).use the fallowing command to compile 

   javac Part1.java
   javac Part2.java

4.Run each file using fallowing command

   java Part1 inputfilename  (java Part1 input1.txt)

 
                    
   
