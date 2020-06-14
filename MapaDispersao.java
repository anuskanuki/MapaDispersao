package MapaDispersao;
//Anuska Kepler, Victor Bona, Gabriel Panca

import listas.ItemLista;
import listas.ListaEncadeada;

public class MapaDispersao<K, T> {

    private int tamanho;
    private ListaEncadeada<NoMapa<K, T>> tabela[];
    private ListaEncadeada listaEncadeada;

    //private ItemLista itemLista;
    public MapaDispersao(int quantidade) {
        this.tabela = new ListaEncadeada[quantidade];
    }

    private int calcularHash(K chave) {
        int tamanho = tabela.length;
        return chave.hashCode() % tamanho;
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
            //return (T) tabela[indice].retira(no);
        }
        return null;
    }

    public T buscar(K chave) {
        int indice = calcularHash(chave);
        if (tabela[indice] != null) {
            NoMapa noMapa = new NoMapa();
            noMapa.setChave(chave);
            //ItemLista<NoMapa<K, T>> no = tabela[indice].buscar(noMapa);
//            if (no != null) {
//                return no.getInfo().getInfo();
//            }
        }
        return null;
    }

    public int quantosElementos() {
        int cont = 0;
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                //   ItemLista<NoMapa<K, T>> no = tabela[i].primeiro;
                // while (no != null) {
                //  cont++;
                //  no = no.getProximo();
                // }
            }
        }
        return cont;
    }

    private boolean chaveOcupada(K chave) {
        int indice = calcularHash(chave);
        if (tabela[indice] != null) {
            NoMapa noMapa = new NoMapa();
            noMapa.setChave(chave.hashCode());
            // ItemLista<NoMapa<K, T>> no = tabela[indice].primeiro;
//            while (no != null) {
//                if (no.getInfo().equals(chave)) {
//                    return true;
//                }
//                no = no.getProximo();
//            }
        }
        return false;
    }
}
