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
	
	
	/* 
	public Edge getNorthEdge(){return vertEdges[0];} 
	public Edge getSouthEdge(){return vertEdges[1];}
	public Edge getEastEdge(){return vertEdges[2];} 
	public Edge getWestEdge(){return vertEdges[3];}
	public void setNorthEdge(Edge inputEdge){vertEdges[0] = inputEdge;} 
	public void setSouthEdge(Edge inputEdge){vertEdges[1] = inputEdge;} 
	public void setEastEdge(Edge inputEdge){vertEdges[2] = inputEdge;} 
	public void setWestEdge(Edge inputEdge){vertEdges[3] = inputEdge;} 
	 */
	 
}
	
	