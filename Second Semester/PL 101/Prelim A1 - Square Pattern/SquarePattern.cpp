#include <iostream>
using namespace std;

void square(int size, int shape)
{
  for (int row = 0; row < shape; row++)
  {
    for (int col = 0; col < shape; col++)
    {
      if (col == shape / 2 || row == shape / 2)
      {
        cout << "  ";
      }
      else if (
          (row == 0 && col != size) ||
          (col == 0 && row != size) ||
          (row == size - 1 && col != size) ||
          (col == size - 1 && row != size) ||
          (row == shape - 1 && col != size) ||
          (col == shape - 1 && row != size) ||
          (row == size + 1 && col != size) ||
          (col == size + 1 && row != size) ||
          (row + col == shape - 1) ||
          (col >= size != row <= size))
      {
        cout << "* ";
      }
      else
      {
        cout << "  ";
      }
    }
    cout << endl;
  }
}

int main()
{
  int size, shape;
  cout << "Enter size of pattern: ";
  cin >> size;
  shape = (size * 2) + 1;
  square(size, shape);

  return 0;
}