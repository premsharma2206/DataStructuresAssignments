
import java.util.*;
public class DFSTopoSort
{
	public static void main(String[] args) {
	    int V = 8;
	    // System.out.println("Enter the list of vertices in the graph");
	    
	    String[] vertices = {"1", "2", "3", "4", "5", "6", "7","8"};
	    Graph g = new Graph(V,vertices);
	    g.insertEdge(0,1);
	    g.insertEdge(0,4);
	    g.insertEdge(0,5);
	    g.insertEdge(1,2);
	    g.insertEdge(1,6);
	    g.insertEdge(1,4);
	    g.insertEdge(2,3);
	    g.insertEdge(3,4);
	    g.insertEdge(4,7);
	    g.insertEdge(4,6);
	    g.insertEdge(5,7);
	    g.insertEdge(5,4);
	    g.insertEdge(6,3);
	    g.insertEdge(6,7);
	    System.out.println("Graph has the following edges:");
	    g.printEdges();
	    for(int i = 0; i < g.v; i++){
	        if(g.visited[i] == false){
	            g.DFSToposort(i);
	            System.out.println();
	            System.out.println("After loop");
	           // for(int j = 0; j < g.v; j++){
	           //     System.out.print(j+1 + " ");
	           // }
	            System.out.println();
                for(int j = 0; j < g.v; j++){
                    System.out.print(g.vertices[g.toponumber[j]]+ " ");
            
                }
                System.out.println();
	        }
	    }
	    System.out.println("Topological Sort: ");
	    String u;
	   // for(int i = 0; i < g.v; i++){
	   //    System.out.print(i+1 + " ");
	   // }
	   // System.out.println();
        for(int i = 0; i < g.v; i++){
            System.out.print(g.vertices[g.toponumber[i]]+ " ");
        }
        System.out.println();
	    System.out.println();
	    
	    V = 14;

	    // for(int i = 0; i < V; i++){
	    //     vert = sc.nextLine();
	    //     vertices2.add(vert);
	    // }
	   String[] vertices2 = {"m", "n", "o", "p", "q", "r", "s","t","u","v","w","x","y","z"};
	    Graph g2 = new Graph(V,vertices2);
	    g2.insertEdge(0,5);
	    g2.insertEdge(0,4);
	    g2.insertEdge(0,11);
	    g2.insertEdge(1,2);
	    g2.insertEdge(1,4);
	    g2.insertEdge(1,8);
	    g2.insertEdge(2,9);
	    g2.insertEdge(2,5);
	    g2.insertEdge(2,6);
	    g2.insertEdge(3,2);
	    g2.insertEdge(3,6);
	    g2.insertEdge(3,13);
	    g2.insertEdge(4,7);
	    g2.insertEdge(5,8);
	    g2.insertEdge(5,12);
	    g2.insertEdge(6,5);
	    g2.insertEdge(8,7);
	    g2.insertEdge(9,10);
	    g2.insertEdge(9,11);
	    g2.insertEdge(10,13);
	    g2.insertEdge(12,9);
	   
	    System.out.println("Graph has the following edges:");
	    g2.printEdges();
	    
	    for(int i = 0; i < g2.v; i++){
	
	        if(g2.visited[i] == false){
	           // System.out.println();
	            g2.DFSToposort(i);
	            System.out.println("After loop,");
	            System.out.println("Topological Number Array:");
	           for(int j = 0; j < g2.v; j++){
	              System.out.print(j+1 + " ");
	            }
	            System.out.println();
                for(int j = 0; j < g2.v; j++){
                    if(j>8){
                        System.out.print(" ");
                    }
                    if(g2.toponumber[j]>=0)
                        System.out.print(g2.vertices[g2.toponumber[j]]+ " ");
                    else
                        System.out.print("- ");
            
                }
                System.out.println();
	        }
	        
	    }
	    System.out.println("Topological Sort: ");
	   // for(int i = 0; i < g2.v; i++){
	   //    System.out.print(i+1 + " ");
	   // }
	   // System.out.println();
        for(int i = 0; i < g2.v; i++){
            if(i>8){
                        System.out.print(" ");
                    }
            System.out.print(g2.vertices[g2.toponumber[i]]+ " ");
        }
        System.out.println();
	    System.out.println();
	}
}

class Graph{
    int v;
    int n;
    List<List<Integer>> adjl;
    Boolean visited[];
    int toponumber[];
    String vertices[];
    Graph(int v,String[] vertices){
        this.v = v;
        this.vertices = vertices;
        this.n = this.v - 1;
        this.adjl = new ArrayList<List<Integer>>();
        this.visited = new Boolean[this.v];
        this.toponumber = new int[this.v];
        for(int i = 0; i < this.v; i++){
            List<Integer> ind = new ArrayList<Integer>();
			this.adjl.add(ind);
            this.visited[i] = false;
            this.toponumber[i] = -1;
        }
        
    }
    public void DFSToposort(int u){
	        
	    this.visited[u] = true;
	    int v;
	   // System.out.print(u + " ");
        for(int i = 0; i < this.adjl.get(u).size(); i++){
	       v = this.adjl.get(u).get(i);
	
	       if(this.visited[v] == false){
	           this.DFSToposort(v);
	       }
	    }
	    this.toponumber[this.n] = u;
	    this.n -= 1;
	}
    
    public void insertEdge(int u, int v){
        this.adjl.get(u).add(v);
        // int val = this.indegrees.get(v);
        // this.indegrees.put(v,val+1);
    }
    public void printEdges(){
        System.out.println("u " + "v");
        String vertex;
        for(int i = 0; i < this.v; i++){
   			
            for(int j = 0; j < this.adjl.get(i).size(); j++){
            System.out.print(this.vertices[i]+ " " );
            System.out.println(this.vertices[this.adjl.get(i).get(j)]);
                
            }
            
        }
    
}
}


