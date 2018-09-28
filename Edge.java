class Edge{
	//Instance Variables:
	private int weight; 
	private Vertex vert1; 
	private Vertex vert2;
	
	
	//Constructors: 
	Edge(Vertex inputVert1, Vertex inputVert2){
		setVert1(inputVert1); 
		setVert2(inputVert2);  
	}
		
		
		
	
	//Methods: 
	public int getWeight(){return this.weight;}
	public Vertex getVert1(){return this.vert1;}
	public Vertex getVert2(){return this.vert2;}
	public void setWeight(int inputWeight){this.weight = inputWeight;}
	public void setVert1(Vertex inputVert){this.vert1 = inputVert;}
	public void setVert2(Vertex inputVert){this.vert2 = inputVert;}
	
	@Override
	public String toString(){
		return String.valueOf(weight); 
	}
}
	
	
	