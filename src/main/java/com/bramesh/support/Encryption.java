package com.bramesh.support;

public class Encryption {
	char[] key={'A', 'B', 'C', 'D', 'E', 'F'};
	
	public String encryptDecrypt(String input){
		StringBuilder output = new StringBuilder();
		
		for(int i=0;i<input.length();i++){
			output.append((char) (input.charAt(i)) ^ key.length);
		}
		
		return output.toString();
	}
		public void setEncryptKey(char[] key){
			this.key=key;
		}
}
