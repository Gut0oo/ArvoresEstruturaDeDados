//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// -----------------------------
        // TESTE BST ITERATIVA
        // -----------------------------
        System.out.println("=== BST Iterativa ===");
        BstInte bstIter = new BstInte(null);

        // Inserção
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            bstIter.insert(v);
        }

        // Travessias
        System.out.print("Pré-ordem: ");
        bstIter.PreOrderInte();
        System.out.println();

        System.out.print("Em-ordem: ");
        bstIter.EmOrderInte();
        System.out.println();

        System.out.print("Pós-ordem: ");
        bstIter.posOrderInte();
        System.out.println();

        // Consultas
        System.out.println("Menor valor: " + bstIter.findMin().getValor());
        System.out.println("Maior valor: " + bstIter.findMax().getValor());
        System.out.println("Altura: " + bstIter.getHeightInte());
        System.out.println("Número total de nós: " + bstIter.numTotalNode());
        System.out.println("Número de folhas: " + bstIter.numTotalFolhas());
        System.out.println("Grau máximo: " + bstIter.getDegreeInte());

        // Busca
        int busca = 40;
        BNode result = bstIter.search(busca);
        System.out.println("Busca " + busca + ": " + (result != null ? "Encontrado" : "Não encontrado"));

        // Predecessor e Sucessor
        System.out.println("Predecessor de 50: " + bstIter.findPredecessor(50).getValor());
        System.out.println("Sucessor de 50: " + bstIter.findSucessor(50).getValor());

        // Remoção
        System.out.println("\nRemovendo 30 e 70...");
        bstIter.delete(30);
        bstIter.delete(70);

        System.out.print("Em-ordem após remoção: ");
        bstIter.EmOrderInte();
        System.out.println("\n");

        bstIter.clearAll();

        // -----------------------------
        // TESTE BST RECURSIVA
        // -----------------------------
        System.out.println("=== BST Recursiva ===");
        BstRec bstRec = new BstRec(null);

        // Inserção recursiva
        BNode rootRec = null;
        for (int v : valores) {
            rootRec = bstRec.insertRec(rootRec, v);
        }
        bstRec.setRoot(rootRec);

        // Travessias
        System.out.print("Pré-ordem: ");
        bstRec.preOrderRec(bstRec.getRoot());
        System.out.println();

        System.out.print("Em-ordem: ");
        bstRec.inOrderRec(bstRec.getRoot());
        System.out.println();

        System.out.print("Pós-ordem: ");
        bstRec.posOrderRec(bstRec.getRoot());
        System.out.println();

        // Busca
        result = bstRec.search(bstRec.getRoot(), 60);
        System.out.println("Busca 60: " + (result != null ? "Encontrado" : "Não encontrado"));

        // Remoção
        System.out.println("\nRemovendo 20 e 80...");
        bstRec.setRoot(bstRec.delete(bstRec.getRoot(), 20));
        bstRec.setRoot(bstRec.delete(bstRec.getRoot(), 80));

        System.out.print("Em-ordem após remoção: ");
        bstRec.inOrderRec(bstRec.getRoot());
        System.out.println();
    }
}