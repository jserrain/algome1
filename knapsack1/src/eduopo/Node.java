package eduopo;

public class Node {
    private int id;
    private int pes;
    private int valor;

    public Node (int id, int p, int v){
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

    @Override
    public String toString() {
        return "Node [Id=" + id + ", pes=" + pes + ", valor=" + valor + "]";
    }



}
