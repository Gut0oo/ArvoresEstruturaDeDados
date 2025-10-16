package Interativo;

import Node.BNode;

public class BstInte extends BTreeInte {
    public BstInte(BNode root){
        super(root);
    }

    public void insert(int valor){
        BNode novo = new BNode(valor);
        if(isEmpty()){
            setRoot(novo);
            return;
        }

        BNode atual = getRoot();

        while(atual != null){
            if(atual.getValor() < valor){
                if(atual.getRight() == null){
                    atual.setRight(novo);
                    novo.setParent(atual);
                }
                atual = atual.getRight();
            }else if(atual.getValor() > valor){
                if(atual.getLeft() == null){
                    atual.setLeft(novo);
                    novo.setParent(atual);
                }
                atual = atual.getLeft();
            }else{
                break;
            }
        }
    }

    public BNode search(int valor){
        BNode atual = getRoot();

        while(atual != null){
            if(atual.getValor() == valor){
                return atual;
            }

            atual = (atual.getValor() > valor) ? atual.getLeft() : atual.getRight();
        }

        return null;
    }

    public void delete(int valor){
        BNode alvo = search(valor);
        if(alvo == null) return;

        BNode pai = alvo.getParent();


        if(alvo.isLeaf()){
            if(pai == null){
                setRoot(null);
            }else {
                if (pai.getLeft() == alvo) {
                    pai.setLeft(null);
                } else if (pai.getRight() == alvo) {
                    pai.setRight(null);
                }
            }
        }else if(alvo.getDegree() == 1){
            BNode filho = null;
            if(alvo.getLeft() != null){
                filho = alvo.getLeft();
                alvo.setLeft(null);
            }else if(alvo.getRight() != null){
                filho = alvo.getRight();
                alvo.setRight(null);
            }

            if(pai == null){
                setRoot(filho);
            }else {
                if (pai.getLeft() == alvo) {
                    pai.setLeft(filho);
                } else if (pai.getRight() == alvo) {
                    pai.setRight(filho);
                }
                filho.setParent(pai);
            }
        }else{
            BNode temp = findSucessor(valor);
            alvo.setValor(temp.getValor());
            BNode pai_temp = temp.getParent();

            if(temp.isLeaf()){
                if(pai_temp.getLeft() == temp){
                    pai_temp.setLeft(null);
                }else if(pai_temp.getRight() == temp){
                    pai_temp.setRight(null);
                }
            }else if(temp.getDegree() == 1){
                BNode filho = null;
                if(temp.getLeft() != null){
                    filho = temp.getLeft();
                    temp.setLeft(null);
                }else if(temp.getRight() != null){
                    filho = temp.getRight();
                    temp.setRight(null);
                }

                if(pai_temp.getLeft() == temp){
                    pai_temp.setLeft(filho);
                }else if(pai_temp.getRight() == temp){
                    pai_temp.setRight(filho);
                }
            }
        }
    }

    public BNode findMin(){
        BNode atual = getRoot();
        while(atual.getLeft() != null){
            atual = atual.getLeft();
        }


        return atual;
    }

    public BNode findMax(){
        BNode atual = getRoot();
        while(atual.getRight() != null){
            atual = atual.getRight();
        }

        return atual;
    }

    public BNode findPredecessor(int valor){
        BNode alvo = search(valor);
        BNode atual = alvo.getLeft();

        while(atual.getRight() != null){
            atual = atual.getRight();
        }

        return atual;
    }

    public BNode findSucessor(int valor){
        BNode alvo = search(valor);
        BNode atual = alvo.getRight();

        while(atual.getLeft() != null){
            atual = atual.getLeft();
        }

        return atual;
    }

}
