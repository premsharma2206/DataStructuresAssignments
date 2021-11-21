
import java.util.*;
public class BFSTopoSort
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
	    g.BFSTopo();
	   
	    
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
	    
	    g2.BFSTopo();
	}
}
class Graph{
    int v;
    int n;
    List<List<Integer>> adjl;
    int indegrees[];
    String vertices[];
    Graph(int v,String[] vertices){
        this.v = v;
        this.vertices = vertices;
        this.n = this.v - 1;
        this.adjl = new ArrayList<List<Integer>>();
        this.indegrees = new int[this.v];
        for(int i = 0; i < this.v; i++){
            List<Integer> ind = new ArrayList<Integer>();
			this.adjl.add(ind);
            this.indegrees[i] = 0;
        }
        
    }
    public void BFSTopo(){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i< this.v; i++){
            // vertex = this.vertices.get(i);
            if(this.indegrees[i] == 0){
                queue.add(i);
            }    
        }
        int curr ;
        while(queue.size() > 0){
            curr = queue.poll();
            result.add(curr);
            
            for(int i = 0; i < this.adjl.get(curr).size(); i++){
                int value = this.adjl.get(curr).get(i);
                this.indegrees[value] -= 1;
                if(this.indegrees[value] == 0){
                    queue.add(value);
                }
            }
            System.out.println("After loop");
            System.out.println("Indegrees:");
            for(int i = 0; i < this.v; i++){
            
                // vertex = this.vertices.get(i);
                System.out.print(this.indegrees[i]+ " ");
            
            }
            System.out.println();
            System.out.println("Topological sort:");
            for(int i = 0; i < result.size(); i++){
            System.out.print(this.vertices[result.get(i)] + " ");
        }
        System.out.println();
        }
        
    }
    
    public void insertEdge(int u, int v){
        this.adjl.get(u).add(v);
        this.indegrees[v]+=1;
        // int val = this.indegrees.get(v);
        // this.indegrees.put(v,val+1);
    }
    public void printEdges(){
        System.out.println("u " + "v");
        System.out.println("----");
        String vertex;
        for(int i = 0; i < this.v; i++){
   			
            for(int j = 0; j < this.adjl.get(i).size(); j++){
            System.out.print(this.vertices[i]+ " " );
            System.out.println(this.vertices[this.adjl.get(i).get(j)]);
                
            }
            
        }
    
}
}




