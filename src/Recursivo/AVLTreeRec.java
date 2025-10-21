package Recursivo;

import Node.BNode;

public class AVLTreeRec extends BstRec{

    public AVLTreeRec(BNode root){
        super(root);
    }


    
    @Override
    public BNode insertRec(BNode atual, int valor){
        if (atual == null) {
            return new BNode(valor);
        }

        if(atual.getValor() > valor){
            atual.setLeft(insertRec(atual.getLeft(), valor));
        }else{
            atual.setRight(insertRec(atual.getRight(), valor));
        }

        updateBalance(atual);

        if(atual != null && (atual.getFB() < -1 || atual.getFB() > 1)){
            atual = balanceHelper(atual);
        }

        return atual;
    }

    public BNode balanceHelper(BNode atual){
        if(atual.getFB() == -2 && atual.getLeft() != null && atual.getLeft().getFB() == -1){
            rotateRight(atual);
        } else if(atual.getFB() == 2 && atual.getRight() != null && atual.getRight().getFB() == 1){
            rotateLeft(atual);
        } else if(atual.getFB() == 2 && atual.getRight() != null && atual.getRight().getFB() == -1){
            rotateRightLeft(atual);
        } else if(atual.getFB() == -2 && atual.getLeft() != null && atual.getLeft().getFB() == 1){
            rotateLeftRight(atual);
        }  

        return atual;
    }

    //O parametro "no" é a raiz da subarvore que precisa ser balanceada
    public BNode rotateRight(BNode no){
        boolean ehraiz = (no == getRoot()) ? true : false;

        BNode esq = no.getLeft();
        BNode temp = esq.getRight();

        no.setLeft(temp);
        if(temp != null){
            temp.setParent(no);
            updateBalance(temp);
        }  

        esq.setRight(no);
        no.setParent(esq);

        updateBalance(no);
        updateBalance(esq);

        if(ehraiz){
            setRoot(esq);
        }

        return esq;
    }

    public BNode rotateLeft(BNode no){
        boolean ehraiz = (no == getRoot()) ? true : false;

        BNode dir = no.getRight();
        BNode temp = dir.getLeft();

        no.setRight(temp);
        if(temp != null) {
            temp.setParent(no);
            updateBalance(temp);
        }

        dir.setLeft(no);
        no.setParent(dir);

        updateBalance(no);
        updateBalance(dir);
        
        if(ehraiz){
            setRoot(dir);
        }
        return dir;
    }

    public BNode rotateLeftRight(BNode no){
        no.setLeft(rotateLeft(no.getLeft()));
        return rotateRight(no);
    }

    public BNode rotateRightLeft(BNode no){
        no.setRight(rotateRight(no.getRight()));
        return rotateLeft(no);
    }

    public int getHeight(BNode no){
        if(no == null){
            return 0;
        }

        return 1 + Math.max(getHeight(no.getRight()), getHeight(no.getLeft()));
    }

    public int getBalance(BNode no){ //Pega o fator de balanceamento
        return getHeight(no.getLeft()) - getHeight(no.getRight());
    }

    public void updateBalance(BNode no){ //Atualiza o fator de Balanceamento
        no.setFB(getBalance(no));
    }
}
