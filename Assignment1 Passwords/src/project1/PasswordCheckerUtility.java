package project1;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;





public class PasswordCheckerUtility {

	public PasswordCheckerUtility() {
		
	}
	

	
	/**
	 * Method that checks if the password is valid by using all other methods
	 * @param passwordString
	 * @return boolean
	 * @throws LengthException,NoDigitException,NoUpperAlphaException, NoLowerAlphaException,InvalidSequenceException, NoSpecialSymbolException
	 */
	public static boolean isValidPassword(java.lang.String passwordString)throws 
	LengthException,NoDigitException,NoUpperAlphaException, NoLowerAlphaException,InvalidSequenceException, NoSpecialSymbolException{
	
		
			
			return LengthChecker(passwordString) && SymbolChecker(passwordString) &&  InvalidSequenceChecker(passwordString) 
					&& LowerCaseChecker(passwordString) && UpperCaseChecker(passwordString) && DigitChecker(passwordString);
					
			
	
	}

	/**
	 * Method that checks if the password has a special symbol in it
	 * @param passwordString
	 * @return boolean
	 * @throws NoSpecialSymbolException
	 */
	private static boolean SymbolChecker(String passwordString)throws NoSpecialSymbolException {
		// TODO Auto-generated method stub
		
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
	    
		Matcher matcher = pattern.matcher(passwordString);
	   
		if (!matcher.find()) {
	      
			throw new NoSpecialSymbolException();
	    }
            return true;
		
	}
	
	/**
	 * Method that checks if the password has an invalid sequence of one case after another
	 * @param passwordString
	 * @return boolean
	 * @throws InvalidSequence exception
	 */

	private static boolean InvalidSequenceChecker(String passwordString)throws InvalidSequenceException {
		// TODO Auto-generated method stub
		
		
           int length = passwordString.length();
		
		    for(int k = 0; k < 	length; k++) {
			
			if((k + 1 < length) && (k + 2 < length)){
				
				if (((passwordString.charAt(k) == passwordString.charAt(k+1))) 
					
					&& (passwordString.charAt(k +1) == (passwordString.charAt(k+2)))){
						
					throw new InvalidSequenceException();
					}
					
				}
			}
		
		
     return true;
	}

	/**
	 * Method that checks if the password has a lowercase in it
	 * @param passwordString
	 * @return lower
	 * @throws NoLowerAlphaException
	 */
	private static boolean LowerCaseChecker(String passwordString)throws NoLowerAlphaException {
		// TODO Auto-generated method stub
		
		boolean lower = false;
        
		  for(int k = 0; k < passwordString.length(); k++) {
			
			if(!Character.isLowerCase(passwordString.charAt(k))) {
				
				if(k == passwordString.length()- 1) {
					
					throw new NoLowerAlphaException();
					
				}
			}
			
			else {
				lower= true;
			}
         }
         
         return lower;
	}
	/**
	 * Method that if the password has an uppercase in it
	 * @param passwordString
	 * @return upper
	 * @throws NoUpperAlphaException
	 */
	private static boolean UpperCaseChecker(String passwordString) throws NoUpperAlphaException{
		// TODO Auto-generated method stub
		
		boolean upper = false;
        
		  for(int k = 0; k < passwordString.length(); k++) {
			
			if(!Character.isUpperCase(passwordString.charAt(k))) {
				
				if(k == passwordString.length()- 1) {
					
					throw new NoUpperAlphaException();
				}
			}
			
			else {
				upper= true;
			}
       }
       
       return upper;
	}
		
	
	/**
	 * Method that checks if the password has a digit in it
	 * @param passwordString
	 * @return digit
	 * @throws NoDigitException
	 */

	private static boolean DigitChecker(String passwordString)throws NoDigitException{
		// TODO Auto-generated method stub
		
		boolean digit = false;
        
		  for(int k = 0; k < passwordString.length(); k++) {
			
			if(!Character.isDigit(passwordString.charAt(k))) {
				
				if(k == passwordString.length()- 1) {
					
					throw new NoDigitException();
					
				}
			}
			
			else {
				digit= true;
			}
         }
         
         return digit;
		
	}

	/**
	 * Method that checks the length of the password
	 * @param passwordString
	 * @return length
	 * @throws LengthException
	 */
	private static boolean LengthChecker(String passwordString)throws LengthException {
		// TODO Auto-generated method stub
		
		boolean length = false;
         
		if(passwordString.length() < 6 ) {
			
			throw new LengthException();
		}
		
		else {
			length = true;
		}
		
		return length;
	}
	
	/**
	 * Method that checks if the password is weak based on the length of the password
	 * @param passwordString
	 * @return boolean
	 */
	public static boolean isWeakPassword(java.lang.String passwordString) {
		
		return (passwordString.length() >= 6)&& (passwordString.length() < 10);
	}
	
	
	/**
	 * Method that gathers invalid passwords
	 * @param passwords
	 * @return invalidList
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords){
		
		ArrayList<String> invalidList= new ArrayList<String>();
		
		

		for (int i = 0 ; i < passwords.size() ; i++)
			
			try {
				isValidPassword(passwords.get(i));
				
			} catch (LengthException e) {
				
				
				invalidList.add(passwords.get(i) + "password should be at least 6 characters");
				
			} catch (NoDigitException e) {
				
				
				invalidList.add(passwords.get(i) + "password should contain at least 1 digit");
				
			} catch (NoUpperAlphaException e) {
				
				
				invalidList.add(passwords.get(i) + "password should contain at least one uppercase character");
				
			} catch (NoLowerAlphaException e) {
				
				
				invalidList.add(passwords.get(i) + "password should contain at least one lower case character");
				
			} catch (NoSpecialSymbolException e) {
				
				
				invalidList.add(passwords.get(i) + "password should contain at least one special character");
				
			} catch (InvalidSequenceException e) {
				
				
				invalidList.add(passwords.get(i) + "password should ontain at least one special character");
			}

		return invalidList;
		
	}


}
	

