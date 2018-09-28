import java.util.*;

class VertexDistanceComparator implements Comparator<Vertex>{
	public int compare(Vertex vert1, Vertex vert2){
		if (vert1.getDistanceFromStartVert() < vert2.getDistanceFromStartVert()){
			return -1; 
		}
		else if (vert1.getDistanceFromStartVert() == vert2.getDistanceFromStartVert()){
			return 0; 
		}
		else{
			return 1;
		}
	}
	public boolean equals(Object o){
		if (this == o){
			return true;
		}
		else{
			return false;
		}
	}
}