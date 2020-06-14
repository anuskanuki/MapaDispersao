//Anuska Kepler, Victor Bona, Gabriel Panca


public class MapaDispersao<K, T> {

    private int tamanho;
    private ListaEncadeada<NoMapa<K, T>> tabela[];
    private ListaEncadeada listaEncadeada;

    private ItemLista itemLista;
    
    public MapaDispersao(int quantidade) {
        this.tabela = new ListaEncadeada[quantidade];
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
        no.setInfo(tabela);
        tabela[indice].insere(no);
        return true;
    }

    public T remover(K chave) {
        int indice = calcularHash(chave);
        if (tabela[indice] != null) {
            NoMapa no = new NoMapa();
            no.setChave(chave);
            for (int i = 0; i < tabela[indice].getQuantidade(); i++) {
                if(tabela[indice].busca(i).equals(no)) {
                    return (T)tabela[indice].retira(i);
                }
            }
        }
        return null;
        
    }

    public T buscar(K chave) {
        int indice = calcularHash(chave);
        if (tabela[indice] != null) {
            NoMapa noMapa = new NoMapa();
            noMapa.setChave(chave);
            
            for (int i = 0; i < tabela[indice].getQuantidade(); i++) {
                if(tabela[indice].busca(i).equals(noMapa)) {
                    return (T)tabela[indice].busca(i);
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
            NoMapa noMapa = new NoMapa();
            noMapa.setChave(chave);
            for (int i = 0; i < tabela[indice].getQuantidade(); i++) {
                if(tabela[indice].busca(i).equals(noMapa)) {
                    return true;
                }
            }
        }
        return false;
    }
}
