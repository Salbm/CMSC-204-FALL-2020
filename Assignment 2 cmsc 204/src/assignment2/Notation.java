package assignment2;

import java.util.Stack;



/**
 * Notation class
 * @author Stephanie Albornoz
 *
 */
public class Notation {
 
	//Notation constructor
	public Notation() {
		
	}
	
	
	// Classes and initiation of stack and queue, to help with exception handling
	private static NotationQueue<String> NotationQueue;
	
	private static NotationStack<String> NotationStack;
	
    private final static String OPS = "+-*/";
	  
	  
    private static String stackTop() {
       
    try {
         
    return (String) NotationStack.top();
    	
        } catch (StackUnderflowException x) {
        
        	   x.getMessage();
        }
             return null;
      }
    
    private static String stackPop() {
       try {
          
    	   return (String) NotationStack.pop();
        }
       catch (StackUnderflowException x) {
         
    	     x.getMessage();
        }
            return null;
      }
    
    private static boolean enqueue(String c) {
    	
           try {
        	   
                return NotationQueue.enqueue(c);
          
          
        } 
           
           catch (QueueOverflowException x) {
         
        	       x.getMessage();
        }
        return false;
      }
    
    private static boolean stackPush(String x) {
    	try {
    		
    		return NotationStack.push(x);
    		
    	}catch(StackOverflowException y) {
    		
    		y.getMessage();
    	}
    	
    	return false;
    }

    private static String dequeue() {
    	
    	try {
    		return NotationQueue.dequeue();
    	}catch(QueueUnderflowException x) {
    		
    		x.getMessage();
    		
    	}
    	
    	return null;
    	
    }
	/**Method ranks precedence of operators below
	 * 	@param x
	 * @return 1 if operator is +/-, 2 if *,
	 */
		
	public static int operatorPrcedence(char x) {
		
		switch (x) {
		case '+':
		case'-':
			return 0;
			
		case'*':
		case'/':
			return 1;
			
		default:
			System.out.println("Unknown operator");
				
				
		}
		
		return -1;
	}
	
	/**
	 * Method evaluates a postfix expression and returns a double
	 * @param postfixExpr
	 */

	public static double evaluatePostfixExpression(java.lang.String postfixExpr)
	                                        throws InvalidNotationFormatException{
		
		NotationStack = new NotationStack<String>();
		
		for(int k = 0; k < postfixExpr.length(); k++) {
			
			char c = postfixExpr.charAt(k);
		
		
		
		if (c == ' ') 
		{
	        continue;
	      } 
		
		else if (Character.isDigit(c) || c == '(') {
	        
			
			stackPush(Character.toString(c));
			
			
	      } else if (OPS.indexOf(c) >= 0) 
	      {
	            String x = stackPop().toString(), y;
	        
	        String eval;
	       
	        if (NotationStack.isEmpty()) {
	             
	        	throw new InvalidNotationFormatException();
	        } 
	        
	        else {
	         
	        	y = stackPop().toString();
	          
	                    eval = findOperator(y, x, c);
	          
	          stackPush(eval);
	        }
	    
	        
	      }
	   
		
		}
	  
		if (NotationStack.size() != 1) {
	      throw new InvalidNotationFormatException();
	    }
	    return Double.parseDouble(stackPop());


			
	}
	
	
	
		
	
		/**
		 * 
		 * Method that converts postfix to infix
		 * 
		 * @param postfix
		 * @return
		 * @throws InvalidNotationFormatException
		 */
	public static java.lang.String convertPostfixToInfix(java.lang.String postfix)
            throws InvalidNotationFormatException{
				
     NotationStack = new NotationStack<String>();
		
		
	 for (int k= 0; k < postfix.length(); k++) {
		 
		 
	      char c = postfix.charAt(k);
	      
	      if (c == ' ')
	    
	      {
	       
	    	  continue;
	      } else if (Character.isDigit(c))
	      
	      {
	        stackPush(Character.toString(c));
	        
	      } 
	      else if (OPS.indexOf(c) >= 0)
	      
	      {
	       
	    	  String x = stackPop().toString(), y, z;
	        if (NotationStack.isEmpty()) 
	        
	        {
	          
	        	throw new InvalidNotationFormatException();
	        } 
	        
	        else {
	          
	      y = stackPop().toString();
	      z = '(' + y + c + x + ')';
	          
	    
	    stackPush(z);
	        
	        }
	        
	      }
	      
	    }
	  
	 
	 if (NotationStack.size() != 1)
	 
	 {
	    
		 
	 throw new InvalidNotationFormatException();
	    }
	   
	 
	 return stackPop();
	
	}
	
	/**
	 * Converts infix to postfix method
	 * @param infix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static java.lang.String convertInfixToPostfix(java.lang.String infix)
            throws InvalidNotationFormatException{
		
		
		
		NotationQueue = new NotationQueue<String>();
        NotationStack = new NotationStack<String>();
		
		for(int k = 0; k < infix.length(); k++) {
			
			char c = infix.charAt(k);
			
			if(c == ' ') //if its a blank space
			{ 
				continue;
			}
			
			else if(Character.isDigit(c))// if its a digit
				{
				
			  enqueue(Character.toString(c));
			}
			else if(c == '(') {
				
				stackPush(Character.toString(c));
			}
			
			else if (OPS.indexOf(c) >= 0)
			{
		       while (!NotationStack.isEmpty() && operatorPrcedence(stackTop().charAt(0)) >= operatorPrcedence(c)) {
		          
		        	enqueue(stackPop());
		        }
		       
	        stackPush(Character.toString(c));
	        
	        
	      } else if (c == ')') {
	       
	        char topQueue = stackPop().charAt(0);
	       
	    	while (topQueue != '(') {
	         
	    		
	    		enqueue(Character.toString(topQueue));
	    		
	    			if (NotationStack.isEmpty()) {
	           
	        	  throw new InvalidNotationFormatException();
	          }
	          else {
	            
	        	  topQueue= stackPop().charAt(0);
	         
	          }
	       
	    	}
	     
	      
	      }
	    }
	   
		
				while (!NotationStack.isEmpty()) {
	      
					
					enqueue(stackPop());
	    }
	    
		
					return NotationQueue.toString();
		
			
		
		
		
			
		}

	/**
	 * Method that finds operator and evaluates them
	 * @param first
	 * @param second
	 * @param op
	 * @return
	 * @throws InvalidNotationFormatException
	 */

	private static String findOperator(String first, String second, char op)throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		
	    double x = Double.parseDouble(first);
	
        double y = Double.parseDouble(second);
	   
        		switch (op) {
	     
    		case '+':
	        
    	return Double.toString(x + y);
	      
    		case '-':
	      
    			
    			return Double.toString(x - y);
	     
    			case '*':
	        return Double.toString(x * y);
	     
    				case '/':
    		
    					if (y   ==  0)
	         
	        	
    						
    						throw new InvalidNotationFormatException();
	       
	        return Double.toString(x / y);
	        
	        
	    }
	   
    return null;
		
		
	}

	
	public static double evaluateInfixExpression (String infixExpr) throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		 
		String postfix = null;
		try {
			postfix = convertInfixToPostfix(infixExpr);
		} catch (InvalidNotationFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			return evaluatePostfixExpression(postfix);
		} catch (InvalidNotationFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return 0;
		
	}

}


