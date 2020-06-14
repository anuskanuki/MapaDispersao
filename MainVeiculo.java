//Anuska Kepler, Victor Bona, Gabriel Panca

public class MainVeiculo {

    public static void main(String[] args) {
        Veiculo v = new Veiculo();
        v.setPlaca("AAA - 0123");
        v.setModelo("Hyundai Creta");
        v.setAno(2017);
        v.setProprietario("JoÃ£o da Silva");
        MapaDispersao<String, Veiculo> mp = new MapaDispersao(2000);
        System.out.println(mp.inserir(v.getPlaca(), v));
        
        Veiculo v2 = new Veiculo();
        v2.setPlaca("AAA - 0124");
        v2.setModelo("Teste");
        v2.setAno(2015);
        v2.setProprietario("JoÃ£o ");
        System.out.println(mp.inserir(v2.getPlaca(), v2));
        
//        System.out.println(mp.remover(v.getPlaca()));
//        System.out.println(mp.inserir(v2.getPlaca(), v2));
        
        
        System.out.println(mp.quantosElementos());
        
    }
}
