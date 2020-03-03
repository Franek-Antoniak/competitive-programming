#include "iostream"
#define nullptr NULL
using namespace std;

const int base = 1073741823;

struct Node {
  Node *lewy, *prawy;
  long long suma;

  Node() : lewy(nullptr), prawy(nullptr), suma(0) {}

  ~Node() {
    delete lewy;
    delete prawy;
  }

  Node *L() {
    if (lewy == nullptr)
      lewy = new Node();
    return lewy;
  }

  Node *R() {
    if (prawy == nullptr)
      prawy = new Node();
    return prawy;
  }

  void Dodaj(int p, int a, int b, long long x) {
    if (a > p or b < p)
      return;
    if (a == b) {
      // jeśli się spotkały przedziały tzn że mam jeden ten no śmieszny}
      suma += x;
      return;
    }
    L()->Dodaj(p, a, (a + b) / 2, x);
    R()->Dodaj(p, (a + b) / 2 + 1, b, x);
    suma = R()->suma + L()->suma;
  }

  long long Read(int a, int b, int x, int y) {
    if (y < a or x > b)
      return 0;
    if (x <= a and b <= y)
      return suma;
    return L()->Read(a, (a + b) / 2, x, y) +
           R()->Read((a + b) / 2 + 1, b, x, y);
  }
};

int main() {
  int n;
  Node drzewo;

  cin >> n;

  for (int i = 0; i < n; i++) {
    char a;
    cin >> a;
    if (a == 'A') {
      int x, v;
      cin >> x >> v;
      drzewo.Dodaj(x, 1, base, v);
    } else {
      int x, y;
      cin >> x >> y;
      cout << drzewo.Read(1, base, x, y) << "\n";
    }
  }
}
