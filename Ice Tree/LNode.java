import java.util.*;
public class LNode{
    private int number;
    private long possible;
    private LNode left, right, parent;
    
    public LNode(int num){
	number = num;
    }

    public String toString(){
	return "LNode(" + number + ")";
    }
    
    public int getNumber(){
	return number;
    }

    public void setPossible(long value){
	possible = value;
    }

    public long getPossible(){
	return possible;
    }
    
    public void setLeft(LNode s){
	left = s;
    }
    
    public LNode getLeft(){
	return left;
    }
    
    public void setRight(LNode s){
	right = s;
    }	   
    
    public LNode getRight(){
	return right;
    }
    
    public void setParent(LNode s){
	parent = s;
    }
    
    public LNode getParent(){
	return parent;
    }
    
}
    
