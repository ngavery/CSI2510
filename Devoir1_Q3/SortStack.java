import java.util.Stack;

public class SortStack {

    //ÉCRIT PAR AVERY NG
    public static Stack<Integer> sort(Stack<Integer> inputStack) {
        
        Stack<Integer> tempStack = new Stack<>();
        
        while(!inputStack.isEmpty()) {

            Integer current = inputStack.pop();

            if(tempStack.isEmpty()) {
                tempStack.push(current);
            }

            else {
                Integer top = tempStack.peek();

                if (top <= current || tempStack.isEmpty()) {
                    tempStack.push(current);
                }
                else {
                    while (top > current && !tempStack.isEmpty()) {
                        inputStack.push(tempStack.pop());
                    }
                    tempStack.push(current);
                }
            }
        }

        while(!tempStack.isEmpty()) {
            inputStack.push(tempStack.pop());
        }
        return inputStack;
    }

    //J'ai inclu une méthode main pour tester mon algorithme
    public static void main(String[] args) {
        Stack<Integer> testStack = new Stack<>();

        testStack.push(10);
        testStack.push(9);
        testStack.push(11);
        testStack.push(-3);
        testStack.push(4);

        System.out.println("Initial stack: " + testStack);
        sort(testStack);
        System.out.println("Sorted stack: " + testStack);
    }
}