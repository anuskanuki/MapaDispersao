//Anuska Kepler, Victor Bona, Gabriel Panca

public class NoMapa<K, T> {

    private K chave;
    private T info;

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NoMapa outro = (NoMapa) obj;
        if (!chave.equals(outro.getChave())) {
            return false;
        }
        return true;
    }

}
