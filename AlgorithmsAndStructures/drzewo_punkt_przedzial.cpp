// program który na początku wczytuje jakąś tablicę rozmiaru n
// i wykonuje na niej m operacji typu:
// dodaj coś do jednej komórki
// odczytaj sumę z przedziału

#include "bits/stdc++.h"

using namespace std;

const long long M = 1 << 20;
int n;
long long tab[1000006 + 10], tre[2 * M + 100];

// a i b to granice przedziału o jaki pytamy
// x to numer wierzchołka w którym jesteśmy
// l i p to najdalsze liście na lewo i prawo, których przodkiem jest wierzchołek
// x
long long suma_rekurencyjna(int x, int a, int b, int l, int p) {
  // wierzchołek nie pokrywa się z przedziałem
  if (b < l or p < a)
    return 0;

  // wierzchołek całkowicie pokrywa się z przedziałem
  if (a <= l and p <= b)
    return tre[x];

  // częściowo się pokrywa z przedziałem
  return suma_rekurencyjna(x * 2, a, b, l, (l + p) / 2) +
         suma_rekurencyjna(x * 2 + 1, a, b, (l + p) / 2 + 1, p);
}

// kod działa, możecie posymulować sobie trochę jak on chodzi
long long suma_iteracyjna(int a, int b) {
  // a i b będą jakby wskaźnikami, którymi chodzimy po drzewie
  // a przesuwamy 1 w lewo, b 1 w prawo i przenosimy do liści drzewa (+M)
  a += M - 1;
  b += M + 1;
  long long wynik = 0;

  while (a / 2 != b / 2) {
    // jeśli a jest lewym synem, to prawy sąsiad jest przedziałem bazowym
    if (a % 2 == 0)
      wynik += tre[a + 1];

    // jeśli b jest prawym synem, to lewy sąsiad jest przedziałem bazowym
    if (b % 2 == 1)
      wynik += tre[b - 1];

    // a i b idą poziom wyżej
    a /= 2;
    b /= 2;
  }
  return wynik;
}

// dodaje wartość v do x-tej komórki w tablicy
void add(int x, int v) {
  // ustawiamy x w odpowiednim liściu
  x += M;
  while (x != 0) {
    tre[x] += v;
    x /= 2;
  }
}

// funkcja, która obliczy nam początkowe wartości w komórkach w drzewie
// (!!!) nie zawsze trzeba jej używać
// ale akurat w tym przypadku się przyda
void init() {
  for (int i = 0; i < n; i++)
    tre[i + M] = tab[i];
  for (int i = M - 1; i > 0; i--)
    tre[i] = tre[2 * i] + tre[2 * i + 1];
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  cin >> n;
  for (int i = 0; i < n; i++)
    cin >> tab[i];

  // m to liczba zapytań
  int m;
  cin >> m;

  for (int i = 0; i < m; i++) {
    char co_zrobic;
    int a, b;
    cin >> co_zrobic >> a >> b;

    if (co_zrobic == '?') {
      // pytanie o sume
      // wybierzcie sobie sposób w jaki liczycie sumę
      cout << suma_rekurencyjna(1, a, b, 1, M - 1) << "\n";
      cout << suma_iteracyjna(a, b) << "\n";
    } else {
      // dodawanie liczby b w miejscu a;
      add(a, b);
    }
  }
}
