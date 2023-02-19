#include <iostream>
#include <algorithm>

using namespace std;
int main()
{
    int array_size;

    cout << "Enter the number of numbers you want to process:" << endl;
    cin >> array_size;

    int arr[array_size];

    for (int i = 0; i < array_size; i++)
    {
        cout << "Number " << i + 1 << ": " << endl;
        cin >> arr[i];
    }

    size_t length = sizeof(arr) / sizeof(arr[0]);
    sort(arr, arr + length);

    cout << "- - - ALL NUMBERS - - -" << endl;
    for (int i = 0; i < array_size; i++)
    {
        cout << arr[i] << endl;
    }
    cout << endl;

    cout << "- - - EVEN NUMBERS - - -" << endl;
    for (int i = 0; i < array_size; i++)
    {
        if (arr[i] % 2 == 0)
            cout << arr[i] << " " << endl;
    }
    cout << endl;

    cout << "- - - ODD NUMBERS - - -" << endl;
    for (int i = 0; i < array_size; i++)
    {
        if (arr[i] % 2 != 0)
            cout << arr[i] << " " << endl;
    }
    cout << endl;

    cout << "- - - ADDITION - - -" << endl;
    for (int i = 0; i < array_size; i++)
    {
        int sum = 0;
        for (int i = 0; i < length; i++)
        {
            sum = sum + arr[i];
        }

        cout << arr[i];
        if (i < length - 1)
        {
            cout << " + ";
        }
        else
        {
            cout << " = " << sum;
        }
    }
    cout << endl
         << endl;

    cout << "- - - SUBTRACTION - - -" << endl;
    for (int i = 0; i < array_size; i++)
    {
        int difference = arr[0] + arr[0];
        for (int i = 0; i < length; i++)
        {
            difference = difference - arr[i];
        }
        cout << arr[i];
        if (i < length - 1)
        {
            cout << " - ";
        }
        else
        {
            cout << " = " << difference;
        }
    }
    cout << endl
         << endl;

    cout << "- - - MULTIPLICATION - - -" << endl;
    for (int i = 0; i < array_size; i++)
    {
        int product = 1;
        for (int i = 0; i < length; i++)
        {
            product = product * arr[i];
        }

        cout << arr[i];
        if (i < length - 1)
        {
            cout << " * ";
        }
        else
        {
            cout << " = " << product;
        }
    }
    cout << endl;

    return 0;
}