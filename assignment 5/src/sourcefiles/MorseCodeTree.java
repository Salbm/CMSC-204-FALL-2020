package sourcefiles;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> TreeRoot;

	/**
	 * MorseCodeTree default constructor
	 */
	public MorseCodeTree() {
		
		TreeRoot = null;
		buildTree();
	}

	/**
	 * returns reference to the root
	 * @return TreeRoot
	 */
	public TreeNode<String> getRoot() {
		// TODO Auto-generated method stub
		return TreeRoot;
	}

	
	/**
	 * sets root of tree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		
		TreeRoot = new TreeNode<String>(newNode);
	}

/**
 * inserts letter in a determinate position
 */
	public MorseCodeTree insert(java.lang.String code,
            java.lang.String letter) {
				
		if (TreeRoot == null) {
			
			TreeRoot = new TreeNode <String>(letter);
		}
		
		else {
			
			addNode(TreeRoot, code, letter);
		}
		
		return this;
	}

	
	

	/**
	 * Recursive method that adds a node to the Tree at the correct position
	 * @param root 
	 * @param code 
	 * @param letter 
	 * 
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub
		
		if (code.length()>1) {
			
			if (code.charAt(0)=='-') {
				
				addNode(TreeRoot.right, code.substring(1), letter);
			}
			
			else {
				addNode(TreeRoot.left, code.substring(1), letter);
			}
		}
		else {
			
			if(code.equals(".")) {
				
				TreeRoot.left = new TreeNode<String>(letter);
			}
			else {
				
				TreeRoot.right = new TreeNode<String>(letter);
			}
		}
	}

	
	/**
	 * Returns a string representing the code
	 */
	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		
		String x = fetchNode(TreeRoot,code);
		return x;
	}

	/**
	 * Recursive data that fetches data from tree corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		
		String content = "";
		
		if(code.length()>1) {
			
			if(code.charAt(0)=='.') {
				
				content += fetchNode(root.left,code.substring(1));
			}
			
			else {
				
				content += fetchNode(root.right,code.substring(1));
			}
			
			
		}
		
		else {
			
			if(code.equals(".")) {
				
				content += root.left.getData();
				return content;
			}
			else {
				
				content += root.right.getData();
				return content;
			}
		}
		
		return content;
	}

	/**
	 * Unsupported operation 
	 */
	@Override	
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * Unsupported operation 
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * Inserts nodes into tree
	 */
	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		
			insert("","");
			insert(".","e"); insert("-","t");
			insert("..","i"); insert(".-","a");insert("-.","n"); insert("--","m");
			insert("...","s"); insert("..-","u");insert(".-.","r"); insert(".--","w");insert("-..","d"); insert("-.-","k");insert("--.","g"); insert("---","o");
			insert("....","h"); insert("...-","v");insert("..-.","f"); insert(".-..","l");insert(".--.","p"); insert(".---","j");insert("-...","b"); insert("-..-","x");insert("-.-.","c"); insert("-.--","y");insert("--..","z"); insert("--.-","q");
	}

	
	/**
	 * Returns items in the tree in arraylist form
	 * @return ArrayList
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		
		ArrayList<String>ArrayList=new ArrayList<String>();
		
		LNRoutputTraversal(TreeRoot,ArrayList);
		
		return ArrayList;
	}

	/**
	 * Method that orders items in the tree
	 * 
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		
		if(root.left == null && root.right ==null) {
			
			list.add(root.getData()+ " ");
		}
		
		else {
			
			if(root.left != null) {
				
				LNRoutputTraversal(root.left,list);
				
				list.add(root.getData()+ " ");
				
			}
			
			if(root.right != null) {
				
				LNRoutputTraversal(root.right,list);
			}
		}
	}
}
