package inclassQuizes.curvesAnalizer;


import java.util.*;

public class CurveAnalizer implements CurveAnalizable {

    List<String> openings = Arrays.asList("{", "[", "(");
    List<String> closings = Arrays.asList("}", "]", ")");
    final Map<String, String> map = new HashMap<>();
    {
        map.put("{", "}");
        map.put("(", ")");
        map.put("[", "]");
    }
    Stack<String> checkStack = new Stack<>();

    public boolean matches(String expr) {

        for(String c : expr.split("")){

            if(openings.contains(c)){
                checkStack.push(c);
            } else if(closings.contains(c)){
                if(checkStack.empty()){
                    return false;
                } else if(openings.indexOf(checkStack.peek()) == closings.indexOf(c)){
                    checkStack.pop();
                } else {
                    return false;
                }
            }

        }
        if(checkStack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesUsingMap(String str){
        for(String c : str.split("")){

            if(map.keySet().contains(c)){
                checkStack.push(c);
            } else if(map.values().contains(c)){
                if(checkStack.empty()){
                    return false;
                } else if(map.get(checkStack.pop()).equals(c)){
                } else {
                    return false;
                }
            }

        }
        return checkStack.empty();
    }

}
