#include <iostream>
// njit ID 31588410
using namespace std;

class Main
{
private:
    static const int boardDim = 8;
    int **visited;

    //public static int[] i = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
    //public static int[] j = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };
public:
    Main()
    {
        visited = new int *[boardDim];
        for (int i = 0; i < boardDim; i++)
        {
            visited[i] = new int[boardDim];
        }
    }

    bool limits(int x, int y)
    {
        if (x >= 0 && x < boardDim && y >= 0 && y < boardDim && visited[x][y] == -1)
        {
            return true;
        }
        return false;
    }

    void printMethod()
    {
        for (int x = 0; x < boardDim; x++)
        {
            for (int y = 0; y < boardDim; y++)
                cout << visited[x][y] << " ";
            cout << endl;
        }
    }
    bool knightTour(int x, int y, int there, int* moveX, int *moveY, int n)
    {
        int newX = 0;
        int newY = 0;

        if (there == boardDim * boardDim)
        {
            return true;
        }

        for (int i = 0; i < n; i++)
        {

            newX = x + moveX[i];
            newY = y + moveY[i];

            if (limits(newX, newY))
            {
                visited[newX][newY] = there;

                if (knightTour(newX, newY, there + 1, moveX, moveY, n))
                {
                    return true;
                }
                else
                {
                    visited[newX][newY] = -1;
                }
            }
        }

        return false;
    }

    bool work()
    {
        for (int k = 0; k < boardDim; k++)
        {
            for (int j = 0; j < boardDim; j++)
            {
                visited[k][j] = -1;
            }
        }

        visited[0][0] = 0;
        int moveX[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int n = 8;
        int moveY[] = {1, 2, 2, 1, -1, -2, -2, -1};

        if (!knightTour(0, 0, 1, moveX, moveY, n))
        {
            cout << ("No solution exists") << endl;
            return false;
        }
        else
        {
            printMethod();
        }
        return true;
    }
};
int main()
{

    //int[][] visited = new int[boardDim][boardDim];
    //int there = 1;
    Main KnightTour;

    KnightTour.work();
    return 0;
}
