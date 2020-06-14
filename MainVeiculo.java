package MapaDispersao;
//Anuska Kepler, Victor Bona, Gabriel Panca

public class MainVeiculo {

    public static void main(String[] args) {
        Veiculo v = new Veiculo();
        v.setPlaca("AAA - 0123");
        v.setModelo("Hyundai Creta");
        v.setAno(2017);
        v.setProprietario("João da Silva");
        MapaDispersao<String, Veiculo> mp = new MapaDispersao(2000);
        mp.inserir(v.getPlaca(), v);
    }
}
