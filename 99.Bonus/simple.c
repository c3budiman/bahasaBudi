#include <stdio.h>

int main() {
    int number;
    printf("Masukkan pin: ");
    scanf("%d", &number);
    if (number == 80)
    {
        printf("You entered %d.\n", number);
    }
    printf("pin yang kamu masukkan salah.");
  return 0;
}
