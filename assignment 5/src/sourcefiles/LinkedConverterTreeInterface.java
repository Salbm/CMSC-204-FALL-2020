package sourcefiles;
/**
 * Generic Interface for the creation of the tree
 * @author steph
 *
 * @param <T>
 */
public interface LinkedConverterTreeInterface<T> {
	
	/**
	 * returns reference of root
	 * @return
	 */
	public TreeNode<T> getRoot();
	
	/**
	 * sets root of the tree
	 * @param newNode
	 */
	public void setRoot(TreeNode<T> newNode);
	
	/**
	 * Adds result to the position in the tree depending on the result from recusrive method addNode
	 * @param code
	 * @param result
	 * @return
	 */
	public LinkedConverterTreeInterface<T> insert(T code,
            T result);
	
	/**
	 * Recursive method that adds element on the correct position of the tree based on the code
	 * @param root
	 * @param code
	 * @param letter
	 */
	public void addNode(TreeNode<T> root,
            T code,
            T letter);
	
	/**
	 * Fetch data in the tree 
	 * @param code
	 * @return
	 */
	public T fetch(java.lang.String code);
	
	/**
	 * Recursive method that fetches data in the tree
	 * @param root
	 * @param code
	 * @return
	 */
	public T fetchNode(TreeNode<T> root,
            T code);
	
	/**
	 * Operation not supported on a tree so it throws exception
	 * @param data
	 * @return
	 * @throws java.lang.UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<T> delete(T data)
            throws java.lang.UnsupportedOperationException;
	
	/**
	 * Operation not supported on a tree so it throws exception
	 * @return
	 * @throws java.lang.UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<T> update()
            throws java.lang.UnsupportedOperationException;
	
	/**
	 * Method builds tree by inserting tree nodes
	 */
	public void buildTree();
	
	/**
	 * Returns an arraylist of the items in the linked converter tree used for testing to see if tree was built correctly
	 * @return
	 */
	public java.util.ArrayList<T> toArrayList();
	
	/**
	 * Recursive method to put the contents of the linked converter tree in an arraylist 
	 * @param root
	 * @param list
	 */
	public void LNRoutputTraversal(TreeNode<T> root,
            java.util.ArrayList<T> list);

}
