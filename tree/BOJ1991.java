
package tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1991 {

    public static class Child {
        String left;
        String right;

        public Child(String left, String right){
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        HashMap<String, Child> tree = new HashMap<String, Child>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String val = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.put(val, new Child(left, right));
        }

        StringBuilder sb = new StringBuilder();

        // 전위 순회
        preOrder(sb, tree, "A");
        sb.append("\n");

        // 중위 순회
        inOrder(sb, tree, "A");
        sb.append("\n");

        // 후위 순회
        postOrder(sb, tree, "A");
        System.out.println(sb.toString());

    }

    public static void preOrder(StringBuilder sb, HashMap<String, Child> tree, String parent){
        if(parent.equals(".")) return;
        sb.append(parent);
        Child c = tree.get(parent);
        preOrder(sb, tree, c.left);
        preOrder(sb, tree, c.right);
    }

    public static void inOrder(StringBuilder sb, HashMap<String, Child> tree, String parent){
        if(parent.equals(".")) return;
        Child c = tree.get(parent);
        inOrder(sb, tree, c.left);
        sb.append(parent);
        inOrder(sb, tree, c.right);

    }

    private static void postOrder(StringBuilder sb, HashMap<String, Child> tree, String parent) {
        if(parent.equals(".")) return;
        Child c = tree.get(parent);
        postOrder(sb, tree, c.left);
        postOrder(sb, tree, c.right);
        sb.append(parent);
    }

}
