//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    int rozmiar = 20;
    int[] tab = new int[rozmiar];

    // Losowanie liczb 0–9
    Random random = new Random();
    for (int i = 0; i <tab.length ; i++) {
        tab[i] = random.nextInt(10);
    }

    //Sortowanie tablicy
    Arrays.sort(tab);

    //Wyswietlanie uporządkowanych wartości
    System.out.println("Wylosowane i posortowane liczby:");
    for (int i = 0; i < tab.length; i++) {
        System.out.println(tab[i]);
    }
    System.out.println();

    //Obliczanie mody
    int moda = tab[0];              // na początek bierzemy pierwszą wartość
    int maxLicznik = 1;             // najdłuższa znaleziona seria
    int licznik = 1;                // licznik bieżącej serii

    for (int i = 1; i < rozmiar; i++) {
        if (tab[i] == tab[i - 1]) {
            licznik++;                  // ta sama liczba → wydłużamy serię
        } else {
            // seria się skończyła → sprawdzamy czy była najlepsza
            if (licznik > maxLicznik) {
                maxLicznik = licznik;
                moda = tab[i - 1];      // zapamiętujemy wartość, która miała tę serię
            }
            licznik = 1;                // resetujemy licznik dla nowej liczby
        }
    }

// Ostatnia seria – bardzo często o niej się zapomina!
    if (licznik > maxLicznik) {
        maxLicznik = licznik;
        moda = tab[rozmiar - 1];
    }
    // Obliczanie mediany (20 elementów → średnia z 10. i 11. elementu)
    double mediana = (tab[9]+tab[10])/2.0;

    System.out.println("Moda: "+moda);
    System.out.println("Mediana: "+mediana);

}
