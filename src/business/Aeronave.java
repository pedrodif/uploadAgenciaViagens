package business;

public class Aeronave {
    private int capacidadePassageiros;
    private int capacidadeCargaKg;


    public Aeronave(int capacidadePassageiros, int capacidadeCargaKg) throws Exception{
        if(capacidadePassageiros % 6 != 0){
            throw new IllegalArgumentException("O numero total de assentos deve múltiplo de 6");
        }
        this.capacidadePassageiros = capacidadePassageiros;
        this.capacidadeCargaKg = capacidadeCargaKg;
    }
    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }
    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }
    public int getCapacidadeCargaKg() {
        return capacidadeCargaKg;
    }
    public void setCapacidadeCargaKg(int capacidadeCargaKg) {
        this.capacidadeCargaKg = capacidadeCargaKg;
    }

    
}
