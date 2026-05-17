class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();

        for(var ch : s.toCharArray()){


            if(ch == '[' || ch == '{' || ch == '('){
                stack.push(ch);
            }


            if(ch == ']'){
                if(stack.isEmpty()||stack.peek() != '[')
                    return false;
                stack.pop();
            }

            if(ch == ')'){
                if(stack.isEmpty()||stack.peek() != '(')
                    return false;
                stack.pop();
            }

            if(ch == '}'){
                if(stack.isEmpty()||stack.peek() != '{')
                    return false;
                stack.pop();
            }
        }

        if(stack.isEmpty()) return true;

        return false;
    }
}
