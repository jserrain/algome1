package eduopo;

public class Item {
    private int id;
    private int pes;
    private int valor;

    public Item (int id, int p, int v){
        this.id = id;
        this.pes = p;
        this.valor = v;
    }

    public int getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }

    public int getPes() {
        return pes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(int v) {
        this.valor = v;
    }

    public void setPes(int p) {
        this.pes = p;
    }

    public double relacioValorPes() {
        return (double) this.valor / this.pes;
    }

    @Override
    public String toString() {
        return "Item [Id=" + id + ", pes=" + pes + ", valor=" + valor + ", Relació valor/pes= " + String.format("%.2f", relacioValorPes()) + "]";
    }



}
