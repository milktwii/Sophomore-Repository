#include <iostream>
using namespace std;

void triangle(int shape)
{
  int split = (shape / 2 + 1);
  for (int rows = 0; rows < shape; rows++)
  {
    for (int col_outside = 0; col_outside < rows; col_outside++)
    {
      cout << "  ";
    }
    for (int col_inside = 0; col_inside < shape - rows; col_inside++)
    {
      if (rows == 0 ||
          col_inside == 0 ||
          col_inside == shape - rows - 1 ||
          rows + 1 >= split ||
          col_inside <= split - rows - 1)
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
  int shape;
  cout << "Enter size of the Triangle: ";
  cin >> shape;

  if (shape % 2 == 0)
  {
    cout << "The input is invalid. Please try again." << endl;
  }
  else
  {
    triangle(shape);
  }

  return 0;
}
