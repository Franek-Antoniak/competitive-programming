// zadanie, które rozwiązuje ten kod jest następujące:
// mamy wypełnioną zerami tablicę długości n
// i mamy m zapytań postaci
// + a b v (na przedziale a b dodajemy w każdej komórce liczbę v)
// ? a (pytamy się co jest w komórce a)
#include "bits/stdc++.h"

using namespace std;

const long long M = 1 << 20;
int n;
long long tab[1000006 + 10], tre[2 * M + 100];

// a i b to granice przedziału na którym dodajemy
// x to numer wierzchołka w którym jesteśmy
// l i p to najdalsze liście na lewo i prawo, których przodkiem jest wierzchołek
// x
// v to wartość, którą dodajemy
void add_rekur(int x, int v, int a, int b, int l, int p) {
  // wierzchołek nie pokrywa się z przedziałem
  if (b < l or p < a)
    return;

  // wierzchołek całkowicie pokrywa się z przedziałem
  if (a <= l and p <= b) {
    tre[x] += v;
    return;
  }

  // częściowo się pokrywa z przedziałem
  add_rekur(x * 2, v, a, b, l, (l + p) / 2);
  add_rekur(x * 2 + 1, v, a, b, (l + p) / 2 + 1, p);
}

void add_iter(int a, int b, int v) {
  // a i b będą jakby wskaźnikami, którymi chodzimy po drzewie
  // a przesuwamy 1 w lewo, b 1 w prawo i przenosimy do liści drzewa (+M)
  a += M - 1;
  b += M + 1;

  while (a / 2 != b / 2) {
    // jeśli a jest lewym synem, to prawy sąsiad jest przedziałem bazowym
    if (a % 2 == 0)
      tre[a + 1] += v;

    // jeśli b jest prawym synem, to lewy sąsiad jest przedziałem bazowym
    if (b % 2 == 1)
      tre[b - 1] += v;

    // a i b idą poziom wyżej
    a /= 2;
    b /= 2;
  }
}

long long czytaj(int x) {
  x += M;
  long long wynik = 0;
  while (x != 0) {
    wynik += tre[x];
    x /= 2;
  }
  return wynik;
}

int main() {
  int m;
  cin >> n >> m;

  // ponieważ tablica jest na początku wypełniona zerami, to nie trzeba
  // wywoływać funckji init

  for (int i = 0; i < m; i++) {
    char co;
    cin >> co;

    if (co == '?') {
      // pytanie o punkt
      int x;
      cin >> x;
      cout << czytaj(x) << "\n";
    } else {
      int a, b, v;
      cin >> a >> b >> v;
      // wybierzcie sobie, z którego korzystacie
      add_rekur(1, v, a, b, 1, M - 1);
      // add_iter(a,b,v);
    }
  }
}
