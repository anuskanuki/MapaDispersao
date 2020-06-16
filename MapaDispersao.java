//Anuska Kepler, Victor Bona, Gabriel Panca

public class MapaDispersao<K, T> {

    private int tamanho;
    private ListaEncadeada<NoMapa<K, T>> tabela[];

    private ItemLista itemLista;
    
    public MapaDispersao(int quantidade) {
        quantidade *= 2;
        this.tabela = new ListaEncadeada[getNumeroPrimoProximo(quantidade)];
    }
    
    private int getNumeroPrimoProximo(int quantidade) {
        boolean ehPrimo = checaPrimo(quantidade);
        while(!ehPrimo) {
            if(quantidade%2 == 0) {
                quantidade += 1;
            } else {
                quantidade += 2;
            }
            
            ehPrimo = checaPrimo(quantidade);
        }
        return quantidade;
    }
    
    private boolean checaPrimo(int numero) {
        for (int i = numero-1; i > 1; i--) {
            if(numero % i == 0)
                return false;
        }
        return true;
    }

    private int calcularHash(K chave) {
        int tamanho = tabela.length;
        return chave.hashCode() < 0 ? (chave.hashCode() * -1) % tamanho : chave.hashCode() % tamanho;
    }

    public boolean inserir(K chave, T dado) {
        if (chaveOcupada(chave)) {
            return false;
        }
        int indice = calcularHash(chave);
        if (tabela[indice] == null) {
            tabela[indice] = new ListaEncadeada();
        }
        NoMapa no = new NoMapa();
        no.setChave(chave);
        no.setInfo(dado);
        tabela[indice].insere(no);
        return true;
    }

    public T remover(K chave) {
        int indice = calcularHash(chave);
        if (tabela[indice] != null) {
            for (int i = 0; i < tabela[indice].getQuantidade(); i++) {
                if(tabela[indice].busca(i).getChave().equals(chave)) {
                    return (T)tabela[indice].retira(i).getInfo();
                }
            }
        }
        return null;
        
    }

    public T buscar(K chave) {
        int indice = calcularHash(chave);
        if (tabela[indice] != null) {
            for (int i = 0; i < tabela[indice].getQuantidade(); i++) {
                if(tabela[indice].busca(i).getChave().equals(chave)) {
                    return (T)tabela[indice].busca(i).getInfo();
                }
            }
        }
        return null;
    }

    public int quantosElementos() {
        int cont = 0;
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                cont += tabela[i].getQuantidade();
            }
        }
        return cont;
    }

    private boolean chaveOcupada(K chave) {
        int indice = calcularHash(chave);
        if (tabela[indice] != null) {
            for (int i = 0; i < tabela[indice].getQuantidade(); i++) {
                if(tabela[indice].busca(i).getChave().equals(chave)) {
                    return true;
                }
            }
        }
        return false;
    }
}
