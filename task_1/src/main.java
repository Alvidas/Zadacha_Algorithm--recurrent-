/**
 * Created by Альвидас on 03.03.2017.
 */
public class main {
    public static void main(String[] args) {

        Integer Price[] = {90, 100, 110, 120, 105, 85, 86, 71, 52, 101, 99, 106, 179};


        System.out.print("Массив цен: ");
        for (int iPrice = 0;
             iPrice < Price.length;
             ++iPrice) {

            System.out.print(Price[iPrice].toString());
            if (iPrice + 1 < Price.length) {
                System.out.print(", ");
            }
        }
        System.out.print("\n\n");



        // Calculate delta array

        Integer Delta[] = new Integer[Price.length - 1];
        for (int iDelta = 0;
             iDelta < Price.length - 1;
             ++iDelta) {

            Delta[iDelta] = Price[iDelta + 1] - Price[iDelta];
        }



        // Algorithm "recurrent"

        Integer bestStart = 0;
        Integer bestEnd = 0;
        Integer bestSumm = 0;

        Integer newStart = -1;
        Integer newEnd = 0; // not including end element
        Integer newSumm = 0;

        for (int iDelta = 0;
             iDelta < Price.length - 1;
             ++iDelta) {
            Integer delta = Delta[iDelta];

            if (newStart == -1) {
                newStart = iDelta;
                newEnd = iDelta + 1;
                newSumm = delta;
            } else {
                ++newEnd;
                newSumm += delta;
            }

            if (newSumm <= 0) {
                // Degenerate
                newStart = -1;
                newEnd = 0;
                newSumm = 0;
            } else if (newSumm > bestSumm) {
                bestStart = newStart;
                bestEnd = newEnd;
                bestSumm = newSumm;
            }

        }




        // Print results

        if (bestSumm == 0) {
            System.out.print("Лучше ничего не покупать :-(\n\n");
        } else {
            System.out.print("Купить лучше в день #" + bestStart.toString() +
                    " ($" + Price[bestStart].toString() + ")" +
                    " а продать в день #" + bestEnd.toString() +
                    " ($" + Price[bestEnd].toString() + ")" + "\n");
            System.out.print("Вы заработаете $" + bestSumm.toString() + "!!!\n");
        }

        /*

        Массив цен: 90, 100, 110, 120, 105, 85, 86, 71, 52, 101, 99, 106, 179

        Купить лучше в день #8 ($52) а продать в день #12 ($179)
        Вы заработаете $127!!!

        */
    }
}
