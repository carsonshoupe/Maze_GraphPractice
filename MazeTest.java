import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class MazeTest{
	public static Maze m; 
	public static VertexFactory vf; 
	public static EdgeFactory ef; 
	
	@BeforeClass
	public static void setUp(){
		vf = new VertexFactory(); 
		ef = new EdgeFactory(); 

		m = new Maze(8, vf, ef);  
	}
	
	@Test
	public void testMaze(){
		System.out.println(m.toString());
	}
}




//javac -cp .;C:\junit\junit-4.10.jar MazeTest.java
//java -cp .;C:\junit\junit-4.10.jar org.junit.runner.JUnitCore MazeTest