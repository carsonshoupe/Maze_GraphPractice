import java.util.ArrayList;

class Vertex{
	//Instance Variables: 
	private ArrayList<Edge> vertEdges;
	private int xCoordinate; 
	private int yCoordinate; 
	private int distanceFromStartVert; 
	
	
	//Constructors: 
	Vertex(int xCoordinate, int yCoordinate){
		this.vertEdges = new ArrayList<Edge>(); 
		this.xCoordinate = xCoordinate; 
		this.yCoordinate = yCoordinate;
	}
		
	
	//Methods:
	public int getDistanceFromStartVert(){return this.distanceFromStartVert;}
	public void setDistanceFromStartVert(int dist){this.distanceFromStartVert = dist;}
	
	public ArrayList<Edge> getVertEdges(){return this.vertEdges;}
	
	public void addEdge(Vertex vert, Edge inputEdge){
		this.vertEdges.add(inputEdge); 
	}
	
	@Override
	public String toString(){
		return "V[" + this.xCoordinate + "][" + yCoordinate + "]";
	}	 
}
	
	