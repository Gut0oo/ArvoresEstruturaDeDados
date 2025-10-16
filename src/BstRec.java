public class BstRec extends BTreeRec {
    public BstRec(BNode root){
        super(root);
    }

    public BNode insertRec(BNode atual, int valor){
        if (atual == null) {
            return new BNode(valor);
        }

        if(atual.getValor() > valor){
            atual.setLeft(insertRec(atual.getLeft(), valor));
        }else{
            atual.setRight(insertRec(atual.getRight(), valor));
        }

        return atual;
    }

    public BNode search(BNode atual, int valor){
        if(atual == null){
            return null;
        }

        if(atual.getValor() == valor){
            return atual;
        }else if(atual.getValor() < valor){
            return search(atual.getRight(), valor);
        }else if(atual.getValor() > valor){
            return search(atual.getLeft(), valor);
        }else{
            return null;
        }
    }

    public BNode delete(BNode atual, int valor){
        if(atual == null){
            return null;
        }

        if(atual.getValor() < valor){
            atual.setRight(delete(atual.getRight(), valor));
        }else if(atual.getValor() > valor){
            atual.setLeft(delete(atual.getLeft(), valor));
        }else{
            if(atual.isLeaf()){
                return null;
            }else if(atual.getDegree() == 1){
                if(atual.getLeft() != null){
                    return atual.getLeft();
                }else{
                    return atual.getRight();
                }
            }else if(atual.getDegree() == 2){
                BNode temp = findMin(atual.getRight());
                atual.setValor(temp.getValor());
                atual.setRight(delete(atual.getRight(), temp.getValor()));
            }
        }
        return atual;
    }


    public BNode findMin(BNode atual){
        if(atual == null){
            return null;
        }

        if(atual.getLeft() == null){
            return atual;
        }

        return findMin(atual.getLeft());
    }

    public BNode findMax(BNode atual){
        if(atual == null){
            return null;
        }

        if(atual.getRight() == null){
            return atual;
        }

        return findMax(atual.getRight());
    }
}


