import java.util.*;
import java.io.*;
public class Solution{

    private static LNode[] counters = new LNode[1493];
    private static int[][] stuff = new int[1492][3];
    private static LNode root;

    public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	StringTokenizer st = new StringTokenizer(br.readLine());
	counters[0] = new LNode(0);
	for(int i = 0; i < 1492; i++){
	    st = new StringTokenizer(br.readLine());
	    for (int j = 0; j < 3; j++) {
		stuff[i][j] = Integer.parseInt(st.nextToken());
	    }
	    counters[i+1] = new LNode(i+1);
	}
	for(int[] i : stuff){
	    counters[i[0]].setLeft(counters[i[1]]);
	    counters[i[0]].getLeft().setParent(counters[i[0]]);
	    counters[i[0]].setRight(counters[i[2]]);
	    counters[i[0]].getRight().setParent(counters[i[0]]);
	    
	}
	for(LNode l : counters){
	    if(l.getParent() == null){
		root = l;
		break;
	    }
	}
	System.out.println(root);

	

				       
	    
	    
	
    }

    
}
