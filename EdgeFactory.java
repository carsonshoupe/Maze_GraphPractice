import java.util.Random;

class EdgeFactory{
	//Instance Variables
	
	
	//Constructors: 
	EdgeFactory(){}
	
	//Methods: 
	public Edge getEdge(Vertex vert1, Vertex vert2){
		Edge outputEdge = new Edge(vert1, vert2); 
		
		Random rand = new Random(); 
		int randomWeight = rand.nextInt(10);
		outputEdge.setWeight(randomWeight); 
		
		return outputEdge;
	}
}
		

		