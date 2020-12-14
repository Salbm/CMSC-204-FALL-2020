package sourcefiles;
/**
 * Tree node class that implements interface
 * @author steph
 *
 * @param <T>
 */
public class TreeNode<T>{

	private T content;
	
	protected TreeNode<T>left;
	protected TreeNode<T>right;
	
	
	/**
	 * Construtor that creates a new TreeNode object with the left and rigt children null and sets content in nodeContent
	 * @param nodeContent 
	 */
	
	public TreeNode (T nodeContent) {
		
		content = nodeContent;
		left = null;
		right = null;
	}
	
	/**
	 * Method to create a deep copy object of the node if needed
	 */
	
	public TreeNode (TreeNode<T>node) {
		
		this(node.left,node.right,node.getData());
		
	}

	public TreeNode(TreeNode<T> left2, TreeNode<T> right2, T info) {
		// TODO Auto-generated constructor stub
		
		content = info;
		left = new TreeNode(left2);
		right = new TreeNode(right2);
	}

	T getData() {
		// TODO Auto-generated method stub
		return content;
	}
}

