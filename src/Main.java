import Node.BNode;
import Interativo.*;
import Recursivo.*;

/*
Arthur Rodrigues Lourenço Soares- 10434424
Luiz Alberto Silva Mota - 10436776
Gustavo Melo Silva - 10438415
Marcus Ruiz Nishimura Baena - 10426044
*/

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("\n==== INSERÇÃO ====\n");

        System.out.println("\n=== Após Inserção da AVL 1 - Item A ===");
        AVLTreeRec avl = new AVLTreeRec(new BNode(1));
        avl.insert(2);
        avl.insert(3);

        System.out.println();
        avl.paragrafado(avl.getRoot());
        System.out.println();

        System.out.println("\n=== Após Inserção da AVL 2 - Item B ===");
        AVLTreeRec avl2 = new AVLTreeRec(new BNode(3));
        avl2.insert(2);
        avl2.insert(1);

        System.out.println();
        avl2.paragrafado(avl2.getRoot());
        System.out.println();

        System.out.println("\n=== Após Inserção da AVL 3 - Item C ===");
        AVLTreeRec avl3 = new AVLTreeRec(new BNode(3));
        avl3.insert(1);
        avl3.insert(2);

        System.out.println();
        avl3.paragrafado(avl3.getRoot());
        System.out.println();

        System.out.println("\n=== Após Inserção da AVL 4 - Item D ===");
        AVLTreeRec avl4 = new AVLTreeRec(new BNode(1));
        avl4.insert(3);
        avl4.insert(2);

        System.out.println();
        avl4.paragrafado(avl4.getRoot());
        System.out.println();

        System.out.println("\n=== Após Inserção da AVL 5 - Item E ===");
        AVLTreeRec avl5 = new AVLTreeRec(new BNode(5));
        avl5.insert(4);
        avl5.insert(3);
        avl5.insert(1);
        avl5.insert(2);
        avl5.insert(6);
        avl5.insert(7);
        avl5.insert(9);
        avl5.insert(8);

        System.out.println();
        avl5.paragrafado(avl5.getRoot());
        System.out.println();


        System.out.println("\n==== REMOÇÃO ====\n");

        System.out.println("\n=== Após deletar o 4 - Item F ===");
        avl5.delete(4);
        avl5.paragrafado(avl5.getRoot());
        System.out.println();

        System.out.println("\n=== Após deletar o 5 - Item G ===");
        avl5.delete(5);
        avl5.paragrafado(avl5.getRoot());
        System.out.println();

        System.out.println("\n=== Após deletar o 1 - Item H ===");
        avl5.delete(1);
        avl5.paragrafado(avl5.getRoot());
        System.out.println();
    }
}