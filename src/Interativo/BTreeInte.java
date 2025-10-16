package Interativo;
import Node.BNode;

public class BTreeInte {
    private BNode root;

    public BTreeInte(BNode root) {
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

    public boolean isFull(){
        if(isEmpty()){
            return true;
        }

        BNode atual = root;
        BNode prox = null, anterior = null;

        while(atual != null){
            int count = 0;

            if(atual.getLeft() != null) count++;
            if(atual.getRight() != null) count++;

            if(!(count == 2) && !atual.isLeaf()){
                return false;
            }

            if(anterior == atual.getParent()){
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }

        return true;
    }

    //Esse metodo não estarei considerando que a regra de esquerda menor e direita maior
    public int maiorValorArvore(){
        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;
        int maior = atual.getValor();

        while(atual != null){
            if(maior < atual.getValor()){
                maior = atual.getValor();
            }

            if(anterior == atual.getParent()){ //vindo do pai - visitamos o pai apenas
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){ //vindo da esquerda - visitamos pai e filho esquerdo
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){ //Vindo da direita - visitamos tudo
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }

        return maior;
    }

    //Esse metodo não estarei considerando que a regra de esquerda menor e direita maior
    public int menorValorArvore(){
        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;
        int menor = atual.getValor();

        while(atual != null){
            if(menor > atual.getValor()){
                menor = atual.getValor();
            }

            if(anterior == atual.getParent()){ //vindo do pai - visitamos o pai apenas
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){ //vindo da esquerda - visitamos pai e filho esquerdo
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){ //Vindo da direita - visitamos tudo
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }

        return menor;
    }
    public int somaTotalNode(){
        int count = 0;

        BNode atual = root;
        BNode anterior = null;
        BNode prox = null;

        while(atual != null){
            if(anterior == atual.getParent()){
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    count += atual.getValor();
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    count += atual.getValor();
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                count += atual.getValor();
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }

        return count;
    }

    public int numTotalInternos(){
        int count = 0;
        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;

        while(atual != null){
            if(anterior == atual.getParent()){

                if(!atual.isLeaf()){
                    count++;
                }

                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }

        return count;
    }

    public int numTotalNode(){
        int count = 0;

        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;

        while(atual != null){
            if(anterior == atual.getParent()){
                count++;

                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }

        return count;
    }

    public int numTotalFolhas(){
        int count = 0;

        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;

        while(atual != null){
            if(atual.isLeaf()){
                count++;
            }

            if(anterior == atual.getParent()){
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }

        return count;
    }

    public int getDegreeInte(){
        if(isEmpty()){
            return 0;
        }
        int max = 0;

        BNode atual = root;
        BNode anterior = null;
        BNode prox = null;

        while(atual != null){
            int count = 0;
            if(atual.getLeft() != null) count++;
            if(atual.getRight() != null) count++;

            if(anterior == atual.getParent()){
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                prox = atual.getParent();
            }
            max = Math.max(max, count);

            anterior = atual;
            atual = prox;
        }

        return max;
    }

    public int getHeightInte(){
        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;

        int count = 0;
        int maxAltura = 0;

        while(atual != null){

            if(anterior == atual.getParent()){
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                prox = atual.getParent();
            }

            if(prox == atual.getRight() || prox == atual.getLeft()){
                count++;
                if(count > maxAltura) maxAltura = count;

            }else if(prox == atual.getParent()){
                count--;
            }

            anterior = atual;
            atual = prox;
        }

        return maxAltura;
    }

    public void PreOrderInte(){
        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;

        while(atual != null){

            if(anterior == atual.getParent()){
                System.out.print(atual.getValor() + " ");
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }
    }

    public void EmOrderInte(){
        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;

        while(atual != null){

            if(anterior == atual.getParent()){
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else{
                    System.out.print(atual.getValor() + " ");
                    if(atual.getRight() != null){
                        prox = atual.getRight();
                    }else{
                        prox = atual.getParent();
                    }
                }
            }else if(anterior == atual.getLeft()){
                System.out.print(atual.getValor() + " ");
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                prox = atual.getParent();
            }


            anterior = atual;
            atual = prox;
        }
    }

    public void posOrderInte(){
        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;

        while(atual != null){
            if(anterior == atual.getParent()){
                if(atual.getLeft() != null){
                    prox = atual.getLeft();
                }else if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    System.out.print(atual.getValor() + " ");
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getLeft()){
                if(atual.getRight() != null){
                    prox = atual.getRight();
                }else{
                    System.out.print(atual.getValor() + " ");
                    prox = atual.getParent();
                }
            }else if(anterior == atual.getRight()){
                System.out.print(atual.getValor() + " ");
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }
    }

    public void clearAll(){
        BNode atual = root;
        BNode prox = null;
        BNode anterior = null;

        while (atual != null) {
            // Descemos pela árvore
            if (anterior == atual.getParent()) {
                if (atual.getLeft() != null) {
                    prox = atual.getLeft();
                } else if (atual.getRight() != null) {
                    prox = atual.getRight();
                } else {
                    // Nó folha, remove dele do pai
                    if (atual.getParent() != null) {
                        if (atual.getParent().getLeft() == atual) {
                            atual.getParent().setLeft(null);
                        } else {
                            atual.getParent().setRight(null);
                        }
                    }
                    prox = atual.getParent();
                }
            }
            // Voltando da esquerda
            else if (anterior == atual.getLeft()) {
                if (atual.getRight() != null) {
                    prox = atual.getRight();
                } else {
                    // Remove nó se não tem mais filhos
                    if (atual.getParent() != null) {
                        if (atual.getParent().getLeft() == atual) {
                            atual.getParent().setLeft(null);
                        } else {
                            atual.getParent().setRight(null);
                        }
                    }
                    prox = atual.getParent();
                }
            }
            // Voltando da direita
            else { // anterior == atual.getRight()
                if (atual.getParent() != null) {
                    if (atual.getParent().getLeft() == atual) {
                        atual.getParent().setLeft(null);
                    } else {
                        atual.getParent().setRight(null);
                    }
                }
                prox = atual.getParent();
            }

            anterior = atual;
            atual = prox;
        }

        root = null;
    }
}
