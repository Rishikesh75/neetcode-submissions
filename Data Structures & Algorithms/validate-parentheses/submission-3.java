class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        try
        {
            for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }

            else if(s.charAt(i) == ']'){
                
                if(stack.peek() != '[')
                    return false;
                else stack.pop();
            }

            else if(s.charAt(i) == '}'){
                if(stack.peek() != '{')
                    return false;
                else stack.pop();
            }

            else if(s.charAt(i) == ')'){
                if(stack.peek() != '(')
                    return false;
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        }
        catch(Exception ex){

            return false;
        }
        return true;
    }
}
