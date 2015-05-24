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
	    if(i[1] != 0){
		counters[i[0]].setLeft(counters[i[1]]);
		counters[i[0]].getLeft().setParent(counters[i[0]]);
	    }
	    if(i[2] != 0){
		counters[i[0]].setRight(counters[i[2]]);
		counters[i[0]].getRight().setParent(counters[i[0]]);
	    }
	}
	for(LNode l : counters){
	    if(l.getParent() == null){
		root = l;
	    }
	    if(l.getLeft() == null && l.getRight() == null){
		l.setPossible(1);
	    }
	}
	System.out.println(root);
	while(true){
	    boolean valid = true;
	    for(LNode l : counters){
		
		if(l.getLeft() != null && l.getRight() != null){
		    if(l.getLeft().getPossible() != 0 && l.getRight().getPossible() != 0){
			l.setPossible(((l.getLeft().getPossible() + 1L) % 1000000007) * ((l.getRight().getPossible() + 1L) % 1000000007));
		    }
		}else if(l.getLeft() != null && l.getRight() == null){
		    if(l.getLeft().getPossible() != 0){
			l.setPossible((long)((l.getLeft().getPossible() + 1L) % 1000000007));
		    }
		}else if(l.getLeft() == null && l.getRight() != null){
		    if(l.getRight().getPossible() != 0){
			l.setPossible((long)((l.getRight().getPossible() + 1L) % 1000000007));
		    }
		}
	    }
	    for(LNode l : counters){
		if(l.getPossible() == 0){
		    valid = false;
		    break;
		}
	    }
	    if(valid){
		break;
	    }
				   
	}
	long total = 0;
	for(LNode l : counters){
	    total = (total + l.getPossible()) % 1000000007L;
	}
	System.out.println(total);
	System.out.println("HI" + counters[562].getPossible());
	System.out.println(counters[562].getLeft());




				       
	    
	    
	
    }

    
}
