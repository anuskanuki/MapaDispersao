//Anuska Kepler, Victor Bona, Gabriel Panca

public class MainVeiculo {

    public static void main(String[] args) {
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setPlaca("AAA - 0123");
        veiculo1.setModelo("Hyundai Creta");
        veiculo1.setAno(2017);
        veiculo1.setProprietario("Marcelo da Silva");
        
        Veiculo veiculo2 = new Veiculo();
        veiculo2.setPlaca("AAB - 0102");
        veiculo2.setModelo("Fusca");
        veiculo2.setAno(2010);
        veiculo2.setProprietario("Gabriel");
        
        Veiculo veiculo3 = new Veiculo();
        veiculo3.setPlaca("CAS - 0103");
        veiculo3.setModelo("Fusca Azul");
        veiculo3.setAno(1998);
        veiculo3.setProprietario("Gabriel");
        
        Veiculo veiculo4 = new Veiculo();
        veiculo4.setPlaca("URN - 0104");
        veiculo4.setModelo("Mustang");
        veiculo4.setAno(1998);
        veiculo4.setProprietario("Gabriel");
        
        Veiculo veiculo5 = new Veiculo();
        veiculo5.setPlaca("POF - 0105");
        veiculo5.setModelo("Corolla");
        veiculo5.setAno(2010);
        veiculo5.setProprietario("Gabriel");
        
        Veiculo veiculo6 = new Veiculo();
        veiculo6.setPlaca("WJE - 0106");
        veiculo6.setModelo("Mini");
        veiculo6.setAno(2019);
        veiculo6.setProprietario("Gabriel");
        
        Veiculo veiculo7 = new Veiculo();
        veiculo7.setPlaca("XXX - 9999");
        veiculo7.setModelo("Ford T");
        veiculo7.setAno(2021);
        veiculo7.setProprietario("Emanuel");
        
        Veiculo veiculo8 = new Veiculo();
        veiculo8.setPlaca("XXX - 9999");
        veiculo8.setModelo("Ford T Repetido");
        veiculo8.setAno(2020);
        veiculo8.setProprietario("Anuska");
        
        
        MapaDispersao<String, Veiculo> mapa = new MapaDispersao(10);
        
        System.out.println("Esperado true: ");
        System.out.println(mapa.inserir(veiculo1.getPlaca(), veiculo1));
        System.out.println(mapa.inserir(veiculo2.getPlaca(), veiculo2));
        System.out.println(mapa.inserir(veiculo3.getPlaca(), veiculo3));
        System.out.println(mapa.inserir(veiculo4.getPlaca(), veiculo4));
        System.out.println(mapa.inserir(veiculo5.getPlaca(), veiculo5));
        System.out.println(mapa.inserir(veiculo6.getPlaca(), veiculo6));
        System.out.println(mapa.inserir(veiculo7.getPlaca(), veiculo7));
        
        System.out.println("Esperado false: ");
        System.out.println(mapa.inserir(veiculo8.getPlaca(), veiculo8));
        
        System.out.println("");
        
        System.out.println("Esperado 7: ");
        System.out.println(mapa.quantosElementos());
        
        System.out.println("");
        
        Veiculo veiculoRemovido = (Veiculo)mapa.remover(veiculo7.getPlaca());
        System.out.println("Esperado 'Veículo Ford T, placa XXX - 9999, ano 2021, de Emanuel': "+veiculoRemovido);
        
        
        System.out.println("");
        
        System.out.println("Esperado 6: ");
        System.out.println(mapa.quantosElementos());
        
        System.out.println("");
        
        System.out.println("Esperado 'Veículo Fusca, placa AAB - 0102, ano 2010, de Gabriel': " + mapa.buscar(veiculo2.getPlaca()));
        
        System.out.println("");
        
        System.out.println("Esperado null: ");
        System.out.println(mapa.buscar(veiculo8.getPlaca()));
    }
}
