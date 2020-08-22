import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Sharoon Babu on 20/06/22
 */

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for(String product: products) {
            addToTree(product, 0, root);
        }

        List<List<String>> result = new ArrayList();
        traverse(root, result, searchWord, 0);
        return result;
    }


    private void traverse(Node root, List<List<String>> result, String searchWord, int index) {
        if(index == searchWord.length()) {
            return;
        }

        Node node = root.charVsNode.get(searchWord.charAt(index));
        if(node == null)
            return;

        List<String> res = new ArrayList();
        if(node.words.size() != 0) {
            res.addAll(node.words);
            result.add(res);
        }

        traverse(node, result, searchWord, index + 1);
    }


    private void addToTree(String product, int index, Node root) {
        if(index == product.length()) {
            root.words.add(product);
            return;
        }

        Character ch = product.charAt(index);
        Map<Character, Node> charVsNode = root.charVsNode;
        Node child = charVsNode.getOrDefault(ch, new Node());
        charVsNode.put(ch, child);
        root.words.add(product);
        addToTree(product, index + 1, child);
    }



    static class Node {
        List<String> words = new ArrayList();
        Map<Character, Node> charVsNode = new TreeMap();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }
}
