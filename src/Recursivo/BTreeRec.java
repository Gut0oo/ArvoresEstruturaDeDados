package Recursivo;

import Node.BNode;

public class BTreeRec {
    private BNode root;

    public BTreeRec(BNode root) {
        this.root = root;
    }

    public BNode getRoot(){
        return root;
    }

    public void setRoot(BNode root){
        this.root = root;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public boolean isFull(BNode atual){
        if(atual == null){
            return true;
        }

        if(atual.isLeaf()){
            return true;
        }

        if(atual.getLeft() == null || atual.getRight() == null){
            return false;
        }

        return isFull(atual.getRight()) && isFull(atual.getLeft());
    }

    public int maiorValorArvore(BNode atual){
        if(atual == null){
            return Integer.MIN_VALUE;
        }
        int maior_esq = maiorValorArvore(atual.getLeft());
        int maior_dir = maiorValorArvore(atual.getRight());

        return Math.max(atual.getValor(), Math.max(maior_esq, maior_dir));
    }
    public int menorValorArvore(BNode atual){
        if(atual == null){
            return Integer.MAX_VALUE;
        }

        int menor_esq = menorValorArvore(atual.getLeft());
        int menor_dir = menorValorArvore(atual.getRight());

        return Math.min(atual.getValor(), Math.min(menor_esq, menor_dir));
    }

    public int somaTotalNode(BNode atual){
        if(atual == null){
            return 0;
        }

        return atual.getValor() + somaTotalNode(atual.getLeft()) + somaTotalNode(atual.getRight());
    }

    public int numTotalNode(BNode atual){
        if(atual == null){
            return 0;
        }

        return 1 + numTotalNode(atual.getLeft()) + numTotalNode(atual.getRight());
    }

    public int numTotalFolhas(BNode atual){
        if(atual == null){
            return 0;
        }

        if(atual.isLeaf()){
            return 1;
        }

        return numTotalFolhas(atual.getLeft()) + numTotalFolhas(atual.getRight());
    }

    public int numTotalInternos(BNode atual){
        if(atual == null || atual.isLeaf()){
            return 0;
        }

        return 1 + numTotalInternos(atual.getLeft()) + numTotalInternos(atual.getRight());
    }

    public int getDegreeRec(BNode atual){
        if(atual == null){
            return 0;
        }

        int count = 0;
        if(atual.getLeft() != null) count++;
        if(atual.getRight() != null) count++;

        return Math.max(count, Math.max(getDegreeRec(atual.getLeft()), getDegreeRec(atual.getRight())));
    }

    public int getHeightRec(BNode atual){
        if(atual == null){
            return 0;
        }

        return 1 + Math.max(getHeightRec(atual.getRight()), getHeightRec(atual.getLeft()));
    }

    public void preOrderRec(BNode atual){
        if(atual != null){
            System.out.print(atual.getValor() + " ");
            preOrderRec(atual.getLeft());
            preOrderRec(atual.getRight());
        }
    }

    public void inOrderRec(BNode atual){
        if(atual != null){
            inOrderRec(atual.getLeft());
            System.out.print(atual.getValor() + " ");
            inOrderRec(atual.getRight());
        }
    }

    public void posOrderRec(BNode atual){
        if(atual != null){
            posOrderRec(atual.getLeft());
            posOrderRec(atual.getRight());
            System.out.print(atual.getValor() + " ");
        }
    }

    public void paragrafado(BNode atual){
        if(atual != null) {
            System.out.print(
                    "\nNó:" +
                            "\n     Valor: " + atual.getValor() +
                            "\n     Esquerda: " + ((atual.getLeft() != null) ? atual.getLeft().getValor() : null) +
                            "\n     Direita: " + ((atual.getRight() != null) ? atual.getRight().getValor() : null) +
                            "\n     FB: " + atual.getFB() +
                            "\n"
            );
            paragrafado(atual.getLeft());
            paragrafado(atual.getRight());
        }
    }

    public void clearAll(BNode atual){
        if(atual != null){
            clearAll(atual.getLeft());
            clearAll(atual.getRight());

            atual.setLeft(null);
            atual.setRight(null);
            atual.setParent(null);
        }

        root = null;
    }
}
