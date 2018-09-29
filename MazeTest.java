import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class MazeTest{
	public static Maze m; 
	public static VertexFactory vf; 
	public static EdgeFactory ef; 
	public static int size; 
	
	@BeforeClass
	public static void setUp(){
		vf = new VertexFactory(); 
		ef = new EdgeFactory(); 
		size = 10; 
		m = new Maze(size, vf, ef);  
		System.out.println(m.toString());
	}
	
	@Test
	public void testSolveMaze(){
		System.out.println("Shortest Path: " + this.m.shortestPath(m.getVertices()[0][0], m.getVertices()[size-1][size-1]).toString() + "\n");
		
		Vertex[][] mazeVerts = m.getVertices(); 
		for (int yCounter = 0; yCounter < size; yCounter++){ 
			for (int xCounter = 0; xCounter < size; xCounter++){
				System.out.println(mazeVerts[xCounter][yCounter].toString() + ": " + mazeVerts[xCounter][yCounter].getDistanceFromStartVert());
			}
		}		
	}
}




//javac -cp .;C:\junit\junit-4.10.jar MazeTest.java
//java -cp .;C:\junit\junit-4.10.jar org.junit.runner.JUnitCore MazeTest