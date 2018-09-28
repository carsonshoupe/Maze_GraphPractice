import java.util.ArrayList;

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
		
		for (int yCounter = 0; yCounter < size; yCounter++){ //Creating verticies
			for (int xCounter = 0; xCounter < size; xCounter++){
				this.vertices[xCounter][yCounter] = vertexFactory.getVertex(xCounter, yCounter); 
			}
		}
		
		Vertex currentVert; //Adding egdes to verticies
		for (int yCounter = 0; yCounter< size; yCounter++){
			for (int xCounter = 0; xCounter < size; xCounter++){
				currentVert = this.vertices[xCounter][yCounter]; 
				//System.out.println(currentVert.toString() + "[" + xCounter + "][" + yCounter + "]");
				
				/*
				if (xCounter > 0){
					currentVert.addEdge(this.vertices[xCounter-1][yCounter], this.edgeFactory);
				}
				*/
				
				if (xCounter < size-1){
					Edge edgeToAdd = this.edgeFactory.getEdge(currentVert, this.vertices[xCounter+1][yCounter]); 
					currentVert.addEdge(this.vertices[xCounter+1][yCounter], edgeToAdd);
					this.vertices[xCounter+1][yCounter].addEdge(currentVert, edgeToAdd);
				}
				
				/*
				if (yCounter > 0){
					currentVert.addEdge(this.vertices[xCounter][yCounter-1], this.edgeFactory);
				}
				*/
				
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
	public 
	
	
	
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
	
	