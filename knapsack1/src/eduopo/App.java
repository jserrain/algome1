package eduopo;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        Item[] items = new Item[4];

        items[0] = new Item(1, 2, 6);
        items[1] = new Item(2, 5, 15);
        items[2] = new Item(3, 4, 8);
        items[3] = new Item(4, 3, 9);

        // Ordenar: Relació valorPes & pes item
        Arrays.sort(items, Comparator
            .comparingDouble(Item::relacioValorPes).reversed()
            .thenComparingInt(Item::getPes));

        // Imprimir la informació dels ítems
        System.out.println("Array ordenat Relació Valor/pes & pes");
        mostraItems(items);

        // dades problema
        int W = 11; // capacitat motxilla
        int n = items.length;  // número de items

        int[][] B = new int[n+1][W+1];

        // omplim cas base 
        for (int i = 0; i < (n + 1); i++){
            B[0][i] = 0;    // columnes pes
            B[i][0] = 0;    // files guany items
        }

        for(int i = 1; i <= n; i++) {       // itera row::items
            for(int w = 1; w <= W; w++){    // itera col::capacitats dinàmica
                if (items[i-1].getPes() <= w) {    // mirem si item cap a la motxilla
                    B[i][w] = maxim(
                        items[i-1].getValor() + 
                        B[i-1][w-items[i-1].getPes()],
                        B[i-1][w]);
                } else {                               //sinó cap posem ??
                    B[i][w] = B[i-1][w];
                }
            }
        }

        mostraB(B);

        // Reconstruir solució
        int valorMaxim = B[n][W];
        ArrayList<Item> itemsSeleccionats = new ArrayList<>();
        int i = n;
        int w = W;

        while( i > 0 & w > 0 ){
            if(B[i][w] != B[i-1][W]){
                itemsSeleccionats.add(items[i-1]);
                w = w - items[i-1].getPes();
            }
            i--;
        }

        System.out.println("Valor màxim: " + valorMaxim);

        for (Item item : itemsSeleccionats) {
            System.out.println(item);
        }

    }

    // Donats dos valors a i b torna el més gran
    public static int maxim(int a, int b){
        return ( a > b )? a : b;
    }

    public static int mostraB(int[][] b){
        for (int i = 0; i <= b.length-1; i++){
            for (int j = 0; j <= b[i].length-1; j++){
                // System.out.print("b["+ i +"]["+ j + "]:" + b[i][j] + " " );
                System.out.print(b[i][j] + " " );
            }
            System.out.println();
        }

        return 0;
    }
    // Mostra contingut matriu items
    public static int mostraItems(Item[] item) {

        for (Item i : item) {
            System.out.println(i.toString());
        }

        return 0;
    }
}
