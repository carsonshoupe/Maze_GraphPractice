import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.Collections;

class Maze{
	//Instance Variables:
	private Vertex[][] vertices; 
	private ArrayList<Edge> mazeEdges;
	private VertexFactory vertexFactory;
	private EdgeFactory edgeFactory;
	private int size; 
	
	
	//Constructors:
	Maze(int size, VertexFactory vertexFactory, EdgeFactory edgeFactory){
		this.size = size;
		this.vertexFactory = vertexFactory;
		this.edgeFactory = edgeFactory;
		this.vertices = new Vertex[size][size]; 
		this.mazeEdges = new ArrayList<Edge>(); 
		
		for (int yCounter = 0; yCounter < size; yCounter++){ //Creating vertices
			for (int xCounter = 0; xCounter < size; xCounter++){
				this.vertices[xCounter][yCounter] = vertexFactory.getVertex(xCounter, yCounter); 
			}
		}
		
		Vertex currentVert; //Adding egdes to vertices
		for (int yCounter = 0; yCounter< size; yCounter++){
			for (int xCounter = 0; xCounter < size; xCounter++){
				currentVert = this.vertices[xCounter][yCounter]; 
				if (xCounter < size-1){
					Edge edgeToAdd = this.edgeFactory.getEdge(currentVert, this.vertices[xCounter+1][yCounter]); 
					currentVert.addEdge(this.vertices[xCounter+1][yCounter], edgeToAdd);
					this.vertices[xCounter+1][yCounter].addEdge(currentVert, edgeToAdd);
				}
				
				if (yCounter < size-1){
					Edge edgeToAdd = this.edgeFactory.getEdge(currentVert, this.vertices[xCounter][yCounter+1]); 
					currentVert.addEdge(this.vertices[xCounter][yCounter+1], edgeToAdd);
					this.vertices[xCounter][yCounter+1].addEdge(currentVert, edgeToAdd);
				}

				this.mazeEdges.addAll(currentVert.getVertEdges()); 
			}
		}
	}
				
	
	//Methods:
	public Vertex[][] getVertices(){return this.vertices;}
	
	public ArrayList<Vertex> shortestPath(Vertex startVert, Vertex endVert){ 
		VertexDistanceComparator comparator = new VertexDistanceComparator();
		PriorityQueue<Vertex> Q = new PriorityQueue<>(size*size, comparator);
		ArrayList<Edge> relevantEdges = new ArrayList<>();
		Map<Vertex, Edge> lastShortestEdge = new HashMap<>(); 
		
		for (int yCounter = 0; yCounter < size; yCounter++){ 
			for (int xCounter = 0; xCounter < size; xCounter++){
				if (vertices[xCounter][yCounter] == startVert){
					vertices[xCounter][yCounter].setDistanceFromStartVert(0); 
				}					
				else{
					vertices[xCounter][yCounter].setDistanceFromStartVert(1000000); 
				}
				lastShortestEdge.put(vertices[xCounter][yCounter], null); 
				Q.add(vertices[xCounter][yCounter]); 
			}
		}
		
		while (!(Q.isEmpty())){
			Vertex currentVert = Q.remove(); 
			relevantEdges = currentVert.getVertEdges();
			for (Edge e: relevantEdges){
				Vertex connectingVert = e.getVert2();
				if (currentVert.getDistanceFromStartVert() + e.getWeight() < connectingVert.getDistanceFromStartVert()){
					connectingVert.setDistanceFromStartVert(currentVert.getDistanceFromStartVert() + e.getWeight()); 
					Q.remove(connectingVert); 
					Q.add(connectingVert); 
					lastShortestEdge.put(connectingVert, e); 
				}
			}
			relevantEdges.clear();
		}
		
		Edge connectingEdge = lastShortestEdge.get(endVert);
		Vertex workingVert = endVert; 
		Stack<Vertex> shortestPathStack = new Stack<>();
		shortestPathStack.push(workingVert);
		while (!(connectingEdge == null)){
			workingVert = connectingEdge.getVert1();
			shortestPathStack.push(workingVert); 
			connectingEdge = lastShortestEdge.get(workingVert);
		}
		
		ArrayList<Vertex> shortestPathList = new ArrayList<>(shortestPathStack);
		Collections.reverse(shortestPathList); 
		return shortestPathList;
	}
			
			
	
	
	@Override
	public String toString(){
		String outputString = "\n";
		for (int yCounter = 0; yCounter < this.size; yCounter++){
			for (int xCounter = 0; xCounter < this.size; xCounter++){
			outputString += this.vertices[xCounter][yCounter].toString() + ": "; 
				for (Edge E: this.vertices[xCounter][yCounter].getVertEdges()){
					outputString += E.toString() + " ";
				}
			}
			outputString += "\n";
		}
		return outputString;
	}
	
	
}
	
	