package eduopo;

import java.util.Arrays;
import java.util.Comparator;
 
public class App {
    public static void main(String[] args) throws Exception {
        int Capacitat_max = 11;
        Node[] nodes = new Node[4];

        nodes[0] = new Node(1,2,6);
        nodes[1] = new Node(2,5,15);
        nodes[2] = new Node(3,4,8);
        nodes[3] = new Node(4,3,9);

        // Imprimir la informació dels ítems
        System.out.println("Mostra array sense ordenar\n");

        for (Node node : nodes) {
            System.out.println(node.toString());
        }

        // Ordenar l'array per pes
        Arrays.sort(nodes, Comparator.comparingInt(Node::getPes));

        // Imprimir la informació dels ítems
        System.out.println("Mostrem Array ordenat per pers");

        for (Node node : nodes) {
            System.out.println(node.toString());
        }






    }
}
